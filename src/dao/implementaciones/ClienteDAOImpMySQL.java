package dao.implementaciones;

import dao.interfaces.IClienteDAO;
import dominio.Cliente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ClienteDAOImpMySQL implements IClienteDAO {
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
