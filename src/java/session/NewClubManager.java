
package session;

import entity.Club;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dylan
 */
@Stateless
public class NewClubManager {
    
    @PersistenceContext(unitName = "cluBbyte_2PU")
    private EntityManager em;

    public int joinClub(String name, String desc,String category, int maxMembers) {
    
        Club club = addClub(name,desc,category,maxMembers);
        return club.getClubID();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Club addClub(String name,String desc,String category, int maxMembers ) {
    
        
        Club c = new Club();
        c.setClubName(name);
        c.setDescription(desc);
        //c.setCategory(category);
        c.setMaxMembers(maxMembers);
        
        
        em.persist(c);
        // have to flush through the database operation to get the 
        // id number created for this member before returning.
        em.flush();
        return c;
    }
}
