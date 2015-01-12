/*
 * No license found
 * 
 * 
 */
package session;

import entity.Member1;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jtony_000
 */
@Stateless
public class NewMemberManager {
    
    @PersistenceContext(unitName = "cluBbyte_2PU")
    private EntityManager em;

    public int joinMember(String fname, String sname, String email, String uname, String pword, Date date, String mobnum, String numICE, String location) {
    
        Member1 member = addMember(fname, sname, email, uname, pword, date, mobnum, numICE, location);
        return member.getMemberID();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Member1 addMember(String fname, String sname, String email, String uname, String pword, Date date, String mobnum, String numICE, String location) {
    
        
        Member1 m = new Member1();
        m.setFirstName(fname);
        m.setSurName(sname);
        m.setEmailAddress(email);
        m.setUserName(uname);
        m.setPassWord(pword);
        m.setMobileNo(mobnum);
        m.setDob(date);
        m.setContactICE(numICE);
        m.setLocation(location);
        
        em.persist(m);
        // have to flush through the database operation to get the 
        // id number created for this member before returning.
        em.flush();
        return m;
    }
}
