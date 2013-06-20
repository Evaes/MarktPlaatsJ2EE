/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entitie.Advertentie;
import javax.ejb.Stateless;
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
    
}
