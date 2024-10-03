package dao.interfaces;

import dominio.Remito;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IRemitoDAO {
    void createRemito(Remito r) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    Remito getRemito(int idRemito) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    List<Remito> getRemitos() throws SQLException, ClassNotFoundException, IOException; //statement
    void updateRemito(int id) throws SQLException, ClassNotFoundException, IOException;
    boolean deleteRemito(int idRemito) throws SQLException, ClassNotFoundException, IOException; //prepare statement
}
