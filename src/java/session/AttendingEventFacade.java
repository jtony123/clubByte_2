/*
 * No license found
 * 
 * 
 */
package session;

import entity.AttendingEvent;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jtony_000
 */
@Stateless
public class AttendingEventFacade extends AbstractFacade<AttendingEvent> {
    @PersistenceContext(unitName = "cluBbyte_2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AttendingEventFacade() {
        super(AttendingEvent.class);
    }
    
}
