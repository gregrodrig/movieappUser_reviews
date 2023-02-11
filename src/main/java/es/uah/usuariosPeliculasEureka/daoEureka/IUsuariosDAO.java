package es.uah.usuariosPeliculasEureka.daoEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Users;

import java.util.List;

public interface IUsuariosDAO {
    List<Users> buscarTodos();
    Users buscarUsuarioPorId(Integer idUsuario);
    Users buscarUsuarioPorNombre(String nombre);
    Users buscarUsuarioPorCorreo(String correo);
    List<Users> buscarUsuarioAprobado(boolean enable);
    Users buscarUsuarioPorEmailAndPasswd(String email, String passwd);
    void guardarUsuario(Users usuario);
    void elimininarUsuario(Integer idUsuario);
    void actualizarUsuario(Users usuario);
}
