/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entitie.Bieding;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Erwin
 */
@Local
public interface BiedingFacadeLocal {

    void create(Bieding bieding);

    void edit(Bieding bieding);

    void remove(Bieding bieding);

    Bieding find(Object id);

    List<Bieding> findAll();

    List<Bieding> findRange(int[] range);

    int count();
    
}
