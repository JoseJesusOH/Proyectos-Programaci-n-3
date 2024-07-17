package implementaciones;

import interfaces.IConexionBD;
import interfaces.IJugadoresDAO;

public class DAOSFactory {

    private static final IConexionBD conexion = new ConexionBD();

    public static IJugadoresDAO crearJugadoresDAO() {
        return new JugadoresDAO(conexion);
    }

}
