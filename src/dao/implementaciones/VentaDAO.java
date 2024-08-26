package dao.implementaciones;

import dao.interfaces.IVentaDAO;
import dominio.Venta;
import shared.ConnectionSQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO implements IVentaDAO {

    private ConnectionSQL sql;
    private String addSt;
    private String getSt;
    private String updateSt;
    private String selectAllSt;

    public VentaDAO() {
        sql = new ConnectionSQL();
        addSt = "INSERT INTO ventas (ID Cliente, CUIT Cliente, Fecha Venta, Metodo de Pago Primario, Monto de Pago Primario, Metodo de Pago Secundario, Monto de Pago Secundario, Monto Final, Pagado, Completa, Entregada, Activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        getSt = "SELECT * FROM ventas WHERE `ID Venta` = ?;";
        updateSt = "UPDATE ventas SET `ID Cliente` = ?, `CUIT Cliente` = ?, `Fecha Venta` = ?, `Metodo de Pago Primario` = ?, `Monto de Pago Primario` = ?, `Metodo de Pago Secundario` = ?, `Monto de Pago Secundario` = ?, `Monto Final` = ?, `Pagado` = ?, `Completa` = ?, `Entregada` = ?, `Activo` = ? WHERE `ID Venta` = ?;";
        selectAllSt = "SELECT * FROM ventas;";
    }

    @Override
    public void createVenta(Venta v) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(addSt);
            st.setInt(1, v.getIdCliente());
            st.setString(2, v.getCuitCliente());
            st.setDate(3, new Date(v.getFechaVenta().getTime())); // Convert java.util.Date to java.sql.Date
            st.setInt(4, v.getMetodoDePagoPrimario());
            st.setBigDecimal(5, v.getMontoDePagoPrimario());
            st.setInt(6, v.getMetodoDePagoSecundario());
            st.setBigDecimal(7, v.getMontoDePagoSecundario());
            st.setBigDecimal(8, v.getMontoFinal());
            st.setBoolean(9, v.isPagada());
            st.setBoolean(10, v.isCompleta());
            st.setBoolean(11, v.isEntregada());
            st.setBoolean(12, v.isActivo());
            st.executeUpdate();
            System.out.println("Venta agregada exitosamente");
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
    public Venta getVenta(int idVenta) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(getSt);
            st.setInt(1, idVenta);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new Venta(
                        resultSet.getInt("ID Venta"),
                        resultSet.getInt("ID Cliente"),
                        resultSet.getString("CUIT Cliente"),
                        resultSet.getDate("Fecha Venta"), // java.sql.Date
                        resultSet.getInt("Metodo de Pago Primario"),
                        resultSet.getBigDecimal("Monto de Pago Primario"),
                        resultSet.getInt("Metodo de Pago Secundario"),
                        resultSet.getBigDecimal("Monto de Pago Secundario"),
                        resultSet.getBoolean("Pagado"),
                        resultSet.getBoolean("Completa"),
                        resultSet.getBoolean("Entregada"),
                        resultSet.getBigDecimal("Monto Final"),
                        resultSet.getBoolean("Activo"));
            } else {
                System.out.println("No se encontró ninguna venta con el ID: " + idVenta);
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
    public List<Venta> getVentas() throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        List<Venta> ventas = new ArrayList<>();
        try {
            con = sql.getConnection();
            st = con.prepareStatement(selectAllSt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ventas.add(new Venta(
                        rs.getInt("ID Venta"),
                        rs.getInt("ID Cliente"),
                        rs.getString("CUIT Cliente"),
                        rs.getDate("Fecha Venta"), // java.sql.Date
                        rs.getInt("Metodo de Pago Primario"),
                        rs.getBigDecimal("Monto de Pago Primario"),
                        rs.getInt("Metodo de Pago Secundario"),
                        rs.getBigDecimal("Monto de Pago Secundario"),
                        rs.getBoolean("Pagado"),
                        rs.getBoolean("Completa"),
                        rs.getBoolean("Entregada"),
                        rs.getBigDecimal("Monto Final"),
                        rs.getBoolean("Activo")));
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
        return ventas;
    }

    @Override
    public void updateVenta(Venta v) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(updateSt);
            st.setInt(1, v.getIdCliente());
            st.setString(2, v.getCuitCliente());
            st.setDate(3, new Date(v.getFechaVenta().getTime())); // Convert java.util.Date to java.sql.Date
            st.setInt(4, v.getMetodoDePagoPrimario());
            st.setBigDecimal(5, v.getMontoDePagoPrimario());
            st.setInt(6, v.getMetodoDePagoSecundario());
            st.setBigDecimal(7, v.getMontoDePagoSecundario());
            st.setBigDecimal(8, v.getMontoFinal());
            st.setBoolean(9, v.isPagada());
            st.setBoolean(10, v.isCompleta());
            st.setBoolean(11, v.isEntregada());
            st.setBoolean(12, v.isActivo());
            st.setInt(13, v.getId());
            st.executeUpdate();
            System.out.println("Venta actualizada exitosamente");
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
    public boolean deleteVenta(int idVenta) throws SQLException, ClassNotFoundException, IOException {
        try {
            Venta venta = getVenta(idVenta);
            if (venta != null) {
                venta.setActivo(false);
                updateVenta(venta);
                System.out.println("Venta desactivada exitosamente");
                return true;
            } else {
                System.out.println("Venta no encontrada");
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace(); //
        }
        return false;
    }
}
