package dao.implementaciones;

import dao.interfaces.IProductoDAO;
import dominio.Producto;
import dominio.enums.Unidad;
import shared.ConnectionSQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductoDAOImpMySQL implements IProductoDAO {

    private ConnectionSQL sql;
    private String addSt;
    private String getSt;
    private String updateSt;
    private String selectAllSt;

    public ProductoDAOImpMySQL() {
        sql = new ConnectionSQL();
        addSt = "INSERT INTO productos (Detalle, Cantidad, PrecioUnitario, UnidadVenta, Activo) VALUES (?,?,?,?,?);";
        getSt =  "SELECT * FROM productos WHERE ID = ?;";
        updateSt = "UPDATE productos SET Detalle = ?, Cantidad = ?, PrecioUnitario = ?, UnidadVenta = ?, Activo = ? WHERE ID = ?;";
        selectAllSt =  "SELECT * FROM productos;";
    }

    @Override
    public void createProducto(Producto p) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(addSt);
            st.setString(1, p.getDetalle());
            st.setBigDecimal(2, p.getCantidad());
            st.setBigDecimal(3, p.getPrecioUnitario());
            st.setString(4, p.getUnidad().toString());
            st.setBoolean(5, p.isActivo());
            st.executeUpdate();
            System.out.println("Producto agregado exitosamente");
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
    public Producto getProducto(int idProducto) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(getSt);
            st.setInt(1, idProducto);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Producto(
                        rs.getInt("ID"),
                        rs.getString("Detalle"),
                        rs.getBigDecimal("Cantidad"),
                        rs.getBigDecimal("PrecioUnitario"),
                        Unidad.valueOf(rs.getString("UnidadVenta")),
                        rs.getBoolean("Activo"));
            } else {
                System.out.println("No se encontró ningún producto con el ID: " + idProducto);
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
    public List<Producto> getProductos() throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        List<Producto> productos = new ArrayList<>();
        try {
            con = sql.getConnection();
            st = con.prepareStatement(selectAllSt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                productos.add(new Producto(
                        rs.getInt("ID"),
                        rs.getString("Detalle"),
                        rs.getBigDecimal("Cantidad"),
                        rs.getBigDecimal("PrecioUnitario"),
                        Unidad.valueOf(rs.getString("UnidadVenta")),
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
        return productos;


    }

    @Override
    public void updateProducto(Producto p) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(updateSt);
            st.setString(1, p.getDetalle());
            st.setBigDecimal(2, p.getCantidad());
            st.setBigDecimal(3, p.getPrecioUnitario());
            st.setString(4, p.getUnidad().toString());
            st.setBoolean(5, p.isActivo());
            st.setInt(6, p.getId());
            st.executeUpdate();
            System.out.println("Producto actualizado exitosamente");
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
    public boolean deleteProducto(int idProducto) {
        try {
            Producto producto = getProducto(idProducto);
            if (producto != null) {
                producto.setActivo(false);
                updateProducto(producto);
                System.out.println("Producto desactivado exitosamente");
                return true;
            } else {
                System.out.println("Producto no encontrado");
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
