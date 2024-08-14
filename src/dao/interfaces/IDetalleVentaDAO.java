package dao.interfaces;

import dominio.DetalleVenta;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IDetalleVentaDAO {
    public boolean createDetalleVenta(DetalleVenta dv) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public DetalleVenta getDetalleVenta(int idDetalleVenta) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<DetalleVenta> getDetalleVentas() throws SQLException, ClassNotFoundException, IOException; //statement
    public int updateDetalleVenta (DetalleVenta dv) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteDetalleVenta(int idDetalleVenta); //prepare statement
}
