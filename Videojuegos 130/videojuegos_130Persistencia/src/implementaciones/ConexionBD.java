/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author josej
 */
public class ConexionBD implements IConexionBD {

    @Override
    public EntityManager crearConexion() throws IllegalStateException {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Videojuegos_130PU");
        EntityManager em = emFactory.createEntityManager();
        return em;
    }

}
