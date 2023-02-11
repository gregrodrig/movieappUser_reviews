package es.uah.usuariosPeliculasEureka.serviceEureka;
import es.uah.usuariosPeliculasEureka.daoEureka.IAuthoritiesDAO;
import es.uah.usuariosPeliculasEureka.modelEureka.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAuthoritiesServiceImpl implements IAuthoritiesService{

    @Autowired
    IAuthoritiesDAO authoritiesDAO;

    @Override
    public List<Authorities> buscarTodos() {
        return authoritiesDAO.buscarTodos();
    }

    @Override
    public Authorities buscarNombreRol(String authority) {
        return authoritiesDAO.buscarNombreRol(authority);
    }

    @Override
    public Authorities buscarAuhtPorId(Integer idRol) {
        return authoritiesDAO.buscarAuhtPorId(idRol);
    }

    @Override
    public void guardarAuthorities(Authorities authority) {
        authoritiesDAO.guardarAuthorities(authority);
    }

    @Override
    public void eliminarAuthorities(Integer idRol) {
        authoritiesDAO.eliminarAuthorities(idRol);
    }

    @Override
    public void actualizarAuthorities(Authorities authority) {
        authoritiesDAO.actualizarAuthorities(authority);
    }
}
