package dao.implementaciones;

import com.sun.scenario.effect.impl.prism.PrImage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import shared.ConnectionSQL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ReportesDAO {

    private ConnectionSQL c;
    private String userHome;
    private String downloadsPath;
    private String reporteStock;
    private String stockProductoUnico;
    private String stockHistoricoVentas;
    private String stockHistoricoCompras;
    private String ventasEntreFechas;
    private String ventasPorCerrar;
    private String ventasPorCerrarPorCliente;
    private String ventasEntreFechasPorCliente;
    private String comprasEntreFechas;
    private String comprasPorCerrar;
    private String comprasPorCerrarPorProveedor;
    private String comprasEntreFechasPorProveedor;
    private String listaDePrecios;
    private String precioProductoUnico;
    private String historicoDePreciosCompra;
    private String historicoDePreciosVenta;
    private String chequesAVencer;

    public ReportesDAO() {

        this.userHome = System.getProperty("user.home");
        c = new ConnectionSQL();
        //Consultas Stock
        this.reporteStock = "SELECT ID, Detalle, Cantidad, UnidadVenta FROM productos WHERE Activo = true;";
        this.stockProductoUnico = "SELECT ID, Detalle, UnidadVenta, Cantidad FROM productos WHERE ID = ?;";
        this.stockHistoricoVentas = "SELECT dv.IDProducto, dv.DetalleProducto, dv.Unidad, dv.Cantidad, v.FechaVenta FROM detalleventa dv JOIN ventas v ON dv.IDVenta = v.ID WHERE dv.IDProducto = ? ORDER BY v.FechaVenta DESC LIMIT 10;";
        this.stockHistoricoCompras ="SELECT dc.IDProducto, dc.DetalleProducto, dc.Unidad, dc.Cantidad, c.FechaCompra FROM detallecompra dc JOIN compras c ON dc.IDCompra = c.ID WHERE dc.IDProducto = ? ORDER BY c.FechaCompra DESC LIMIT 10;";
        //Consultas Ventas
        this.ventasEntreFechas = "SELECT * FROM ventas WHERE FechaVenta BETWEEN ? AND ?;";
        this.ventasPorCerrar = "Select * from ventas where (Pagado = 1 AND Entregada = 0) OR (Pagado = 0 AND Entregada = 1);";
        this.ventasPorCerrarPorCliente = "SELECT * FROM ventas WHERE ((Pagado = 1 AND Entregada = 0) OR (Pagado = 0 AND Entregada = 1)) AND IDCliente = ?;";
        this.ventasEntreFechasPorCliente = "SELECT * FROM ventas WHERE FechaVenta BETWEEN ? AND ? AND IDCliente = ? ;";
        //Consultas Compras
        this.comprasEntreFechas = "SELECT * FROM compras WHERE FechaCompra BETWEEN ? AND ?;";
        this.comprasPorCerrar = "Select * from compras where (Pagado = 1 AND Entregada = 0) OR (Pagado = 0 AND Entregada = 1);";
        this.comprasPorCerrarPorProveedor = "SELECT * FROM compras WHERE ((Pagado = 1 AND Entregada = 0) OR (Pagado = 0 AND Entregada = 1)) AND IDProveedor = ?;";
        this.comprasEntreFechasPorProveedor = "SELECT * FROM ventas WHERE FechaCompra BETWEEN ? AND ? AND IDProveedor = ? ;";
        //Consultas Lista de Precios
        this.listaDePrecios = "SELECT ID, Detalle, PrecioUnitario, UnidadVenta FROM productos WHERE Activo = true;";
        this.precioProductoUnico = "SELECT ID, Detalle, UnidadVenta, PrecioUnitario FROM productos WHERE ID = ?;";
        this.historicoDePreciosCompra = "SELECT dc.IDProducto, dc.DetalleProducto, dc.Unidad, dc.CostoUnitario, c.FechaCompra FROM detallecompra dc JOIN compras c ON dc.IDCompra = c.ID WHERE dc.IDProducto = ? ORDER BY c.FechaCompra DESC LIMIT 5;\n";
        this.historicoDePreciosVenta = "SELECT dv.IDProducto, dv.DetalleProducto, dv.Unidad, dv.PrecioUnitario, v.FechaVenta FROM detalleventa dv JOIN ventas v ON dv.IDVenta = v.ID WHERE dv.IDProducto = ? ORDER BY v.FechaVenta DESC LIMIT 5;";
        //Consulta Cheques
        this.chequesAVencer = "SELECT * FROM cheques WHERE FechaCobro <= CURDATE() + INTERVAL 15 DAY;";


    }

    //Reportes Stock
    public void getReporteStock () {

        Connection con = null;
        PreparedStatement st = null;

        try {

            Date date  = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy - HHmm");
            String dateFormateada = dateFormat.format(date);

            downloadsPath = userHome + "/Downloads/" + "ReporteStock " + dateFormateada + ".xlsx";

            con = c.getConnection();
            st = con.prepareStatement(reporteStock);
            ResultSet resultSet = st.executeQuery();

            createReport(downloadsPath, resultSet);

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void getHistoricoDeStock (int id) {
        Connection con = null;

        PreparedStatement st0 = null;
        PreparedStatement st1 = null;
        PreparedStatement st2 = null;

        try {

            Date date  = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy - HHmm");
            String dateFormateada = dateFormat.format(date);

            downloadsPath = userHome + "/Downloads/" + "HistoricoDeStock " + dateFormateada + ".xlsx";

            con = c.getConnection();

            st0 = con.prepareStatement(stockProductoUnico);
            st0.setInt(1,id);

            st1 = con.prepareStatement(stockHistoricoCompras);
            st1.setInt(1,id);

            st2 = con.prepareStatement(stockHistoricoVentas);
            st2.setInt(1,id);

            ResultSet resultSet0 = st0.executeQuery();
            ResultSet resultSet1 = st1.executeQuery();
            ResultSet resultSet2 = st2.executeQuery();

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet0 = workbook.createSheet("Stock Actual");
            Sheet sheet1 = workbook.createSheet("Reporte Compras");
            Sheet sheet2 = workbook.createSheet("Reporte Ventas");
            // Crear encabezados de columnas
            ResultSetMetaData metaData0 = resultSet0.getMetaData();
            int columnCount0 = metaData0.getColumnCount();

            ResultSetMetaData metaData1 = resultSet1.getMetaData();
            int columnCount1 = metaData1.getColumnCount();

            ResultSetMetaData metaData2 = resultSet2.getMetaData();
            int columnCount2 = metaData2.getColumnCount();

            Row headerRow0 = sheet0.createRow(0);
            for (int i = 1; i <= columnCount0; i++) {
                Cell cell = headerRow0.createCell(i - 1);
                cell.setCellValue(metaData0.getColumnName(i));
            }
            Row headerRow1 = sheet1.createRow(0);
            for (int i = 1; i <= columnCount1; i++) {
                Cell cell = headerRow1.createCell(i - 1);
                cell.setCellValue(metaData1.getColumnName(i));
            }
            Row headerRow2 = sheet2.createRow(0);
            for (int i = 1; i <= columnCount2; i++) {
                Cell cell = headerRow2.createCell(i - 1);
                cell.setCellValue(metaData2.getColumnName(i));
            }

            // Llenar datos
            int rowCount = 1;
            while (resultSet0.next()) {
                Row row = sheet0.createRow(rowCount++);

                for (int i = 1; i <= columnCount0; i++) {
                    Cell cell = row.createCell(i - 1);
                    cell.setCellValue(resultSet0.getString(i));
                }
            }
            rowCount = 1;
            while (resultSet1.next()) {
                Row row = sheet1.createRow(rowCount++);

                for (int i = 1; i <= columnCount1; i++) {
                    Cell cell = row.createCell(i - 1);
                    cell.setCellValue(resultSet1.getString(i));
                }
            }
            rowCount = 1;
            while (resultSet2.next()) {
                Row row = sheet2.createRow(rowCount++);

                for (int i = 1; i <= columnCount2; i++) {
                    Cell cell = row.createCell(i - 1);
                    cell.setCellValue(resultSet2.getString(i));
                }
            }

            // Escribir a un archivo
            try (FileOutputStream outputStream = new FileOutputStream(downloadsPath)) {
                workbook.write(outputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            workbook.close();

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Reportes Ventas
    public void getVentasEntreDosFechas (Date fechaInicial, Date fechaFinal) {

        Connection con = null;
        PreparedStatement st = null;

        try {

            Date date  = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy - HHmm");
            String dateFormateada = dateFormat.format(date);

            downloadsPath = userHome + "/Downloads/" + "ReporteVentasEntreFechas " + dateFormateada + ".xlsx";

            con = c.getConnection();
            st = con.prepareStatement(ventasEntreFechas);
            st.setDate(1, new java.sql.Date(fechaInicial.getTime()));
            st.setDate(2, new java.sql.Date(fechaFinal.getTime()));

            ResultSet resultSet = st.executeQuery();

            createReport(downloadsPath, resultSet);

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getVentasPorCerrar () {

        Connection con = null;
        PreparedStatement st = null;

        try {

            Date date  = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy - HHmm");
            String dateFormateada = dateFormat.format(date);

            downloadsPath = userHome + "/Downloads/" + "ReporteVentasPorCerrar " + dateFormateada + ".xlsx";

            con = c.getConnection();
            st = con.prepareStatement(ventasPorCerrar);

            ResultSet resultSet = st.executeQuery();

            createReport(downloadsPath, resultSet);

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getVentasPorCerrarPorCliente (int id) {

        Connection con = null;
        PreparedStatement st = null;

        try {

            Date date  = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy - HHmm");
            String dateFormateada = dateFormat.format(date);

            downloadsPath = userHome + "/Downloads/" + "ReporteVentasPorCerrarPorCliente " + dateFormateada + ".xlsx";

            con = c.getConnection();
            st = con.prepareStatement(ventasPorCerrarPorCliente);
            st.setInt(1,id);

            ResultSet resultSet = st.executeQuery();

            createReport(downloadsPath, resultSet);

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getVentaEntreDosFechasPorCliente (Date fechaInicial, Date fechaFinal, int id) {

        Connection con = null;
        PreparedStatement st = null;

        try {

            Date date  = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy - HHmm");
            String dateFormateada = dateFormat.format(date);

            downloadsPath = userHome + "/Downloads/" + "ReporteVentasEntreFechasPorCliente " + dateFormateada + ".xlsx";

            con = c.getConnection();
            st = con.prepareStatement(ventasEntreFechasPorCliente);
            st.setDate(1, new java.sql.Date(fechaInicial.getTime()));
            st.setDate(2, new java.sql.Date(fechaFinal.getTime()));
            st.setInt(3, id);

            ResultSet resultSet = st.executeQuery();

            createReport(downloadsPath, resultSet);

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Reportes Compras
    public void getComprasEntreDosFechas (Date fechaInicial, Date fechaFinal) {

        Connection con = null;
        PreparedStatement st = null;

        try {

            Date date  = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy - HHmm");
            String dateFormateada = dateFormat.format(date);

            downloadsPath = userHome + "/Downloads/" + "ReporteComprasEntreFechas " + dateFormateada + ".xlsx";

            con = c.getConnection();
            st = con.prepareStatement(comprasEntreFechas);
            st.setDate(1, new java.sql.Date(fechaInicial.getTime()));
            st.setDate(2, new java.sql.Date(fechaFinal.getTime()));

            ResultSet resultSet = st.executeQuery();

            createReport(downloadsPath, resultSet);

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getComprasPorCerrar () {

        Connection con = null;
        PreparedStatement st = null;

        try {

            Date date  = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy - HHmm");
            String dateFormateada = dateFormat.format(date);

            downloadsPath = userHome + "/Downloads/" + "ReporteComprasPorCerrar " + dateFormateada + ".xlsx";

            con = c.getConnection();
            st = con.prepareStatement(comprasPorCerrar);

            ResultSet resultSet = st.executeQuery();

            createReport(downloadsPath, resultSet);

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getComprasPorCerrarPorProveedor (int id) {

        Connection con = null;
        PreparedStatement st = null;

        try {

            Date date  = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy - HHmm");
            String dateFormateada = dateFormat.format(date);

            downloadsPath = userHome + "/Downloads/" + "ReporteComprasPorCerrarPorProveedor " + dateFormateada + ".xlsx";

            con = c.getConnection();
            st = con.prepareStatement(comprasPorCerrarPorProveedor);
            st.setInt(1,id);

            ResultSet resultSet = st.executeQuery();

            createReport(downloadsPath, resultSet);

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getComprasEntreDosFechasPorProveedor (Date fechaInicial, Date fechaFinal, int id) {

        Connection con = null;
        PreparedStatement st = null;

        try {

            Date date  = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy - HHmm");
            String dateFormateada = dateFormat.format(date);

            downloadsPath = userHome + "/Downloads/" + "ReporteCompraEntreFechasPorProveedor " + dateFormateada + ".xlsx";

            con = c.getConnection();
            st = con.prepareStatement(comprasEntreFechasPorProveedor);
            st.setDate(1, new java.sql.Date(fechaInicial.getTime()));
            st.setDate(2, new java.sql.Date(fechaFinal.getTime()));
            st.setInt(3, id);

            ResultSet resultSet = st.executeQuery();

            createReport(downloadsPath, resultSet);

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Reportes Lista de Precios
    public void getListaDePrecios () {

        Connection con = null;
        PreparedStatement st = null;

        try {

            Date date  = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy - HHmm");
            String dateFormateada = dateFormat.format(date);

            downloadsPath = userHome + "/Downloads/" + "ListaDePrecios " + dateFormateada + ".xlsx";

            con = c.getConnection();
            st = con.prepareStatement(listaDePrecios);
            ResultSet resultSet = st.executeQuery();

            createReport(downloadsPath, resultSet);

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void getHistoricoDePrecios (int id) {
        Connection con = null;
        //Agrego un st0 con el precio actual?
        PreparedStatement st0 = null;
        PreparedStatement st1 = null;
        PreparedStatement st2 = null;

        try {

            Date date  = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy - HHmm");
            String dateFormateada = dateFormat.format(date);

            downloadsPath = userHome + "/Downloads/" + "HistoricoDePrecios " + dateFormateada + ".xlsx";

            con = c.getConnection();

            st0 = con.prepareStatement(precioProductoUnico);
            st0.setInt(1,id);

            st1 = con.prepareStatement(historicoDePreciosCompra);
            st1.setInt(1,id);

            st2 = con.prepareStatement(historicoDePreciosVenta);
            st2.setInt(1,id);

            ResultSet resultSet0 = st0.executeQuery();
            ResultSet resultSet1 = st1.executeQuery();
            ResultSet resultSet2 = st2.executeQuery();

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet0 = workbook.createSheet("Precio Actual");
            Sheet sheet1 = workbook.createSheet("Reporte Compras");
            Sheet sheet2 = workbook.createSheet("Reporte Ventas");
            // Crear encabezados de columnas
            ResultSetMetaData metaData0 = resultSet0.getMetaData();
            int columnCount0 = metaData0.getColumnCount();

            ResultSetMetaData metaData1 = resultSet1.getMetaData();
            int columnCount1 = metaData1.getColumnCount();

            ResultSetMetaData metaData2 = resultSet2.getMetaData();
            int columnCount2 = metaData2.getColumnCount();

            Row headerRow0 = sheet0.createRow(0);
            for (int i = 1; i <= columnCount0; i++) {
                Cell cell = headerRow0.createCell(i - 1);
                cell.setCellValue(metaData0.getColumnName(i));
            }
            Row headerRow1 = sheet1.createRow(0);
            for (int i = 1; i <= columnCount1; i++) {
                Cell cell = headerRow1.createCell(i - 1);
                cell.setCellValue(metaData1.getColumnName(i));
            }
            Row headerRow2 = sheet2.createRow(0);
            for (int i = 1; i <= columnCount2; i++) {
                Cell cell = headerRow2.createCell(i - 1);
                cell.setCellValue(metaData2.getColumnName(i));
            }

            // Llenar datos
            int rowCount = 1;
            while (resultSet0.next()) {
                Row row = sheet0.createRow(rowCount++);

                for (int i = 1; i <= columnCount0; i++) {
                    Cell cell = row.createCell(i - 1);
                    cell.setCellValue(resultSet0.getString(i));
                }
            }
            rowCount = 1;
            while (resultSet1.next()) {
                Row row = sheet1.createRow(rowCount++);

                for (int i = 1; i <= columnCount1; i++) {
                    Cell cell = row.createCell(i - 1);
                    cell.setCellValue(resultSet1.getString(i));
                }
            }
            rowCount = 1;
            while (resultSet2.next()) {
                Row row = sheet2.createRow(rowCount++);

                for (int i = 1; i <= columnCount2; i++) {
                    Cell cell = row.createCell(i - 1);
                    cell.setCellValue(resultSet2.getString(i));
                }
            }

            // Escribir a un archivo
            try (FileOutputStream outputStream = new FileOutputStream(downloadsPath)) {
                workbook.write(outputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            workbook.close();

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Reporte Cheques
    public void getChequesAVencer () {

        Connection con = null;
        PreparedStatement st = null;

        try {

            Date date  = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy - HHmm");
            String dateFormateada = dateFormat.format(date);

            downloadsPath = userHome + "/Downloads/" + "ChequesAVencer " + dateFormateada + ".xlsx";

            con = c.getConnection();
            st = con.prepareStatement(chequesAVencer);
            ResultSet resultSet = st.executeQuery();

            createReport(downloadsPath, resultSet);

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Función para crear reportes
    public void createReport (String path, ResultSet resultSet) throws SQLException, IOException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reporte");
        // Crear encabezados de columnas
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        Row headerRow = sheet.createRow(0);
        for (int i = 1; i <= columnCount; i++) {
            Cell cell = headerRow.createCell(i - 1);
            cell.setCellValue(metaData.getColumnName(i));
        }

        // Llenar datos
        int rowCount = 1;
        while (resultSet.next()) {
            Row row = sheet.createRow(rowCount++);

            for (int i = 1; i <= columnCount; i++) {
                Cell cell = row.createCell(i - 1);
                cell.setCellValue(resultSet.getString(i));
            }
        }

        // Escribir a un archivo
        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        workbook.close();
    }
}
