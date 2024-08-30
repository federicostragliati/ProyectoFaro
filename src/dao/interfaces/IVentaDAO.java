package dao.interfaces;

import dominio.Venta;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IVentaDAO {

    void createVenta(Venta v) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    Venta getVenta(int idVenta) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    List<Venta> getVentas() throws SQLException, ClassNotFoundException, IOException; //statement
    void updateVenta (Venta v) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    boolean deleteVenta(int idVenta) throws SQLException, ClassNotFoundException, IOException;  //prepare statement
    Venta getLastVenta() throws SQLException, ClassNotFoundException, IOException;
}

