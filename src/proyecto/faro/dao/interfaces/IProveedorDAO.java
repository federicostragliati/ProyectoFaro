package proyecto.faro.dao.interfaces;

import proyecto.faro.domain.Proveedor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IProveedorDAO {
    public boolean createProveedor(Proveedor p) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public Proveedor getProveedor(int idProveedor) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<Proveedor> getProveedores() throws SQLException, ClassNotFoundException, IOException; //statement
    public int updateProveedor (Proveedor p) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteProveedor(int idProveedor); //prepare statement
}
