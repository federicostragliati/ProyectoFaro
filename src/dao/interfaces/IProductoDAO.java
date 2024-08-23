package dao.interfaces;

import dominio.Producto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IProductoDAO {
    public void createProducto(Producto p) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public Producto getProducto(int idProducto) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<Producto> getProductos() throws SQLException, ClassNotFoundException, IOException; //statement
    public void updateProducto (Producto p) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteProducto(int idProducto) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    
}
