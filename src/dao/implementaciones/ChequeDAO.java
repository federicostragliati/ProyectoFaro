package dao.implementaciones;

import dao.interfaces.IChequeDAO;
import dominio.Cheque;
import dominio.enums.Destino;
import shared.ConnectionSQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChequeDAO implements IChequeDAO {

    private ConnectionSQL sql;
    private String addSt;
    private String getSt;
    private String updateSt;
    private String selectAllSt;

    public ChequeDAO() {
        sql = new ConnectionSQL();
        addSt = "INSERT INTO cheques (IDTransaccion, FechaRecepcion, CuitEmisor, NombreEmisor, BancoProcedencia, NroCheque, Importe, FechaCheque, FechaCobro, Destino, CuitDestino, Estado, Activo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        getSt = "SELECT * FROM cheques WHERE ID = ?;";
        updateSt = "UPDATE cheques SET IDTransaccion = ?, FechaRecepcion = ?, CuitEmisor = ?, NombreEmisor = ?, BancoProcedencia = ?, NroCheque = ?, Importe = ?, FechaCheque = ?, FechaCobro = ?, Destino = ?, CuitDestino = ?, Estado = ?, Activo = ? WHERE ID = ?;";
        selectAllSt = "SELECT * FROM cheques;";
    }

    @Override
    public void createCheque(Cheque c) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(addSt);
            st.setInt(1, c.getIdTransaccion());
            st.setDate(2, new Date (c.getFechaRecepcion().getTime()));
            st.setString(3, c.getCuitEmisor());
            st.setString(4, c.getNombreEmisor());
            st.setString(5, c.getBancoProcedencia());
            st.setString(6, c.getNroCheque());
            st.setBigDecimal(7, c.getImporte());
            st.setDate(8, new Date(c.getFechaCheque().getTime()));
            st.setDate(9, new Date(c.getFechaCobro().getTime()));
            st.setString(10, c.getDestino().name());
            st.setString(11, c.getCuitDestino());
            st.setBoolean(12, c.isEstado());
            st.setBoolean(13, c.isActivo());
            st.executeUpdate();
            System.out.println("Cheque agregado exitosamente");
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
    public Cheque getCheque(int idCheque) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(getSt);
            st.setInt(1, idCheque);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                //System.out.println("Se Encontro cheque");
                return new Cheque(
                        resultSet.getInt("ID"),
                        resultSet.getInt("IDTransaccion"),
                        resultSet.getDate("FechaRecepcion"),
                        resultSet.getString("CuitEmisor"),
                        resultSet.getString("NombreEmisor"),
                        resultSet.getString("BancoProcedencia"),
                        resultSet.getString("NroCheque"),
                        resultSet.getBigDecimal("Importe"),
                        resultSet.getDate("FechaCheque"),
                        resultSet.getDate("FechaCobro"),
                        Destino.valueOf(resultSet.getString("Destino")),
                        resultSet.getString("CuitDestino"),
                        resultSet.getBoolean("Estado"),
                        resultSet.getBoolean("Activo"));
            } else {
                System.out.println("No se encontró ningún cheque con el ID: " + idCheque);
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
    public List<Cheque> getCheques() throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        List<Cheque> cheques = new ArrayList<>();
        try {
            con = sql.getConnection();
            st = con.prepareStatement(selectAllSt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cheques.add(new Cheque(
                        rs.getInt("ID"),
                        rs.getInt("IDTransaccion"),
                        rs.getDate("FechaRecepcion"),
                        rs.getString("CuitEmisor"),
                        rs.getString("NombreEmisor"),
                        rs.getString("BancoProcedencia"),
                        rs.getString("NroCheque"),
                        rs.getBigDecimal("Importe"),
                        rs.getDate("FechaCheque"),
                        rs.getDate("FechaCobro"),
                        Destino.valueOf(rs.getString("Destino")),
                        rs.getString("CuitDestino"),
                        rs.getBoolean("Estado"),
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
        return cheques;
    }

    @Override
    public void updateCheque(Cheque c) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(updateSt);
            st.setInt(1, c.getIdTransaccion());
            st.setDate(2, new Date(c.getFechaRecepcion().getTime()));
            st.setString(3, c.getCuitEmisor());
            st.setString(4, c.getNombreEmisor());
            st.setString(5, c.getBancoProcedencia());
            st.setString(6, c.getNroCheque());
            st.setBigDecimal(7, c.getImporte());
            st.setDate(8, new Date(c.getFechaCheque().getTime()));
            st.setDate(9, new Date(c.getFechaCobro().getTime()));
            st.setString(10, c.getDestino().name());
            st.setString(11, c.getCuitDestino());
            st.setBoolean(12, c.isEstado());
            st.setBoolean(13, c.isActivo());
            st.setInt(14, c.getId());
            st.executeUpdate();
            System.out.println("Cheque actualizado exitosamente");
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
    public boolean deleteCheque(int idCheque) throws SQLException, ClassNotFoundException, IOException {
        try {
            Cheque cheque = getCheque(idCheque);
            if (cheque != null) {
                cheque.setActivo(false);
                updateCheque(cheque);
                System.out.println("Cheque desactivado exitosamente");
                return true;
            } else {
                System.out.println("Cheque no encontrado");
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
