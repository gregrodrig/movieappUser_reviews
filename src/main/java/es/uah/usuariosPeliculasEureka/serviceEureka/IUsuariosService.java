package es.uah.usuariosPeliculasEureka.serviceEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Users;

import java.util.List;

public interface IUsuariosService {
    List<Users> buscarTodos();
    Users buscarUsuarioPorId(Integer idUsuario);
    Users buscarUsuarioPorNombre(String nombre);
    Users buscarUsuarioPorCorreo(String correo);
    Users buscarUsuarioAprobado(boolean enable);
   // Users buscarUsuarioPorEmail(String email);
    Users buscarUsuarioPorEmailAndPasswd(String email, String passwd);
    public boolean guardarUsuario(Users usuario);
    public boolean elimininarUsuario(Integer idUsuario);
    public boolean actualizarUsuario(Users usuario);
}
