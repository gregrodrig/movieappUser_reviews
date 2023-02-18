package es.uah.usuariosPeliculasEureka.daoEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Criticas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CriticasDAOImpl implements ICriticasDAO{

    @Autowired
    ICriticasJPA criticasJPA;

    @Override
    public List<Criticas> buscarTodos() {
        return criticasJPA.findAll();
    }

    @Override
    public Criticas buscarCriticasPorId(Integer idCriticas) {
        Optional<Criticas> optional = criticasJPA.findById(idCriticas);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public Criticas buscarNotas(Integer notas) {
        return criticasJPA.findByNota(notas);
    }

    @Override
    public List<Criticas> buscarCriticasPorUsuarios(Integer idUsuario) {
        return criticasJPA.findByUsers_idUsuario(idUsuario);
    }

    @Override
    public List<Criticas> buscarCriticasPorIdPelicula(Integer idPelicula) {
        return criticasJPA.findByIdPelicula(idPelicula);
    }

    @Override
    public Criticas buscarCriticasPorValoracion(String valoracion) {
        return criticasJPA.findByValoracionContainingIgnoreCase(valoracion);
    }

    @Override
    public void guardarCriticas(Criticas criticas) {
        criticasJPA.save(criticas);
    }

    @Override
    public void actualizarCriticas(Criticas criticas) {
        criticasJPA.save(criticas);
    }

    @Override
    public void eliminarCriticas(Integer idCriticas) {
        criticasJPA.deleteById(idCriticas);
    }
}
