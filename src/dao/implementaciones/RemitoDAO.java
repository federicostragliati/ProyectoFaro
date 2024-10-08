package dao.implementaciones;

import dao.interfaces.IRemitoDAO;
import dominio.Remito;
import net.sf.jasperreports.engine.*;
import shared.ConnectionSQL;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemitoDAO implements IRemitoDAO {

    private ConnectionSQL sql;
    private String addSt;
    private String getSt;
    private String updateSt;
    private String selectAllSt;

    public RemitoDAO() {
        sql = new ConnectionSQL();
        addSt = "INSERT INTO remitos (Linea, IDVenta, FechaEntrega, IDCliente, NombreCliente, CUITCliente, Factura, IDProducto, Cantidad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        getSt = "SELECT * FROM remitos WHERE ID = ?;";
        updateSt = "UPDATE remitos SET FechaEntrega = current_date() WHERE IDVenta = ?;";
        selectAllSt = "SELECT * FROM remitos;";
    }

    @Override
    public void createRemito(Remito r) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(addSt);
            st.setInt(1, r.getLinea());
            st.setInt(2, r.getIdVenta());
            st.setDate(3, new Date(r.getFechaEntrega().getTime()));
            st.setInt(4, r.getIdCliente());
            st.setString(5, r.getNombreCliente());
            st.setString(6, r.getCuitCliente());
            st.setString(7, r.getNroFactura());
            st.setInt(8, r.getIdProducto());
            st.setBigDecimal(9, r.getCantidadProducto());
            st.executeUpdate();
            System.out.println("Remito agregado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Remito getRemito(int idRemito) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(getSt);
            st.setInt(1, idRemito);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new Remito(
                        resultSet.getInt("ID"),
                        resultSet.getInt("Linea"),
                        resultSet.getInt("IDVenta"),
                        resultSet.getDate("FechaEntrega"),
                        resultSet.getInt("IDCliente"),
                        resultSet.getString("NombreCliente"),
                        resultSet.getString("CUITCliente"),
                        resultSet.getString("Factura"),
                        resultSet.getInt("IDProducto"),
                        resultSet.getString("DetalleProducto"),
                        resultSet.getBigDecimal("Cantidad"));
            } else {
                System.out.println("No se encontró ningún remito con el ID: " + idRemito);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Remito> getRemitos() throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        List<Remito> remitos = new ArrayList<>();
        try {
            con = sql.getConnection();
            st = con.prepareStatement(selectAllSt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                remitos.add(new Remito(
                        rs.getInt("ID"),
                        rs.getInt("Linea"),
                        rs.getInt("IDVenta"),
                        rs.getDate("FechaEntrega"),
                        rs.getInt("IDCliente"),
                        rs.getString("NombreCliente"),
                        rs.getString("CUITCliente"),
                        rs.getString("Factura"),
                        rs.getInt("IDProducto"),
                        rs.getString("DetalleProducto"),
                        rs.getBigDecimal("Cantidad")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
                System.out.println("Conexión Cerrada");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return remitos;
    }

    @Override
    public void updateRemito(int id) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(updateSt);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Remito actualizado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean deleteRemito(int idRemito) throws SQLException, ClassNotFoundException, IOException {
        try {
            Remito remito = getRemito(idRemito);
            if (remito != null) {
                // Eliminar lógica de negocio si es necesario
                System.out.println("Remito desactivado exitosamente");
                return true;
            } else {
                System.out.println("Remito no encontrado");
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void generarRemito(int id) {
        try {
            String userHome = System.getProperty("user.home");
            String downloadsPath = userHome + "/Downloads/RemitoNro" + id + ".pdf";

            // Cargar el archivo .jrxml desde el classpath
            InputStream reportStream = getClass().getClassLoader().getResourceAsStream("RemitoFaro.jrxml");

            if (reportStream == null) {
                throw new FileNotFoundException("El archivo RemitoFaro.jrxml no se encuentra en el classpath");
            }

            // Compilar el informe
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Parámetros
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("IDVenta", id);

            // Llenar el informe
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, sql.getConnection());

            // Exportar a PDF usando JasperReports
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(downloadsPath));

            exporter.exportReport(); // Exportar

        } catch (JRException | IOException e) {
            e.printStackTrace(); // Muestra detalles del error
        }
    }


}
