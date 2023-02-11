package es.uah.usuariosPeliculasEureka.daoEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthoritiesJPA extends JpaRepository<Authorities, Integer> {
    Authorities findByAuthorityContainingIgnoreCase(String authority);
//    Authorities findByIdRol(Integer idRol);
}
