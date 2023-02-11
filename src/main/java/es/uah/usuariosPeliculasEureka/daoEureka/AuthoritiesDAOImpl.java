package es.uah.usuariosPeliculasEureka.daoEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthoritiesDAOImpl implements IAuthoritiesDAO{

    @Autowired
    IAuthoritiesJPA authoritiesJPA;

    @Override
    public List<Authorities> buscarTodos() {
        return authoritiesJPA.findAll();
    }

    @Override
    public Authorities buscarNombreRol(String authority) {
        return authoritiesJPA.findByAuthorityContainingIgnoreCase(authority);
    }

    @Override
    public Authorities buscarAuhtPorId(Integer idRol) {
        Optional<Authorities> optional = authoritiesJPA.findById(idRol);
        if ( optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void guardarAuthorities(Authorities authority) {
        authoritiesJPA.save(authority);
    }

    @Override
    public void eliminarAuthorities(Integer idRol) {
        authoritiesJPA.deleteById(idRol);
    }

    @Override
    public void actualizarAuthorities(Authorities authority) {
        authoritiesJPA.save(authority);
    }
}
