package dao.interfaces;


import dominio.Cliente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IClienteDAO {

    public void addCliente(Cliente c) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public Cliente getCliente(int idCliente) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<Cliente> getClientes() throws SQLException, ClassNotFoundException, IOException; //statement
    public void updateCliente (Cliente c) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteCliente(int idCliente); //prepare statement
}
