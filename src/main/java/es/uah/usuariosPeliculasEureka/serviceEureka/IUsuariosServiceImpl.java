package es.uah.usuariosPeliculasEureka.serviceEureka;
import es.uah.usuariosPeliculasEureka.daoEureka.IUsuariosDAO;
import es.uah.usuariosPeliculasEureka.modelEureka.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUsuariosServiceImpl implements IUsuariosService{

    @Autowired
    IUsuariosDAO usuariosDAO;

    @Override
    public List<Users> buscarTodos() {
        return usuariosDAO.buscarTodos();
    }

    @Override
    public Users buscarUsuarioPorId(Integer idUsuario) {
        return usuariosDAO.buscarUsuarioPorId(idUsuario);
    }

    @Override
    public Users buscarUsuarioPorEmailAndPasswd(String email, String passwd){
        Users usuario = usuariosDAO.buscarUsuarioPorEmailAndPasswd(email, passwd);
        System.out.println("Yo soy el usuario " + usuario.getCorreo());
        return usuario;
//        Users usuario = usuariosDAO.buscarUsuarioPorEmail(email);
//        System.out.println("estes el es usuario" + usuario);
//        if(usuario.getPassword() ==  passwd){
//            return usuario;
//        }
//        return null;
    }

    @Override
    public Users buscarUsuarioPorNombre(String nombre) {
        return usuariosDAO.buscarUsuarioPorNombre(nombre);
    }

    @Override
    public Users buscarUsuarioPorCorreo(String correo) {
        return usuariosDAO.buscarUsuarioPorCorreo(correo);
    }

    @Override
    public Users buscarUsuarioAprobado(boolean enable) {
        return usuariosDAO.buscarUsuarioAprobado(enable);
    }

//    @Override
//    public Users buscarUsuarioPorEmail(String email) {
//        return usuariosDAO.buscarUsuarioPorEmail(email);
//    }

    @Override
    public boolean guardarUsuario(Users usuario) {
        if ((usuario.getPassword().length()>= 8) &&
        (usuariosDAO.buscarUsuarioPorCorreo(usuario.getCorreo()) == null) &&
                (usuariosDAO.buscarUsuarioPorNombre(usuario.getUsername()) == null))
        {
            usuariosDAO.guardarUsuario(usuario);
            return true;
        }
        return false;
    }

    @Override
    public boolean elimininarUsuario(Integer idUsuario) {
        Users usuario = usuariosDAO.buscarUsuarioPorId(idUsuario);
        if ( usuario != null ) {
            usuariosDAO.elimininarUsuario(usuario.getIdUsuario());
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarUsuario(Users usuario) {
        if ( usuariosDAO.buscarUsuarioPorId(usuario.getIdUsuario()) != null) {
            usuariosDAO.actualizarUsuario(usuario);
            return true;
        }
        return false;
    }
}
