/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entitie.Bieding;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Erwin
 */
@Stateless
public class BiedingFacade extends AbstractFacade<Bieding> implements BiedingFacadeLocal {
    @PersistenceContext(unitName = "ZuydMarktplaats-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BiedingFacade() {
        super(Bieding.class);
    }
    
}
