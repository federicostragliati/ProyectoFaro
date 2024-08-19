import dao.implementaciones.*;
import dominio.*;
import dominio.enums.Destino;
import dominio.enums.Unidad;
import shared.ConnectionSQL;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        Date date = null;
        String fechaString = "15/08/2024";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            date = formatter.parse(fechaString);
            System.out.println("Fecha: " + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Producto producto = new Producto("Banan",BigDecimal.valueOf(50),BigDecimal.valueOf(30), Unidad.UN,true);
        Producto producto1 = new Producto(2,"Naranj",BigDecimal.valueOf(30),BigDecimal.valueOf(50), Unidad.KG,true);

        ProductoDAOImpMySQL productoDAOImpMySQL = new ProductoDAOImpMySQL();

        productoDAOImpMySQL.createProducto(producto1);

//        System.out.println(productoDAOImpMySQL.getProducto(1));
//
//        List <Producto> productos = productoDAOImpMySQL.getProductos();
//
//        for (int i = 0; i < productos.size(); i++) {
//            System.out.println(productos.get(i));
//        }


    }
}