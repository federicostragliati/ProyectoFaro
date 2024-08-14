package dao.implementaciones;

import dao.interfaces.IClienteDAO;
import dominio.Cliente;
import shared.ConnectionSQL;

import java.io.IOException;
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
        addSt = "insert into cliente (CUIT, Nombre, Email, Telefono, Activo) values (?,?,?,?,?)"; // unico correcto
        getSt = "select * from Camiones where dominio = ?;";
        updateSt = "update Camiones set marca = ?, modelo = ?, dominio = ?, capacidad = ?," +
                "tanque = ?, consumo = ?  where idCamion = ?;";
        deleteSt = "delete from Camiones where idCamion = ?;";
        selectAllSt = "select * from Camiones";
    }

    @Override
    public boolean createCliente(Cliente c) throws SQLException, ClassNotFoundException, IOException {

        return false;
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
