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
    public List<Gebruiker> getAllUsers() {
        return em.createQuery("SELECT g FROM Gebruiker g WHERE g.accounttype != 1").getResultList();
    }

    /**
     *
     * @param id
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void deleteUser(Integer id) {
        Gebruiker gebruiker = em.find(Gebruiker.class, id);
        em.remove(gebruiker);
    }

    @Override
    public List<Gebruiker> getUserWithUsername(String UserName, String Password) {
        return em.createQuery("SELECT g FROM Gebruiker g WHERE g.username ='" + UserName + "' AND g.password = '" + Password + "'").getResultList();
    }

    @Override
    public void createUser(String UserName, String Password, String Voornaam, String Achternaam, String Email, String TelefoonNummer) {
        Gebruiker gebruiker = new Gebruiker();
        gebruiker.setUsername(UserName);
        gebruiker.setPassword(Password);
        gebruiker.setVoornaam(Voornaam);
        gebruiker.setAchternaam(Achternaam);
        gebruiker.setEmail(Email);
        gebruiker.setTelefoonnummer(TelefoonNummer);
        try {
        em.persist(gebruiker);
        em.flush();
        }
        catch (Exception ex)
        {
            //Gebruiker bestaat al!
        }
    }
}
