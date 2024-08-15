package dao.implementaciones;

import dao.interfaces.ICompraDAO;
import dominio.Compra;
import shared.ConnectionSQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date; // Importar java.sql.Date para la conversión
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraDAOImpMySQL implements ICompraDAO {

    private ConnectionSQL sql;
    private String addSt;
    private String getSt;
    private String updateSt;
    private String selectAllSt;

    public CompraDAOImpMySQL() {
        sql = new ConnectionSQL();
        addSt = "INSERT INTO compras (IDProveedor, CUITProveedor, FechaCompra, MetodoPagoPrimario, MontoPagoPrimario, MetodoPagoSecundario, MontoPagoSecundario, MontoFinal, Pagado, Entregado, Activo) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        getSt = "SELECT * FROM compras WHERE ID = ?;";
        updateSt = "UPDATE compras SET IDProveedor = ?, CUITProveedor = ?, FechaCompra = ?, MetodoPagoPrimario = ?, MontoPagoPrimario = ?, MetodoPagoSecundario = ?, MontoPagoSecundario = ?, MontoFinal = ?, Pagado = ?, Entregado = ?, Activo = ? WHERE ID = ?;";
        selectAllSt = "SELECT * FROM compras;";
    }

    @Override
    public void createCompra(Compra c) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(addSt);
            st.setInt(1, c.getIdProveedor());
            st.setString(2, c.getCuitProveedor());
            st.setDate(3, new Date(c.getFechaCompra().getTime())); // Convert java.util.Date to java.sql.Date
            st.setInt(4, c.getMetodoDePagoPrimario());
            st.setBigDecimal(5, c.getMontoDePagoPrimario());
            st.setInt(6, c.getMetodoDePagoSecundario());
            st.setBigDecimal(7, c.getMontoDePagoSecundario());
            st.setBigDecimal(8, c.getMontoFinal());
            st.setBoolean(9, c.isPagada());
            st.setBoolean(10, c.isEntregada());
            st.setBoolean(11, c.isActivo());
            st.executeUpdate();
            System.out.println("Compra agregada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Compra getCompra(int idCompra) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(getSt);
            st.setInt(1, idCompra);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new Compra(
                        resultSet.getInt("ID"),
                        resultSet.getInt("IDProveedor"),
                        resultSet.getString("CUITProveedor"),
                        resultSet.getDate("FechaCompra"), // java.sql.Date
                        resultSet.getInt("MetodoPagoPrimario"),
                        resultSet.getBigDecimal("MontoPagoPrimario"),
                        resultSet.getInt("MetodoPagoSecundario"),
                        resultSet.getBigDecimal("MontoPagoSecundario"),
                        resultSet.getBigDecimal("MontoFinal"),
                        resultSet.getBoolean("Pagado"),
                        resultSet.getBoolean("Entregado"),
                        resultSet.getBoolean("Activo"));
            } else {
                System.out.println("No se encontró ninguna compra con el ID: " + idCompra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Compra> getCompras() throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        List<Compra> compras = new ArrayList<>();
        try {
            con = sql.getConnection();
            st = con.prepareStatement(selectAllSt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                compras.add(new Compra(
                        rs.getInt("ID"),
                        rs.getInt("IDProveedor"),
                        rs.getString("CUITProveedor"),
                        rs.getDate("FechaCompra"), // java.sql.Date
                        rs.getInt("MetodoPagoPrimario"),
                        rs.getBigDecimal("MontoPagoPrimario"),
                        rs.getInt("MetodoPagoSecundario"),
                        rs.getBigDecimal("MontoPagoSecundario"),
                        rs.getBigDecimal("MontoFinal"),
                        rs.getBoolean("Pagado"),
                        rs.getBoolean("Entregado"),
                        rs.getBoolean("Activo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
                System.out.println("Conexión Cerrada");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return compras;
    }

    @Override
    public void updateCompra(Compra c) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(updateSt);
            st.setInt(1, c.getIdProveedor());
            st.setString(2, c.getCuitProveedor());
            st.setDate(3, new Date(c.getFechaCompra().getTime())); // Convert java.util.Date to java.sql.Date
            st.setInt(4, c.getMetodoDePagoPrimario());
            st.setBigDecimal(5, c.getMontoDePagoPrimario());
            st.setInt(6, c.getMetodoDePagoSecundario());
            st.setBigDecimal(7, c.getMontoDePagoSecundario());
            st.setBigDecimal(8, c.getMontoFinal());
            st.setBoolean(9, c.isPagada());
            st.setBoolean(10, c.isEntregada());
            st.setBoolean(11, c.isActivo());
            st.setInt(12, c.getId());
            st.executeUpdate();
            System.out.println("Compra actualizada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean deleteCompra(int idCompra) {
        try {
            Compra compra = getCompra(idCompra);
            if (compra != null) {
                compra.setActivo(false);
                updateCompra(compra);
                System.out.println("Compra desactivada exitosamente");
                return true;
            } else {
                System.out.println("Compra no encontrada");
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
