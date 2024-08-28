package dao.implementaciones;

import dao.interfaces.IDetalleCompraDAO;
import dominio.DetalleCompra;
import shared.ConnectionSQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleCompraDAO implements IDetalleCompraDAO {

    private ConnectionSQL sql;
    private String addSt;
    private String getSt;
    private String updateSt;
    private String selectAllSt;

    public DetalleCompraDAO() {
        sql = new ConnectionSQL();
        addSt = "INSERT INTO detallecompra (IDCompra, IDProducto, DetalleProducto, Cantidad, CostoUnitario, CostoPorCantidad) VALUES (?,?,?,?,?,?);";
        getSt = "SELECT * FROM detallecompra WHERE ID = ?;";
        updateSt = "UPDATE detallecompra SET IDCompra = ?, IDProducto = ?, DetalleProducto = ?, Cantidad = ?, CostoUnitario = ?, CostoPorCantidad = ? WHERE ID = ?;";
        selectAllSt = "SELECT * FROM detallecompra;";
    }

    @Override
    public void createDetalleCompra(DetalleCompra d) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(addSt);
            st.setInt(1, d.getIdCompra());
            st.setInt(2, d.getIdProducto());
            st.setString(3, d.getDetalle());
            st.setBigDecimal(4, d.getCantidad());
            st.setBigDecimal(5, d.getCostoUnitario());
            st.setBigDecimal(6, d.getCostoPorCantidad());
            st.executeUpdate();
            System.out.println("Detalle de compra agregado exitosamente");
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
    public DetalleCompra getDetalleCompra(int idDetalleCompra) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(getSt);
            st.setInt(1, idDetalleCompra);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new DetalleCompra(
                        resultSet.getInt("ID"),
                        resultSet.getInt("IDCompra"),
                        resultSet.getInt("IDProducto"),
                        resultSet.getString("DetalleProducto"),
                        resultSet.getBigDecimal("Cantidad"),
                        resultSet.getBigDecimal("CostoUnitario"),
                        resultSet.getBigDecimal("CostoPorCantidad"));
            } else {
                System.out.println("No se encontró ningún detalle de compra con el ID: " + idDetalleCompra);
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
    public List<DetalleCompra> getDetalleCompras() throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        List<DetalleCompra> detallesCompra = new ArrayList<>();
        try {
            con = sql.getConnection();
            st = con.prepareStatement(selectAllSt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                detallesCompra.add(new DetalleCompra(
                        rs.getInt("ID"),
                        rs.getInt("IDCompra"),
                        rs.getInt("IDProducto"),
                        rs.getString("DetalleProducto"),
                        rs.getBigDecimal("Cantidad"),
                        rs.getBigDecimal("CostoUnitario"),
                        rs.getBigDecimal("CostoPorCantidad")));
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
        return detallesCompra;
    }


    @Override
    public void updateDetalleCompra(DetalleCompra d) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(updateSt);
            st.setInt(1, d.getIdCompra());
            st.setInt(2, d.getIdProducto());
            st.setString(3, d.getDetalle());
            st.setBigDecimal(4, d.getCantidad());
            st.setBigDecimal(5, d.getCostoUnitario());
            st.setBigDecimal(6, d.getCostoPorCantidad());
            st.setInt(7, d.getId());
            st.executeUpdate();
            System.out.println("Detalle de compra actualizado exitosamente");
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

    //Al "eliminar la compra" el detalle de compra asociado queda invalido
    @Override
    public boolean deleteDetalleCompra(int idDetalleCompra) throws SQLException, ClassNotFoundException, IOException {
        // Similar a `deleteCompra`, puedes definir la lógica de eliminación si aplica, como desactivar
        // detalles de compra en lugar de eliminarlos físicamente.
        // No hay lógica de desactivación en la tabla `detalle compra`, por lo que se eliminaría directamente
        // con un DELETE físico si se requiere.
        return false;
    }
}
