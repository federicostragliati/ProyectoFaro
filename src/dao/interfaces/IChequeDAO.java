package dao.interfaces;

import dominio.Cheque;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IChequeDAO {

    public void createCheque(Cheque c) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public Cheque getCheque(int idCheque) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<Cheque> getCheques() throws SQLException, ClassNotFoundException, IOException; //statement
    public void updateCheque (Cheque c) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteCheque(int idCheque); //prepare statement
}
