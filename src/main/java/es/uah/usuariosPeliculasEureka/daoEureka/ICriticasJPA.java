package es.uah.usuariosPeliculasEureka.daoEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Criticas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICriticasJPA extends JpaRepository<Criticas, Integer> {

    Criticas findByNota(Integer notas);
    List<Criticas> findByUsers_idUsuario(Integer idUsuario);
    List<Criticas> findByIdPelicula(Integer idPelicula);
    Criticas findByValoracionContainingIgnoreCase(String valoracion);
}
