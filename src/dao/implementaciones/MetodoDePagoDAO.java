package dao.implementaciones;

import dao.interfaces.IMetodoDePagoDAO;
import dominio.MetodoDePago;
import shared.ConnectionSQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetodoDePagoDAO implements IMetodoDePagoDAO {

    private ConnectionSQL sql;
    private String addSt;
    private String getSt;
    private String updateSt;
    private String selectAllSt;

    public MetodoDePagoDAO() {
        sql = new ConnectionSQL();
        addSt = "INSERT INTO metodosdepago (Nombre, Activo) VALUES (?, ?);";
        getSt = "SELECT * FROM metodosdepago WHERE ID = ?;";
        updateSt = "UPDATE metodosdepago SET Nombre = ?, Activo = ? WHERE ID = ?;";
        selectAllSt = "SELECT * FROM metodosdepago;";
    }

    @Override
    public void createMetodoDePago(MetodoDePago mp) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(addSt);
            st.setString(1, mp.getMetodo());
            st.setBoolean(2, mp.isActivo());
            st.executeUpdate();
            System.out.println("Método de pago agregado exitosamente");
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
    public MetodoDePago getMetodoDePago(int idMetodo) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(getSt);
            st.setInt(1, idMetodo);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new MetodoDePago(
                        resultSet.getInt("ID"),
                        resultSet.getString("Nombre"),
                        resultSet.getBoolean("Activo"));
            } else {
                System.out.println("No se encontró ningún método de pago con el ID: " + idMetodo);
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
    public List<MetodoDePago> getMetodoDePagos() throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        List<MetodoDePago> metodosDePago = new ArrayList<>();
        try {
            con = sql.getConnection();
            st = con.prepareStatement(selectAllSt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                metodosDePago.add(new MetodoDePago(
                        rs.getInt("ID"),
                        rs.getString("Nombre"),
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
        return metodosDePago;
    }

    @Override
    public void updateMetodoDePago(MetodoDePago mp) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(updateSt);
            st.setString(1, mp.getMetodo());
            st.setBoolean(2, mp.isActivo());
            st.setInt(3, mp.getId());
            st.executeUpdate();
            System.out.println("Método de pago actualizado exitosamente");
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
    public boolean deleteMetodoDePago(int idMetodo) throws SQLException, ClassNotFoundException, IOException {
        try {
            MetodoDePago metodoDePago = getMetodoDePago(idMetodo);
            if (metodoDePago != null) {
                metodoDePago.setActivo(false);
                updateMetodoDePago(metodoDePago);
                System.out.println("Método de pago desactivado exitosamente");
                return true;
            } else {
                System.out.println("Método de pago no encontrado");
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
