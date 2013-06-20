/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entitie.Gebruiker;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Erwin
 */
@Stateless
@LocalBean
public class UserManager {

    @PersistenceContext(unitName = "ZuydMarktplaats-ejbPU")
    private EntityManager em;
    
    public List<Gebruiker> getAllUsers() {
        return em.createQuery("SELECT voornaam FROM gebruiker").getResultList();
    }
}
