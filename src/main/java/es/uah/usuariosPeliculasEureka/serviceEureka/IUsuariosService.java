package es.uah.usuariosPeliculasEureka.serviceEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Users;

import java.util.List;

public interface IUsuariosService {
    List<Users> buscarTodos();
    Users buscarUsuarioPorId(Integer idUsuario);
    Users buscarUsuarioPorNombre(String nombre);
    Users buscarUsuarioPorCorreo(String correo);
    List<Users> buscarUsuarioAprobado(boolean enable);
    Users buscarUsuarioPorEmailAndPasswd(String email, String passwd);
    public boolean guardarUsuario(Users usuario);
    public boolean elimininarUsuario(Integer idUsuario);
    public boolean actualizarUsuario(Users usuario);
    public boolean aprobarUsuario(Integer idUsuario);
}
