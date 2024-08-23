package dao.implementaciones;

import dao.interfaces.IClienteDAO;
import dominio.Cliente;
import shared.ConnectionSQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

    private ConnectionSQL sql;
    private String addSt;
    private String getSt;
    private String updateSt;
    private String selectAllSt;

    public ClienteDAO() {
        sql = new ConnectionSQL();
        addSt = "INSERT INTO clientes ( ID, CUIT, Nombre, Email, Telefono, Activo) VALUES (?,?,?,?,?,?);";
        getSt = "SELECT * FROM clientes WHERE ID = ?";
        updateSt = "UPDATE clientes SET CUIT = ?, Nombre = ?, Email = ?, Telefono = ?, Activo = ? where id = ?;";
        selectAllSt = "select * from clientes;";
    }

    @Override
    public void addCliente(Cliente c) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(addSt);
            st.setInt(1, c.getId());
            st.setString(2, c.getCuitCliente());
            st.setString(3, c.getNombre());
            st.setString(4, c.getEmail());
            st.setString(5, c.getTelefono());
            st.setBoolean(6,c.isActivo());
            st.executeUpdate();
            System.out.println("Cliente agregado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Cliente getCliente(int idCliente) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            System.out.println("Conectando a la base de datos...");
            con = sql.getConnection();
            st = con.prepareStatement(getSt);
            st.setInt(1, idCliente);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new Cliente(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getBoolean(6));
            } else {
                System.out.println("No se encontró ningún cliente con el ID: " + idCliente);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
                System.out.println("Consulta realizada exitosamente");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public List<Cliente> getClientes() throws SQLException, ClassNotFoundException, IOException {
        Connection con = sql.getConnection();
        PreparedStatement st = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            con = sql.getConnection();
            st = con.prepareStatement(selectAllSt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                con.close();
                System.out.println("Conexión Cerrada");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return clientes;
    }

    // Debo pasar ya el objeto cliente modificado (Todo excepto ID y Activo)

    @Override
    public void updateCliente(Cliente c) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(updateSt);
            st.setString(1, c.getCuitCliente());
            st.setString(2,c.getNombre());
            st.setString(3, c.getEmail());
            st.setString(4, c.getTelefono());
            st.setBoolean(5,c.isActivo());
            st.setInt(6,c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                con.close();
            } catch ( SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean deleteCliente(int idCliente) throws SQLException, ClassNotFoundException, IOException {
        try {
            Cliente cliente = getCliente(idCliente);
            cliente.setActivo(false);
            updateCliente(cliente);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
