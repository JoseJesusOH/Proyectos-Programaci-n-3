package implementaciones;

import entidades.Jugador;
import interfaces.IConexionBD;
import interfaces.IJugadoresDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class JugadoresDAO implements IJugadoresDAO {

    private IConexionBD conexion;

    public JugadoresDAO(IConexionBD conexion) {
        this.conexion = new ConexionBD();
    }

    @Override
    public boolean agregar(Jugador jugador) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.persist(jugador);
            em.getTransaction().commit();
            return true;
        } catch (IllegalStateException e) {
            System.err.println("No se pudo agregar al jugador");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Jugador consultar(Long idJugador) {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.find(Jugador.class, idJugador);
        } catch (IllegalStateException e) {
            System.err.println("No se pudo buscar al jugador" + idJugador);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Jugador> consultarTodos() {
        EntityManager em = this.conexion.crearConexion();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Jugador.class);
        TypedQuery query = em.createQuery(criteria);
        return query.getResultList();
    }

    @Override
    public List<Jugador> consultarPorVideojuego(Long idVideojuego) {
        return null;
    }

}
