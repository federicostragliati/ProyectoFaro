package dao.interfaces;

import dominio.Compra;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ICompraDAO {

    void createCompra(Compra c) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    Compra getCompra(int idCompra) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    List<Compra> getCompras() throws SQLException, ClassNotFoundException, IOException; //statement
    void updateCompra (Compra c) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    boolean deleteCompra(int idCompra)throws SQLException, ClassNotFoundException, IOException;//prepare statement
    Compra getLastCompra() throws SQLException, ClassNotFoundException, IOException;
}
