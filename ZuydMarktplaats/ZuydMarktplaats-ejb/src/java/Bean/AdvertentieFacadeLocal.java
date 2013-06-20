/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entitie.Advertentie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Erwin
 */
@Local
public interface AdvertentieFacadeLocal {

    void create(Advertentie advertentie);

    void edit(Advertentie advertentie);

    void remove(Advertentie advertentie);

    Advertentie find(Object id);

    List<Advertentie> findAll();

    List<Advertentie> findRange(int[] range);

    int count();
    
}
