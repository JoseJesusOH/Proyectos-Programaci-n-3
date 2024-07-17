package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "logros")
public class Logro implements Serializable {

    @Id
    @Column(name="id_logro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "puntos", nullable = false)
    private Integer puntos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_videojuego", nullable = false)
    private Videojuego videojuego;
    
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "logro")
    private List<RelacionJugadorLogro> jugadores;

//    @ManyToMany(targetEntity = Jugador.class)
//    private List<Jugador> jugadores;

    public Logro() {
    }

    public Logro(String nombre, Integer puntos, Videojuego videojuego) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.videojuego = videojuego;
    }

    public Logro(Long id, String nombre, Integer puntos, Videojuego videojuego) {
        this.id = id;
        this.nombre = nombre;
        this.puntos = puntos;
        this.videojuego = videojuego;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }

    public List<RelacionJugadorLogro> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<RelacionJugadorLogro> jugadores) {
        this.jugadores = jugadores;
    }

//    public List<Jugador> getJugadores() {
//        return jugadores;
//    }
//
//    public void setJugadores(List<Jugador> jugadores) {
//        this.jugadores = jugadores;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logro)) {
            return false;
        }
        Logro other = (Logro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logro{" + "id=" + id + ", nombre=" + nombre + ", puntos=" + puntos + '}';
    }

}
