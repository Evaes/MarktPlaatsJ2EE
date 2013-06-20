/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entitie.Gebruiker;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Erwin
 */
@Stateless
public class GebruikerFacade extends AbstractFacade<Gebruiker> implements GebruikerFacadeLocal {
    @PersistenceContext(unitName = "ZuydMarktplaats-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GebruikerFacade() {
        super(Gebruiker.class);
    }
    
    
    @Override
    public List<Gebruiker> getAllUsers(){
        return em.createQuery("SELECT g FROM Gebruiker g WHERE g.accounttype != 1").getResultList();
    } 
    
    /**
     *
     * @param id
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void deleteUser(Integer id){
        Gebruiker gebruiker = em.find(Gebruiker.class, id);
        em.remove(gebruiker);
    }
}
