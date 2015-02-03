/*
 * No license found
 * 
 * 
 */
package session;

import entity.Club;
import entity.ClubMembers;
import entity.ClubMembersPK;
import entity.Member1;
import java.util.Collection;
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
    
    @EJB
    private ClubFacade clubFacade;
    
    @PersistenceContext(unitName = "cluBbyte_2PU")
    private EntityManager em;   
    
    
    public boolean joinClub(Member1 m, Club thisClub) {
        //To change body of generated methods, choose Tools | Templates.
        Club club = clubFacade.find(thisClub.getClubID());
        int max = club.getMaxMembers();
        
        Collection<ClubMembers> cm = club.getClubMembersCollection();
        int size = cm.size();
        
        boolean notMember = true;
        for (ClubMembers mm : cm) {
            if (mm.getMember1().getMemberID() == m.getMemberID()) {
                notMember = false;
            }
        }
        
        boolean space = max > size;
        
        if (space && notMember) {
            
            ClubMembers clubmembership = new ClubMembers(thisClub.getClubID(), m.getMemberID());
            em.persist(clubmembership);
            em.flush();
            return true;
        } else {
            return false;
        } 
    
    }
    
    public void leaveClub(Member1 member, Club club) {
                
        ClubMembersPK cmpk = new ClubMembersPK(club.getClubID(), member.getMemberID());
        ClubMembers cm = new ClubMembers(cmpk);
        //ClubMembers cm = clubMembersFacade.find(new ClubMembers(club.getClubID(), member.getMemberID()));
        clubMembersFacade.remove(cm);
        
    }

}
