package es.uah.usuariosPeliculasEureka.daoEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuariosDAOImpl implements IUsuariosDAO{

    @Autowired
    IUsuariosJPA usuariosJPA;

    @Override
    public List<Users> buscarTodos() {
        return usuariosJPA.findAll();
    }

    @Override
    public Users buscarUsuarioPorId(Integer idUsuario) {
//        return usuariosJPA.findByIdUsuario(idUsuario);
        Optional<Users> optional = usuariosJPA.findById(idUsuario);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public Users buscarUsuarioPorNombre(String nombre) {
        return usuariosJPA.findByUsernameContainingIgnoreCase(nombre);
    }

    @Override
    public Users buscarUsuarioPorCorreo(String correo) {
        return usuariosJPA.findByCorreo(correo);
    }

//    @Override
//    public Users buscarUsuarioPorEmail(String email) {
//        return usuariosJPA.findByCorreo(email);
//    }

    @Override
    public List<Users> buscarUsuarioAprobado(boolean enable) {
        return usuariosJPA.findByEnable(enable);
    }

    @Override
    public Users buscarUsuarioPorEmailAndPasswd(String email, String passwd) {
        return usuariosJPA.findByCorreoAndPassword(email, passwd);
    }

    @Override
    public void guardarUsuario(Users usuario) {
        usuariosJPA.save(usuario);
    }

    @Override
    public void elimininarUsuario(Integer idUsuario) {
        usuariosJPA.deleteById(idUsuario);
    }

    @Override
    public void actualizarUsuario(Users usuario) {
        usuariosJPA.save(usuario);
    }
}
