package dao.interfaces;

import dominio.Remito;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IRemitoDAO {
    public void createRemito(Remito r) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public Remito getRemito(int idRemito) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<Remito> getRemitos() throws SQLException, ClassNotFoundException, IOException; //statement
    public void updateRemito (Remito r) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteRemito(int idRemito) throws SQLException, ClassNotFoundException, IOException; //prepare statement
}
