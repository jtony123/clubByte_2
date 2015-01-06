/*
 * No license found
 * 
 * 
 */
package session;

import entity.Club;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jtony_000
 */
@Stateless
public class ClubFacade extends AbstractFacade<Club> {
    @PersistenceContext(unitName = "cluBbyte_2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClubFacade() {
        super(Club.class);
    }
    
}
