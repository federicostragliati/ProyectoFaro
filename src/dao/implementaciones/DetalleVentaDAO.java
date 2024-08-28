package dao.implementaciones;

import dao.interfaces.IDetalleVentaDAO;
import dominio.DetalleVenta;
import shared.ConnectionSQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaDAO implements IDetalleVentaDAO {

    private ConnectionSQL sql;
    private String addSt;
    private String getSt;
    private String updateSt;
    private String selectAllSt;

    public DetalleVentaDAO() {
        sql = new ConnectionSQL();
        addSt = "INSERT INTO detalleventa (IDVenta, IDProducto, DetalleProducto, Cantidad, PrecioUnitario, PrecioPorCantidad) VALUES (?, ?, ?, ?, ?, ?);";
        getSt = "SELECT * FROM detalleventa WHERE ID = ?;";
        updateSt = "UPDATE detalleventa SET IDVenta = ?, IDProducto = ?, DetalleProducto = ?, Cantidad = ?, PrecioUnitario = ?, PrecioPorCantidad = ? WHERE ID = ?;";
        selectAllSt = "SELECT * FROM detalleventa;";
    }

    @Override
    public void createDetalleVenta(DetalleVenta dv) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(addSt);
            st.setInt(1, dv.getIdVenta());
            st.setInt(2, dv.getIdProducto());
            st.setString(3, dv.getDetalle());
            st.setBigDecimal(4, dv.getCantidad());
            st.setBigDecimal(5, dv.getPrecioUnitario());
            st.setBigDecimal(6, dv.getPrecioPorCantidad());
            st.executeUpdate();
            System.out.println("Detalle de venta agregado exitosamente");
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
    public DetalleVenta getDetalleVenta(int idDetalleVenta) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(getSt);
            st.setInt(1, idDetalleVenta);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new DetalleVenta(
                        resultSet.getInt("ID"),
                        resultSet.getInt("IDVenta"),
                        resultSet.getInt("IDProducto"),
                        resultSet.getString("DetalleProducto"),
                        resultSet.getBigDecimal("Cantidad"),
                        resultSet.getBigDecimal("PrecioUnitario"),
                        resultSet.getBigDecimal("PrecioPorCantidad"));
            } else {
                System.out.println("No se encontró ningún detalle de venta con el ID: " + idDetalleVenta);
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
    public List<DetalleVenta> getDetalleVentas() throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        List<DetalleVenta> detalles = new ArrayList<>();
        try {
            con = sql.getConnection();
            st = con.prepareStatement(selectAllSt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                detalles.add(new DetalleVenta(
                        rs.getInt("ID"),
                        rs.getInt("IDVenta"),
                        rs.getInt("IDProducto"),
                        rs.getString("DetalleProducto"),
                        rs.getBigDecimal("Cantidad"),
                        rs.getBigDecimal("PrecioUnitario"),
                        rs.getBigDecimal("PrecioPorCantidad")));
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
        return detalles;
    }

    @Override
    public void updateDetalleVenta(DetalleVenta dv) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(updateSt);
            st.setInt(1, dv.getIdVenta());
            st.setInt(2, dv.getIdProducto());
            st.setString(3, dv.getDetalle());
            st.setBigDecimal(4, dv.getCantidad());
            st.setBigDecimal(5, dv.getPrecioUnitario());
            st.setBigDecimal(6, dv.getPrecioPorCantidad());
            st.setInt(7, dv.getId());
            st.executeUpdate();
            System.out.println("Detalle de venta actualizado exitosamente");
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
    public boolean deleteDetalleVenta(int idDetalleVenta) throws SQLException, ClassNotFoundException, IOException {
       return false;
    }
}
