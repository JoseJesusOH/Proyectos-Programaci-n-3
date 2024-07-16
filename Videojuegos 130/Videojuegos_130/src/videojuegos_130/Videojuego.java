/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos_130;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author josej
 */
@Entity
@Table(name = "videojuegos")
public class Videojuego implements Serializable {

    @Id
    @Column(name = "id_videojuego")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "desarrolladora", nullable = false, length = 200)
    private String desarrolladora;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_jugador", nullable = false)
    private Jugador jugador;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "videojuego")
    private List<Logro> logros;

    public Videojuego() {
    }

    public Videojuego(String nombre, String desarrolladora) {
        this.nombre = nombre;
        this.desarrolladora = desarrolladora;
    }

    public Videojuego(String nombre, String desarrolladora, Jugador jugador) {
        this.nombre = nombre;
        this.desarrolladora = desarrolladora;
        this.jugador = jugador;
    }

    public Videojuego(Long id, String nombre, String desarrolladora, Jugador jugador) {
        this.id = id;
        this.nombre = nombre;
        this.desarrolladora = desarrolladora;
        this.jugador = jugador;
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

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public List<Logro> getLogros() {
        return logros;
    }

    public void setLogros(List<Logro> logros) {
        this.logros = logros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videojuego)) {
            return false;
        }
        Videojuego other = (Videojuego) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Videojuego{" + "id=" + id + ", nombre=" + nombre + ", desarrolladora=" + desarrolladora + ", jugador=" + jugador + '}';
    }

}
