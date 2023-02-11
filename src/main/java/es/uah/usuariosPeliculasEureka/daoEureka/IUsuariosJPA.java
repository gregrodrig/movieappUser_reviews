package es.uah.usuariosPeliculasEureka.daoEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuariosJPA extends JpaRepository<Users, Integer> {
    Users findByCorreo(String correo);
    Users findByUsernameContainingIgnoreCase(String nombre);
    List<Users> findByEnable(boolean enable);
    //Users findBy(String email);
    Users findByCorreoAndPassword(String email, String passwd);
}
