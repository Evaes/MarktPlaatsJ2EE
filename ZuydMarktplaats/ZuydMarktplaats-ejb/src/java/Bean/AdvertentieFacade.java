/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entitie.Advertentie;
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
public class AdvertentieFacade extends AbstractFacade<Advertentie> implements AdvertentieFacadeLocal {
    @PersistenceContext(unitName = "ZuydMarktplaats-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdvertentieFacade() {
        super(Advertentie.class);
    }
    
    @Override
    public List<Advertentie> getAllAdvertisements(){
        return em.createQuery("SELECT a FROM Advertentie a").getResultList();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void deleteAdvertentie(Integer id){
        Advertentie advertentie = em.find(Advertentie.class, id);
        em.remove(advertentie);
    }
}
