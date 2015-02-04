/*
 * No license found
 * 
 * 
 */
package session;

import entity.Fee;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jtony_000
 */
@Stateless
public class FeeFacade extends AbstractFacade<Fee> {
    @PersistenceContext(unitName = "cluBbyte_2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FeeFacade() {
        super(Fee.class);
    }
    
}
