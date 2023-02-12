package es.uah.usuariosPeliculasEureka.controllerEureka;
import es.uah.usuariosPeliculasEureka.modelEureka.Authorities;
import es.uah.usuariosPeliculasEureka.modelEureka.Users;
import es.uah.usuariosPeliculasEureka.serviceEureka.IAuthoritiesService;
import es.uah.usuariosPeliculasEureka.serviceEureka.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UsuariosController {

    @Autowired
    IUsuariosService usuariosService;

    @GetMapping("/all")
    public List<Users> buscarTodos(){
        return usuariosService.buscarTodos();
    }

    @GetMapping("/find/{idUsuario}")
    public Users buscarUsuarioPorId(@PathVariable("idUsuario") Integer idUsuario) {
        return usuariosService.buscarUsuarioPorId(idUsuario);
    }
    @GetMapping("/login/{email}/{passwd}")
    public Users login(@PathVariable("email") String email, @PathVariable("passwd") String passwd){
        return usuariosService.buscarUsuarioPorEmailAndPasswd(email, passwd);
    }

    @GetMapping("/nombre/{nombre}")
    public Users buscarUsuarioPorNombre(@PathVariable("nombre") String nombre) {
        return usuariosService.buscarUsuarioPorNombre(nombre);
    }
    @GetMapping("/correo/{correo}")
    public Users buscarUsuarioPorCorreo(@PathVariable("correo") String correo) {
        return usuariosService.buscarUsuarioPorCorreo(correo);
    }
    @GetMapping("/enable/{enable}")
    public List<Users> buscarUsuarioAprobado(@PathVariable("enable") Boolean enable) {
        return usuariosService.buscarUsuarioAprobado(enable);
    }
    @PutMapping("/aprobarUsuario/{idUsuario}")
    public boolean aprobarUsuario(@PathVariable("idUsuario") Integer idUsuario) {
        return usuariosService.aprobarUsuario(idUsuario);
    }
    @PostMapping("/save")
    public boolean guardarUsuario(@RequestBody Users usuario) {
        return usuariosService.guardarUsuario(usuario);
    }
    @PutMapping("/edit")
    public boolean actualizarUsuario(@RequestBody Users usuario) { return usuariosService.actualizarUsuario(usuario); }
    @DeleteMapping("/{id}")
    public boolean eliminarUsuario(@PathVariable("id") Integer id){
        return usuariosService.elimininarUsuario(id);
    }
}
