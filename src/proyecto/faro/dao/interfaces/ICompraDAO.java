package proyecto.faro.dao.interfaces;

import proyecto.faro.domain.Compra;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ICompraDAO {

    public boolean createCompra(Compra c) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public Compra getCompra(int idCompra) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<Compra> getCompras() throws SQLException, ClassNotFoundException, IOException; //statement
    public int updateCompra (Compra c) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteCompra(int idCompra); //prepare statement
}
