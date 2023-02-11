package es.uah.usuariosPeliculasEureka.controllerEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Authorities;
import es.uah.usuariosPeliculasEureka.serviceEureka.IAuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth")
@CrossOrigin
public class AuthoritiesController {

    @Autowired
    IAuthoritiesService authoritiesService;

    @GetMapping("/all")
    public List<Authorities> buscarTodos(){
        return authoritiesService.buscarTodos();
    }
    @GetMapping("/find/{idAuth}")
    public Authorities buscarAuhtPorId(@PathVariable("idAuth") Integer idAuth) {
        return authoritiesService.buscarAuhtPorId(idAuth);
    }
    @GetMapping("nombre/{nombre}")
    public Authorities buscarNombreRol(@PathVariable("nombre") String nombre) {
        return authoritiesService.buscarNombreRol(nombre);
    }

    @PostMapping("/save")
    public void guardarAuthorities(@RequestBody Authorities authority) {
        authoritiesService.guardarAuthorities(authority);
    }
    @PutMapping("/edit")
    public void actualizarAuthorities(@RequestBody Authorities authority) {
        authoritiesService.actualizarAuthorities(authority);
    }
    @DeleteMapping("/{id}")
    public void eliminarAuthorities(@PathVariable("id") Integer id){
        authoritiesService.eliminarAuthorities(id);
    }

}
