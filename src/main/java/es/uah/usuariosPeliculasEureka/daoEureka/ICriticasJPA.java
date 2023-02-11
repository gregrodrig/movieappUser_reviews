package es.uah.usuariosPeliculasEureka.daoEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Criticas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICriticasJPA extends JpaRepository<Criticas, Integer> {

    Criticas findByNota(Integer notas);
    Criticas findByUsers_idUsuario(Integer idUsuario);
    Criticas findByValoracionContainingIgnoreCase(String valoracion);
}
