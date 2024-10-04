package dao.implementaciones;

import dao.interfaces.IUsuarioDAO;
import dominio.Usuario;
import dominio.enums.TipoUsuario;
import shared.ConnectionSQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {

    private ConnectionSQL sql;
    private String addSt;
    private String getSt;
    private String updateSt;
    private String selectAllSt;
    private String auntenticar;

    public UsuarioDAO() {
        sql = new ConnectionSQL();
        addSt = "INSERT INTO usuarios (NombreUsuario, Nombre, Contraseña, TipoUsuario, Activo) VALUES (?, ?, ?, ?, ?);";
        getSt = "SELECT * FROM usuarios WHERE idUsuarios = ?;";
        updateSt = "UPDATE usuarios SET NombreUsuario = ?, Nombre = ?, Contraseña = ?, TipoUsuario = ?, Activo = ? WHERE idUsuarios = ?;";
        selectAllSt = "SELECT * FROM usuarios;";
        auntenticar = "SELECT * FROM usuarios WHERE NombreUsuario = ? AND Contraseña = ? AND Activo = 1;";
    }

    @Override
    public void createUsuario(Usuario u) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(addSt);
            st.setString(1, u.getNombreUsuario());
            st.setString(2, u.getNombre());
            st.setString(3, u.getContraseña());
            st.setString(4, u.getTipoUsuario().toString());
            st.setBoolean(5, u.isActivo());
            st.executeUpdate();
            System.out.println("Usuario agregado exitosamente");
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
    public Usuario getUsuario(int idUsuario) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(getSt);
            st.setInt(1, idUsuario);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new Usuario(
                        resultSet.getInt("idUsuarios"),
                        resultSet.getString("NombreUsuario"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Contraseña"),
                        TipoUsuario.valueOf(resultSet.getString("TipoUsuario")),
                        resultSet.getBoolean("Activo"));
            } else {
                System.out.println("No se encontró ningún usuario con el ID: " + idUsuario);
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
    public List<Usuario> getUsuarios() throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            con = sql.getConnection();
            st = con.prepareStatement(selectAllSt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                usuarios.add(new Usuario(
                        rs.getInt("idUsuarios"),
                        rs.getString("NombreUsuario"),
                        rs.getString("Nombre"),
                        rs.getString("Contraseña"),
                        TipoUsuario.valueOf(rs.getString("TipoUsuario")),
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
        return usuarios;
    }

    @Override
    public void updateUsuario(Usuario u) throws SQLException, ClassNotFoundException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(updateSt);
            st.setString(1, u.getNombreUsuario());
            st.setString(2, u.getNombre());
            st.setString(3, u.getContraseña());
            st.setString(4, u.getTipoUsuario().toString());
            st.setBoolean(5, u.isActivo());
            st.setInt(6, u.getId());
            st.executeUpdate();
            System.out.println("Usuario actualizado exitosamente");
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
    public boolean deleteUsuario(int idUsuario) throws SQLException, ClassNotFoundException, IOException {
        try {
            Usuario usuario = getUsuario(idUsuario);
            if (usuario != null) {
                usuario.setActivo(false);
                updateUsuario(usuario);
                System.out.println("Usuario desactivado exitosamente");
                return true;
            } else {
                System.out.println("Usuario no encontrado");
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Usuario autenticarUsuario(String usuario, String password) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = sql.getConnection();
            st = con.prepareStatement(auntenticar);
            st.setString(1, usuario);
            st.setString(2, password);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new Usuario(
                        resultSet.getInt("idUsuarios"),
                        resultSet.getString("NombreUsuario"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Contraseña"),
                        TipoUsuario.valueOf(resultSet.getString("TipoUsuario")),
                        resultSet.getBoolean("Activo"));
            } else {
                System.out.println("No se encontró ningún usuario " + usuario);
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
}
