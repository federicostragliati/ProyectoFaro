import dao.implementaciones.*;
import dominio.*;
import dominio.enums.Unidad;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        System.out.printf("Test");

        ReportesDAO reportesDAO = new ReportesDAO();
        //reportesDAO.getReporteStock();
        //reportesDAO.getListaDePrecios();
        //reportesDAO.getHistoricoDePrecios(4);
        reportesDAO.getHistoricoDeStock(4);

    }
}