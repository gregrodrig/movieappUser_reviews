package es.uah.usuariosPeliculasEureka.daoEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Criticas;

import java.util.List;

public interface ICriticasDAO {
    List<Criticas> buscarTodos();
    Criticas buscarCriticasPorId(Integer idCriticas);
    Criticas buscarNotas(Integer notas);
    List<Criticas> buscarCriticasPorUsuarios(Integer idUsuario);
    List<Criticas> buscarCriticasPorIdPelicula(Integer idPelicula);
    Criticas buscarCriticasPorValoracion(String valoracion);

    void guardarCriticas(Criticas criticas);
    void actualizarCriticas(Criticas criticas);
    void eliminarCriticas(Integer idCriticas);
}
