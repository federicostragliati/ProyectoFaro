package dao.implementaciones;

import dao.interfaces.IReciboDAO;
import dominio.Recibo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import shared.ConnectionSQL;

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

public class ReciboDAO implements IReciboDAO {

    private ConnectionSQL sql;
    private String addSt;
    private String getSt;
    private String updateSt;
    private String selectAllSt;

    public ReciboDAO() {
        sql = new ConnectionSQL();
        addSt = "INSERT INTO recibos (IDVenta, FechaRecibo, IDCliente, NombreCliente, CUITCliente, `DineroRecibido(Texto)`, `DineroRecibido(Numero)`, FechadePago, NroFactura, MetodoPagoPrimario, MontodePagoPrimario, MetodoPagoSecundario, MontoPagoSecundario, MontoFinal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        getSt = "SELECT * FROM recibos WHERE ID = ?;";
        updateSt = "UPDATE recibos SET FechaRecibo = current_date(), NroFactura = ? WHERE IDVenta = ?;";
        selectAllSt = "SELECT * FROM recibos;";
    }

    @Override
    public void createRecibo(Recibo r) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(addSt);
            st.setInt(1, r.getIdVenta());
            st.setDate(2, new Date(r.getFechaRecibo().getTime()));
            st.setInt(3, r.getIdCliente());
            st.setString(4, r.getNombreCliente());
            st.setString(5, r.getCuitCliente());
            st.setString(6, r.getTextoDineroRecibido());
            st.setBigDecimal(7, r.getNroDineroRecibido());
            st.setDate(8, new Date(r.getFechaPago().getTime()));
            st.setString(9, r.getFactura());
            st.setInt(10, r.getMetodoDePagoPrimario());
            st.setBigDecimal(11, r.getMontoDePagoPrimario());
            st.setInt(12, r.getMetodoDePagoSecundario());
            st.setBigDecimal(13, r.getMontoDePagoSecundario());
            st.setBigDecimal(14, r.getMontoFinal());
            st.executeUpdate();
            System.out.println("Recibo agregado exitosamente");
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
    public Recibo getRecibo(int idRecibo) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(getSt);
            st.setInt(1, idRecibo);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new Recibo(
                        resultSet.getInt("ID"),
                        resultSet.getInt("IDVenta"),
                        resultSet.getDate("FechaRecibo"),
                        resultSet.getInt("IDCliente"),
                        resultSet.getString("NombreCliente"),
                        resultSet.getString("CUITCliente"),
                        resultSet.getString("DineroRecibido(Texto)"),
                        resultSet.getBigDecimal("DineroRecibido(Numero)"),
                        resultSet.getDate("FechadePago"),
                        resultSet.getString("NroFactura"),
                        resultSet.getInt("MetodoPagoPrimario"),
                        resultSet.getBigDecimal("MontodePagoPrimario"),
                        resultSet.getInt("MetodoPagoSecundario"),
                        resultSet.getBigDecimal("MontoPagoSecundario"),
                        resultSet.getBigDecimal("MontoFinal"));
            } else {
                System.out.println("No se encontró ningún recibo con el ID: " + idRecibo);
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
    public List<Recibo> getRecibos() throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        List<Recibo> recibos = new ArrayList<>();
        try {
            con = sql.getConnection();
            st = con.prepareStatement(selectAllSt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                recibos.add(new Recibo(
                        rs.getInt("ID"),
                        rs.getInt("IDVenta"),
                        rs.getDate("FechaRecibo"),
                        rs.getInt("IDCliente"),
                        rs.getString("NombreCliente"),
                        rs.getString("CUITCliente"),
                        rs.getString("DineroRecibido(Texto)"),
                        rs.getBigDecimal("DineroRecibido(Numero)"),
                        rs.getDate("FechadePago"),
                        rs.getString("NroFactura"),
                        rs.getInt("MetodoPagoPrimario"),
                        rs.getBigDecimal("MontodePagoPrimario"),
                        rs.getInt("MetodoPagoSecundario"),
                        rs.getBigDecimal("MontoPagoSecundario"),
                        rs.getBigDecimal("MontoFinal")));
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
        return recibos;
    }

    @Override
    public void updateRecibo(int id, String factura) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(updateSt);
            st.setString(1, factura);
            st.setInt(2, id);
            st.executeUpdate();
            System.out.println("Recibo actualizado exitosamente");
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
    public boolean deleteRecibo(int idRecibo) throws SQLException, ClassNotFoundException, IOException {
        try {
            Recibo recibo = getRecibo(idRecibo);
            if (recibo != null) {
                // Eliminar lógica de negocio si es necesario
                System.out.println("Recibo desactivado exitosamente");
                return true;
            } else {
                System.out.println("Recibo no encontrado");
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void generarRecibo(int id) {
        try {
            String userHome = System.getProperty("user.home");
            String downloadsPath = userHome + "/Downloads/ReciboNro" + id + ".pdf";

            // Cargar el archivo .jrxml desde el classpath
            InputStream reportStream = getClass().getClassLoader().getResourceAsStream("ReciboFaro.jrxml");

            if (reportStream == null) {
                throw new FileNotFoundException("El archivo ReciboFaro.jrxml no se encuentra en el classpath");
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
