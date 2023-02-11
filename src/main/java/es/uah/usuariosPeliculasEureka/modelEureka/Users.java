package es.uah.usuariosPeliculasEureka.modelEureka;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users", schema = "movieuser")
public class Users {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;
    @Basic
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Basic
    @Column(name = "password", length = 20)
    private String password;
    @Basic
    @Column(name = "correo", nullable = false, length = 20)
    private String correo;
    @Basic
    @Column(name = "enable")
    private boolean enable;

    @ManyToMany(fetch=FetchType.EAGER)
    @JsonIgnoreProperties("authorities_IdRol")
    @JoinTable(name = "users_has_authorities",
            joinColumns = { @JoinColumn(name = "users_idUsuario", referencedColumnName = "idUsuario")},
            inverseJoinColumns = { @JoinColumn(name = "authorities_IdRol", referencedColumnName = "idRol") } )
    private List<Authorities> roles;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Criticas> critica;//= new ArrayList<>();

    public List<Criticas> getCritica() {
        return critica;
    }

    public Users() {
    }

    public Users(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Users(String username, String password, String correo, boolean enable, List<Authorities> roles, List<Criticas> critica) {
        this.username = username;
        this.password = password;
        this.correo = correo;
        this.enable = enable;
        this.roles = roles;
        this.critica = critica;
    }

    public boolean isEnable() {
        return enable;
    }

    public Users(List<Criticas> critica) {
        this.critica = critica;
    }

    public void setCritica(List<Criticas> critica) {
        this.critica = critica;
    }

    public List<Authorities> getRoles() {
        return roles;
    }

    public void setRoles(List<Authorities> roles) {
        this.roles = roles;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @JsonIgnore
    @JsonProperty(value = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void addCritica(Criticas critica){
        getCritica().add(critica);
        critica.setUsers(this);
    }
    public void removeCritica(Integer idCritica){
        if (idCritica != null) {
            getCritica().remove(idCritica);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(idUsuario, users.idUsuario) && Objects.equals(username, users.username) && Objects.equals(password, users.password) && Objects.equals(correo, users.correo) && Objects.equals(enable, users.enable) && Objects.equals(roles, users.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, username, password, correo, enable, roles);
    }
}
