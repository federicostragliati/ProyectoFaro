package proyecto.faro.dao.interfaces;

import proyecto.faro.domain.Remito;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IRemitoDAO {
    public boolean createRemito(Remito r) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public Remito getRemito(int idRemito) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<Remito> getRemitos() throws SQLException, ClassNotFoundException, IOException; //statement
    public int updateRemito (Remito r) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteRemito(int idRemito); //prepare statement
}
