package es.uah.usuariosPeliculasEureka.serviceEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Authorities;

import java.util.List;

public interface IAuthoritiesService {
    List<Authorities> buscarTodos();
    Authorities buscarNombreRol(String authority);
    Authorities buscarAuhtPorId(Integer idRol);

    void guardarAuthorities(Authorities authority);
    void eliminarAuthorities(Integer idRol);
    void actualizarAuthorities(Authorities authority);
}
