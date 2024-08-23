package dao.interfaces;

import dominio.MetodoDePago;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IMetodoDePagoDAO {
    public void createMetodoDePago(MetodoDePago mdp) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public MetodoDePago getMetodoDePago(int idMetodoDePago) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<MetodoDePago> getMetodoDePagos() throws SQLException, ClassNotFoundException, IOException; //statement
    public void updateMetodoDePago (MetodoDePago mdp) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteMetodoDePago(int idMetodoDePago) throws SQLException, ClassNotFoundException, IOException; //prepare statement
}
