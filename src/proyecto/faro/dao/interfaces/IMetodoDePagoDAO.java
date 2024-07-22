package proyecto.faro.dao.interfaces;

import proyecto.faro.domain.MetodoDePago;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IMetodoDePagoDAO {
    public boolean createMetodoDePago(MetodoDePago mdp) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public MetodoDePago getMetodoDePago(int idMetodoDePago) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<MetodoDePago> getMetodoDePagos() throws SQLException, ClassNotFoundException, IOException; //statement
    public int updateMetodoDePago (MetodoDePago mdp) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteMetodoDePago(int idMetodoDePago); //prepare statement
}
