package proyecto.faro.dao.interfaces;

import proyecto.faro.domain.Usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDAO {

    public boolean createUsuario(Usuario u) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public Usuario getUsuario(int idUsuario) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public List<Usuario> getUsuarios() throws SQLException, ClassNotFoundException, IOException; //statement
    public int updateUsuario (Usuario u) throws SQLException, ClassNotFoundException, IOException; //prepare statement
    public boolean deleteUsuario(int idUsuario); //prepare statement
    
}
