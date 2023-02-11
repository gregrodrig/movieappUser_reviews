package es.uah.usuariosPeliculasEureka.daoEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Authorities;

import java.util.List;

public interface IAuthoritiesDAO {
    List<Authorities> buscarTodos();
    Authorities buscarNombreRol(String authority);
    Authorities buscarAuhtPorId(Integer idRol);

    void guardarAuthorities(Authorities authority);
    void eliminarAuthorities(Integer idRol);
    void actualizarAuthorities(Authorities authority);
}
