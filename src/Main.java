import dao.implementaciones.ClienteDAOImpMySQL;
import dominio.Cliente;
import shared.ConnectionSQL;

import java.io.IOException;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        System.out.println("Test");

        Cliente cliente = new Cliente("20-39829719-0", "Ricardo Ruben", "ricardito@gmail.com", "11111111", true);

        ClienteDAOImpMySQL clienteDAO = new ClienteDAOImpMySQL();

        clienteDAO.addCliente(cliente);

    }
}