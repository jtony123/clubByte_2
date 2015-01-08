/*
 * No license found
 * 
 * 
 */
package session;

import com.sun.xml.ws.tx.at.validation.TXAttributesValidator.TransactionAttributeType;
import entity.Member1;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;
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

    public int joinMember(String fname, String sname, String email, String uname, String pword, Object object, int mobnum) {
    
        Member1 member = addMember(fname, sname, email, uname, pword, object, mobnum);
        return member.getMemberID();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private Member1 addMember(String fname, String sname, String email, String uname, String pword, Object object, int mobnum) {
    
        
        Member1 m = new Member1();
        m.setFirstName(fname);
        m.setSurName(sname);
        m.setEmailAddress(email);
        m.setUserName(uname);
        m.setPassWord(pword);
        m.setMobileNo(email);
        Date date = new Date(1111111111);
        m.setDob(date);
        
        em.persist(m);
        // have to flush through the database operation to get the 
        // id number created for this member before returning.
        em.flush();
        return m;
    }
}
