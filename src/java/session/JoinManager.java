/*
 * No license found
 * 
 * 
 */
package session;

import entity.Club;
import entity.Member1;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jtony_000
 */
@Stateless
public class JoinManager {
    
    @PersistenceContext(unitName = "cluBbyte_2PU")
    private EntityManager em;
    
    private ClubFacade clubFacade;

    public boolean joinClub(int memberID, int thisClub) {
        //To change body of generated methods, choose Tools | Templates.
        
        Club club = clubFacade.find(thisClub);
        
        
    
    
    return true;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
