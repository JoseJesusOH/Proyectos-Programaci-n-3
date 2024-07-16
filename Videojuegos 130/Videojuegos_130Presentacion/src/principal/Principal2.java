/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import entidades.Jugador;
import implementaciones.DAOSFactory;
import interfaces.IJugadoresDAO;
import java.util.List;

/**
 *
 * @author josej
 */
public class Principal2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IJugadoresDAO jugadoresDAO=DAOSFactory.crearJugadoresDAO();
        
        List<Jugador> lista=jugadoresDAO.consultarTodos();
        
        lista.forEach((jugador) -> {
            System.out.println(jugador.toString());
        });//        // TODO code application logic here
//        IJugadoresDAO jugadoresDAO = DAOSFactory.crearJugadoresDAO();
//        jugadoresDAO.agregar(new Jugador("Jose Jesus", "j@gmail.com"));
//
////        JugadorDAO ju=new J
//////        Jugador jugador = new J
////        jugadoresDAO.agregar();


    }

}
