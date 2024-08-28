package dao.implementaciones;

import dao.interfaces.IProveedorDAO;
import dominio.Proveedor;
import shared.ConnectionSQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO implements IProveedorDAO {

    private ConnectionSQL sql;
    private String addSt;
    private String getSt;
    private String updateSt;
    private String selectAllSt;

    public ProveedorDAO() {
        sql = new ConnectionSQL();
        addSt = "INSERT INTO proveedores (CUIT, RazonSocial, Email, Telefono, Direccion, Activo) VALUES (?,?,?,?,?,?);";
        getSt = "SELECT * FROM proveedores WHERE ID = ?;";
        updateSt = "UPDATE proveedores SET CUIT = ?, RazonSocial = ?, Email = ?, Telefono = ?, Direccion = ?, Activo = ? WHERE ID = ?;";
        selectAllSt = "SELECT * FROM proveedores;";
    }

    @Override
    public void createProveedor(Proveedor p) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(addSt);
            st.setString(1, p.getCuit());
            st.setString(2, p.getRazonSocial());
            st.setString(3, p.getEmail());
            st.setString(4, p.getTelefono());
            st.setString(5, p.getDireccion());
            st.setBoolean(6, p.isActivo());
            st.executeUpdate();
            System.out.println("Proveedor agregado exitosamente");
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
    public Proveedor getProveedor(int idProveedor) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(getSt);
            st.setInt(1, idProveedor);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new Proveedor(
                        resultSet.getInt("ID"),
                        resultSet.getString("CUIT"),
                        resultSet.getString("RazonSocial"),
                        resultSet.getString("Email"),
                        resultSet.getString("Telefono"),
                        resultSet.getString("Direccion"),
                        resultSet.getBoolean("Activo"));
            } else {
                System.out.println("No se encontró ningún proveedor con el ID: " + idProveedor);
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
    public List<Proveedor> getProveedores() throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        List<Proveedor> proveedores = new ArrayList<>();
        try {
            con = sql.getConnection();
            st = con.prepareStatement(selectAllSt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                proveedores.add(new Proveedor(
                        rs.getInt("ID"),
                        rs.getString("CUIT"),
                        rs.getString("RazonSocial"),
                        rs.getString("Email"),
                        rs.getString("Telefono"),
                        rs.getString("Direccion"),
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
        return proveedores;
    }

    @Override
    public void updateProveedor(Proveedor p) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(updateSt);
            st.setString(1, p.getCuit());
            st.setString(2, p.getRazonSocial());
            st.setString(3, p.getEmail());
            st.setString(4, p.getTelefono());
            st.setString(5, p.getDireccion());
            st.setBoolean(6, p.isActivo());
            st.setInt(7, p.getId());
            st.executeUpdate();
            System.out.println("Proveedor actualizado exitosamente");
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
    public boolean deleteProveedor(int idProveedor) throws SQLException, ClassNotFoundException, IOException {
        try {
            Proveedor proveedor = getProveedor(idProveedor);
            if (proveedor != null) {
                proveedor.setActivo(false);
                updateProveedor(proveedor);
                System.out.println("Proveedor desactivado exitosamente");
                return true;
            } else {
                System.out.println("Proveedor no encontrado");
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
