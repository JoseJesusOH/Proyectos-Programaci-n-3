/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Arrays;


/**
 *
 * @author josej
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Videojuegos_130PU");
//        EntityManager em = emFactory.createEntityManager();
//        em.getTransaction().begin();
//        Jugador jugadorBuscado = em.find(Jugador.class, 2L);
//        Logro logro1 = em.find(Logro.class, 1L);
//        Logro logro2 = em.find(Logro.class, 2L);
//        RelacionJugadorLogro relacion1 = new RelacionJugadorLogro(jugadorBuscado, logro1);
//        RelacionJugadorLogro relacion2 = new RelacionJugadorLogro(jugadorBuscado, logro2);
//        em.persist(relacion1);
//        em.persist(relacion2);
//        em.getTransaction().commit();

//        Jugador jugadorBuscado = em.find(Jugador.class, 2L);
//        Logro logro1 = em.find(Logro.class, 1L);
//        Logro logro2 = em.find(Logro.class, 2L);
//       //Verificar si la lista esta vacia,etc,y asi como abajo
//       jugadorBuscado.getLogros().add(logro1);
//       jugadorBuscado.getLogros().add(logro1);
//        em.persist(jugadorBuscado);
// opcion 2
//logro1.getJugadores().add(jugadorBuscado);
//logro2.getJugadores().add(jugadorBuscado);
//        em.persist(logro1);
//        em.persist(logro2);
//        
//        Videojuego videojuegoBuscado = em.find(Videojuego.class, 16L);
//        Logro logro1 = new Logro("Muerte rapida", 50, videojuegoBuscado);
//        Logro logro2 = new Logro("10 rondas win", 200, videojuegoBuscado);
//Guardar directamente
//        em.persist(logro1);
//        em.persist(logro2);
//Opcion 2{}Setear la lista de logros
//        if (videojuegoBuscado != null) {
//            if (videojuegoBuscado.getLogros() == null || videojuegoBuscado.getLogros().isEmpty()) {
//                videojuegoBuscado.setLogros(Arrays.asList(logro1, logro2));
//            }else{ anañadir elementos a una existente
//            videojuegoBuscado.getLogros().add(logro1);
//            videojuegoBuscado.getLogros().add(logro2);
//            }
//        }
//        em.persist(videojuegoBuscado);
//
////        Jugador jugador = new Jugador("José Jesús", "j@gmail.com");
////        Jugador jugador2 = new Jugador("Judith Orozco", "jo@gmail.com");
////        Jugador jugador3 = new Jugador("Don Gato", "d@gmail.com");
////       
//   
////        
//        em.getTransaction().begin();
////
////        Jugador jugador1 = new Jugador("Jamoncillo ", "jmo@gmail.com");
////        Jugador jugador2 = new Jugador("Duvalin Hernádnez", "duva@gmail.com");
////        Jugador jugador3 = new Jugador("Don nieves", "n@gmail.com");
////        Videojuego videojuego1 = new Videojuego("Fornite", "Epic", jugador2);
////        Videojuego videojuego2 = new Videojuego("Free Fire", "Garena", jugador2);
////        Videojuego videojuego3 = new Videojuego("Minecraft", "Monjac", jugador2);
////        jugador2.setVideojuegos(Arrays.asList(videojuego1,videojuego2,videojuego3));
////        
//////        em.persist(jugador2);
////////        em.persist(jugador2);
////////        em.persist(jugador3);
////        
//
//        Jugador jugadorBuscado = em.find(Jugador.class, 12L);
//        if (jugadorBuscado != null) {
//            System.out.println(jugadorBuscado);
////            Videojuego videojuego4 = new Videojuego("Mario 3", "Nintendo", jugadorBuscado);
////            jugadorBuscado.getVideojuegos().add(videojuego4);
////            em.persist(jugadorBuscado);
//       Videojuego videojuego4 = new Videojuego("Mario 3", "Nintendo", jugadorBuscado);
//            em.persist(videojuego4);
////        for (Videojuego videojuego: jugadorBuscado.getVideojuegos()) {
////            System.out.println(videojuego);
////        }
//        } else {
//            System.out.println("El jugador no existe");
//        }
//        em.getTransaction().commit();
//
////        em.getTransaction().begin();
////        Jugador jugadorEliminado= em.find(Jugador.class,3L);
////        em.remove(jugadorEliminado);
////        
////        em.getTransaction().commit();
////
////        em.getTransaction().begin();
////        
////        Jugador jugadorBuscado=em.find(Jugador.class, 2L);
////        jugadorBuscado.setNombre("Don perro");
////        jugadorBuscado.setEmail("perro@gmail.com");
////        em.persist(jugadorBuscado);
////        
////        em.getTransaction().commit();
////        em.getTransaction().begin();
////        em.persist(jugador2);
////        em.persist(jugador3);
////        em.getTransaction().commit();
    }
    
}
