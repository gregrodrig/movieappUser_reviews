package es.uah.usuariosPeliculasEureka.modelEureka;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "criticas", schema = "movieuser")
public class Criticas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCriticas")
    private Integer idCriticas;
    @Basic
    @Column(name = "valoracion")
    private String valoracion;
    @Basic
    @Column(name = "nota", length = 2)
    private Integer nota;
    @Basic
    @Column(name = "fecha")
    private String fecha;
    @Basic
    @Column(name = "idPelicula")
    private Integer idPelicula;

    @ManyToOne
    @JoinColumn(name = "users_idUsuario", referencedColumnName = "idUsuario", nullable = false, updatable = false)
    @JsonIgnoreProperties("criticas")
    private Users users;

    public Criticas() {
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getIdCriticas() {
        return idCriticas;
    }

    public void setIdCriticas(Integer idCriticas) {
        this.idCriticas = idCriticas;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criticas criticas = (Criticas) o;
        return Objects.equals(idCriticas, criticas.idCriticas) && Objects.equals(valoracion, criticas.valoracion) && Objects.equals(nota, criticas.nota) && Objects.equals(fecha, criticas.fecha) && Objects.equals(idPelicula, criticas.idPelicula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCriticas, valoracion, nota, fecha, idPelicula);
    }
}
