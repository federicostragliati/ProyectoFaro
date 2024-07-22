package proyecto.faro.dao.interfaces;

import proyecto.faro.domain.Venta;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IVentaDAO {

    public boolean createVenta(Venta v) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public Venta getVenta(int idVenta) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<Venta> getVentas() throws SQLException, ClassNotFoundException, IOException; //statement
    public int updateVenta (Venta v) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteVenta(int idVenta); //prepare statement
}
