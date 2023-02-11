package es.uah.usuariosPeliculasEureka.daoEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuariosJPA extends JpaRepository<Users, Integer> {
    Users findByCorreo(String correo);
    Users findByUsernameContainingIgnoreCase(String nombre);
    Users findByEnable(boolean enable);
    //Users findBy(String email);
    Users findByCorreoAndPassword(String email, String passwd);
}
