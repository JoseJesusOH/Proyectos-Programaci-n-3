/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuegos_130;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author josej
 */
@Entity
@Table(name = "relacion_jugadores_logros")
public class RelacionJugadorLogro implements Serializable {

    @Id
    @Column(name="id_jugador_logro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_jugador", nullable = false)
    private Jugador jugador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_logro", nullable = false)
    private Logro logro;

  
    public RelacionJugadorLogro() {
    }

    public RelacionJugadorLogro(Jugador jugador, Logro logro) {
        this.jugador = jugador;
        this.logro = logro;
    }
  public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Logro getLogro() {
        return logro;
    }

    public void setLogro(Logro logro) {
        this.logro = logro;
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
        if (!(object instanceof RelacionJugadorLogro)) {
            return false;
        }
        RelacionJugadorLogro other = (RelacionJugadorLogro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RelacionJugadorLogro{" + "id=" + id + ", jugador=" + jugador + ", logro=" + logro + '}';
    }

   
}
