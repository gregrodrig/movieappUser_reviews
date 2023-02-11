package es.uah.usuariosPeliculasEureka.serviceEureka;
import es.uah.usuariosPeliculasEureka.daoEureka.ICriticasDAO;
import es.uah.usuariosPeliculasEureka.modelEureka.Criticas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICriticasServiceImpl implements ICriticasService{

    @Autowired
    ICriticasDAO criticasDAO;

    @Override
    public List<Criticas> buscarTodos() {
        return criticasDAO.buscarTodos();
    }

    @Override
    public Criticas buscarCriticasPorId(Integer idCriticas) {
        return criticasDAO.buscarCriticasPorId(idCriticas);
    }

    @Override
    public Criticas buscarNotas(Integer notas) {
        return criticasDAO.buscarNotas(notas);
    }

    @Override
    public Criticas buscarCriticasPorUsuarios(Integer idUsuario) {
        return criticasDAO.buscarCriticasPorUsuarios(idUsuario);
    }

    @Override
    public Criticas buscarCriticasPorValoracion(String valoracion) {
        return criticasDAO.buscarCriticasPorValoracion(valoracion);
    }

    @Override
    public boolean guardarCriticas(Criticas criticas) {
        if (criticas.getNota() <= 10){
            criticasDAO.guardarCriticas(criticas);
            return true;
        }
        return false;
    }

    @Override
    public void actualizarCriticas(Criticas criticas) {
        criticasDAO.actualizarCriticas(criticas);
    }

    @Override
    public void eliminarCriticas(Integer idCriticas) {
        criticasDAO.eliminarCriticas(idCriticas);
    }
}
