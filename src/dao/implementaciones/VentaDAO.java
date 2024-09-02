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
    private String selectLast;

    public VentaDAO() {
        sql = new ConnectionSQL();
        addSt = "INSERT INTO ventas (IDCliente, CUITCliente, FechaVenta, Descuentos , MetodoPagoPrimario, MontoPagoPrimario, MetodoPagoSecundario, MontoPagoSecundario, MontoFinal, Pagado, Completa, Entregada, Activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        getSt = "SELECT * FROM ventas WHERE `ID` = ?;";
        updateSt = "UPDATE ventas SET `IDCliente` = ?, `CUITCliente` = ?, `FechaVenta` = ?, Descuentos = ?,`MetodoPagoPrimario` = ?, `MontoPagoPrimario` = ?, `MetodoPagoSecundario` = ?, `MontoPagoSecundario` = ?, `MontoFinal` = ?, `Pagado` = ?, `Completa` = ?, `Entregada` = ?, `Activo` = ? WHERE `ID` = ?;";
        selectAllSt = "SELECT * FROM ventas;";
        selectLast = "SELECT * FROM ventas WHERE ID = (SELECT MAX(ID) FROM ventas);";
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
            st.setDate(3, new Date(v.getFechaVenta().getTime()));
            st.setInt(4, v.getDescuentos());// Convert java.util.Date to java.sql.Date
            st.setInt(5, v.getMetodoDePagoPrimario());
            st.setBigDecimal(6, v.getMontoDePagoPrimario());
            st.setInt(7, v.getMetodoDePagoSecundario());
            st.setBigDecimal(8, v.getMontoDePagoSecundario());
            st.setBigDecimal(9, v.getMontoFinal());
            st.setBoolean(10, v.isPagada());
            st.setBoolean(11, v.isCompleta());
            st.setBoolean(12, v.isEntregada());
            st.setBoolean(13, v.isActivo());
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
                        resultSet.getInt("ID"),
                        resultSet.getInt("IDCliente"),
                        resultSet.getString("CUITCliente"),
                        resultSet.getDate("FechaVenta"),
                        resultSet.getInt("Descuentos"), // java.sql.Date
                        resultSet.getInt("MetodoPagoPrimario"),
                        resultSet.getBigDecimal("MontoPagoPrimario"),
                        resultSet.getInt("MetodoPagoSecundario"),
                        resultSet.getBigDecimal("MontoPagoSecundario"),
                        resultSet.getBigDecimal("MontoFinal"),
                        resultSet.getBoolean("Pagado"),
                        resultSet.getBoolean("Completa"),
                        resultSet.getBoolean("Entregada"),
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
                        rs.getInt("ID"),
                        rs.getInt("IDCliente"),
                        rs.getString("CUITCliente"),
                        rs.getDate("FechaVenta"),// java.sql.Date
                        rs.getInt("Descuentos"),
                        rs.getInt("MetodoPagoPrimario"),
                        rs.getBigDecimal("MontoPagoPrimario"),
                        rs.getInt("MetodoPagoSecundario"),
                        rs.getBigDecimal("MontoPagoSecundario"),
                        rs.getBigDecimal("MontoFinal"),
                        rs.getBoolean("Pagado"),
                        rs.getBoolean("Completa"),
                        rs.getBoolean("Entregada"),
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
            st.setDate(3, new Date(v.getFechaVenta().getTime()));// Convert java.util.Date to java.sql.Date
            st.setInt(4,v.getDescuentos());
            st.setInt(5, v.getMetodoDePagoPrimario());
            st.setBigDecimal(6, v.getMontoDePagoPrimario());
            st.setInt(7, v.getMetodoDePagoSecundario());
            st.setBigDecimal(8, v.getMontoDePagoSecundario());
            st.setBigDecimal(9, v.getMontoFinal());
            st.setBoolean(10, v.isPagada());
            st.setBoolean(11, v.isCompleta());
            st.setBoolean(12, v.isEntregada());
            st.setBoolean(13, v.isActivo());
            st.setInt(14, v.getId());
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

    @Override
    public Venta getLastVenta() throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(selectLast);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new Venta(
                        resultSet.getInt("ID"),
                        resultSet.getInt("IDCliente"),
                        resultSet.getString("CUITCliente"),
                        resultSet.getDate("FechaVenta"),
                        resultSet.getInt("Descuentos"),// java.sql.Date
                        resultSet.getInt("MetodoPagoPrimario"),
                        resultSet.getBigDecimal("MontoPagoPrimario"),
                        resultSet.getInt("MetodoPagoSecundario"),
                        resultSet.getBigDecimal("MontoPagoSecundario"),
                        resultSet.getBigDecimal("MontoFinal"),
                        resultSet.getBoolean("Pagado"),
                        resultSet.getBoolean("Completa"),
                        resultSet.getBoolean("Entregada"),
                        resultSet.getBoolean("Activo"));
            } else {
                System.out.println("No se encontraron ventas");
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


}
