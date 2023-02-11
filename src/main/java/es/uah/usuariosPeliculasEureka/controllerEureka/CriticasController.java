package es.uah.usuariosPeliculasEureka.controllerEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Criticas;
import es.uah.usuariosPeliculasEureka.serviceEureka.ICriticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("criticas")
@CrossOrigin
public class CriticasController {

    @Autowired
    ICriticasService criticasService;

    @GetMapping("/all")
    public List<Criticas> buscarTodos(){
        return criticasService.buscarTodos();
    }

    @GetMapping("/find/{idCritica}")
    public Criticas buscarCriticasPorId(@PathVariable("idCritica") Integer idCritica) {
        return criticasService.buscarCriticasPorId(idCritica);
    }
    @GetMapping("nota/{nota}")
    public Criticas buscarNotas(@PathVariable("nota") Integer nota) {
        return criticasService.buscarNotas(nota);
    }

    @GetMapping("porUsuarios/{idUsuario}")
    public Criticas buscarCriticasPorUsuarios(@PathVariable("idUsuario") Integer idUsuario) {
        return criticasService.buscarCriticasPorUsuarios(idUsuario);
    }
    @GetMapping("porValoracion/{valoracion}")
    public Criticas buscarCriticasPorValoracion(@PathVariable("valoracion") String valoracion) {
        return criticasService.buscarCriticasPorValoracion(valoracion);
    }
    @PostMapping("/save")
    public boolean guardarCriticas(@RequestBody Criticas criticas) {
        return criticasService.guardarCriticas(criticas);
    }
    @PutMapping("/edit")
    public void actualizarCriticas(@RequestBody Criticas criticas) {
        criticasService.actualizarCriticas(criticas);
    }
    @DeleteMapping("/{idCriticas}")
    public void eliminarCriticas(@PathVariable("idCriticas") Integer idCriticas){
        criticasService.eliminarCriticas(idCriticas);
    }

}