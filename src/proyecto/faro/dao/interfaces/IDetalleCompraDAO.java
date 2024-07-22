package proyecto.faro.dao.interfaces;

import proyecto.faro.domain.DetalleCompra;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IDetalleCompraDAO {
    public boolean createDetalleCompra(DetalleCompra dc) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public DetalleCompra getDetalleCompra(int idDetalleCompra) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<DetalleCompra> getDetalleCompras() throws SQLException, ClassNotFoundException, IOException; //statement
    public int updateDetalleCompra (DetalleCompra dc) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteDetalleCompra(int idDetalleCompra); //prepare statement
}
