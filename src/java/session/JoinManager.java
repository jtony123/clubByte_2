/*
 * No license found
 * 
 * 
 */
package session;

import entity.ClubMembers;
import java.util.List;
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
    
    @EJB
    private ClubMembersFacade clubMembersFacade;
    
    @PersistenceContext(unitName = "cluBbyte_2PU")
    private EntityManager em;   
    
    public List checkMembership(int memberID, int thisClub) {
    return em.createQuery(
        "SELECT c FROM ClubMembers c WHERE c.clubMembersPK.clubclubID = :clubID AND c.clubMembersPK.membermemberID = :memberID")
        .setParameter("clubID", thisClub)
        .setParameter("memberID", memberID)
        .getResultList();
    }

    public boolean joinClub(int memberID, int thisClub) {
        //To change body of generated methods, choose Tools | Templates.
                
        List<ClubMembers> existing = checkMembership(memberID, thisClub);
        
        boolean check = existing.isEmpty();
        
        if (check) {
            ClubMembers clubmembership = new ClubMembers(thisClub, memberID);
            em.persist(clubmembership);
            em.flush();
            return true;
        } else {
            return false;
        } 
    
    }

}
