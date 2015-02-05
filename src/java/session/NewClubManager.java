
package session;

import entity.Club;
import entity.Category;
import entity.Fee;
import entity.Member1;
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

    public int createClub(String name, String desc,Category cat, int maxMembers,String parentOrg,String parentURL,Member1 ownerID, Fee fee) {
    
        Club club = addClub(name,desc,cat,maxMembers,parentOrg,parentURL, ownerID, fee);
        return club.getClubID();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Club addClub(String name,String desc,Category cat, int maxMembers,String parentOrg,String parentURL, Member1 ownerID, Fee fee) {
    
        
        Club c = new Club();
        c.setClubName(name);
        c.setDescription(desc);
        c.setCategory(cat);
        c.setMaxMembers(maxMembers);
        c.setParentOrganisation(parentOrg);
        c.setParentURL(parentURL);
        c.setClubOwnerID(ownerID);
        c.setFeefeeID(fee);
    
                
        em.persist(c);
        // have to flush through the database operation to get the 
        // id number created for this member before returning.
        em.flush();
        return c;
    }
}
