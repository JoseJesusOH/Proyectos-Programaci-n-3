package interfaces;

import java.util.List;
import entidades.Jugador;

public interface IJugadoresDAO {

    public boolean agregar(Jugador jugador);

    public Jugador consultar(Long idJugador);

    public List<Jugador> consultarTodos();

    public List<Jugador> consultarPorVideojuego(Long idVideojuego);

}
