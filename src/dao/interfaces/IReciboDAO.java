package dao.interfaces;

import dominio.Recibo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IReciboDAO {
    public boolean createRecibo(Recibo r) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public Recibo getRecibo(int idRecibo) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<Recibo> getRecibos() throws SQLException, ClassNotFoundException, IOException; //statement
    public int updateRecibo (Recibo r) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteRecibo(int idRecibo); //prepare statement

}
