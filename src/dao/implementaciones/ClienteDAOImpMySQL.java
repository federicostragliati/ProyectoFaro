package dao.implementaciones;

import dao.interfaces.IClienteDAO;
import dominio.Cliente;
import shared.ConnectionSQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ClienteDAOImpMySQL implements IClienteDAO {

    private ConnectionSQL sql;
    private String addSt;
    private String getSt;
    private String updateSt;
    private String deleteSt;
    private String selectAllSt;

    public ClienteDAOImpMySQL() {
        sql = new ConnectionSQL();
        addSt = "INSERT INTO `proyectofaro`.`cliente`\n" +
                "(`ID Cliente`,\n" +
                "`CUIT Cliente`,\n" +
                "`Nombre`,\n" +
                "`Email`,\n" +
                "`Telefono`,\n" +
                "`Activo`)\n" +
                "VALUES (?,?,?,?,?,?)"; // unico correcto
        getSt = "select * from cliente where idcliente = ?;";
        updateSt = "update cliente set CUIT = ?, Nombre = ?, Email = ?, Telefono = ?, activo = ?  where idcliente = ?;";
        // deleteSt = "delete from Cliente where idcliente = ?;";
        selectAllSt = "select * from Cliente";
    }

    @Override
    public void addCliente(Cliente c) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = sql.getConnection();
            ps = con.prepareStatement(addSt);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getCuitCliente());
            ps.setString(3, c.getNombre());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getTelefono());
            ps.setBoolean(6,c.isActivo());
            ps.executeUpdate();
            System.out.println("Cliente agregado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Cliente getCliente(int idCliente) throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public List<Cliente> getClientes() throws SQLException, ClassNotFoundException, IOException {
        return Collections.emptyList();
    }

    @Override
    public int updateCliente(Cliente c) throws SQLException, ClassNotFoundException, IOException {
        return 0;
    }

    @Override
    public boolean deleteCliente(int idCliente) {
        return false;
    }
}
