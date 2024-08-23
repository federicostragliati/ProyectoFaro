package dao.interfaces;

import dominio.Usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDAO {

    public void createUsuario(Usuario u) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public Usuario getUsuario(int idUsuario) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<Usuario> getUsuarios() throws SQLException, ClassNotFoundException, IOException; //statement
    public void updateUsuario (Usuario u) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteUsuario(int idUsuario) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    
}
