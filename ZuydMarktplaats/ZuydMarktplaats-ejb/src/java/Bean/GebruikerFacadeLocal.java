/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entitie.Gebruiker;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Erwin
 */
@Local
public interface GebruikerFacadeLocal {

    void create(Gebruiker gebruiker);

    void edit(Gebruiker gebruiker);

    void remove(Gebruiker gebruiker);

    Gebruiker find(Object id);

    List<Gebruiker> findAll();

    List<Gebruiker> findRange(int[] range);

    int count();

    public List<Gebruiker> getAllUsers();

    @ TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteUser(Integer id);

    public List<Gebruiker> getUserWithUsername(String UserName, String Password);
    
}
