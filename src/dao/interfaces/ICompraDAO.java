package dao.interfaces;

import dominio.Compra;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ICompraDAO {

    public void createCompra(Compra c) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public Compra getCompra(int idCompra) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<Compra> getCompras() throws SQLException, ClassNotFoundException, IOException; //statement
    public void updateCompra (Compra c) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteCompra(int idCompra)throws SQLException, ClassNotFoundException, IOException; //prepare statement
}
