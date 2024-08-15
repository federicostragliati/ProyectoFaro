import dao.implementaciones.ClienteDAOImpMySQL;
import dominio.Cliente;
import shared.ConnectionSQL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        Cliente cliente = new Cliente(5,"20-99999999-0", "Juanisimo Maginifico", "JM@gmail.com", "85452895", true);

        ClienteDAOImpMySQL clienteDAO = new ClienteDAOImpMySQL();

        //clienteDAO.addCliente(cliente);

        //clienteDAO.updateCliente(cliente);

        clienteDAO.deleteCliente(5);

        List <Cliente> clientes = clienteDAO.getClientes();

        for (int i = 0; i < clientes.size() ; i++) {
            System.out.println(clientes.get(i).toString());
        }

        //System.out.println(clienteDAO.getCliente(5).toString());

        //System.out.println(cliente1.toString());


    }
}