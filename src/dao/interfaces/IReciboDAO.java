package dao.interfaces;

import dominio.Recibo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IReciboDAO {
    void createRecibo(Recibo r) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    Recibo getRecibo(int idRecibo) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    List<Recibo> getRecibos() throws SQLException, ClassNotFoundException, IOException; //statement
    void updateRecibo (int id, String factura) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    boolean deleteRecibo(int idRecibo) throws SQLException, ClassNotFoundException, IOException; //prepare statement

}
