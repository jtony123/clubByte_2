/*
 * No license found
 * 
 * 
 */
package session;

import entity.Member1;
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
public class LoginManager {
    @EJB
    private Member1Facade member1Facade;
    
    
    @PersistenceContext(unitName = "cluBbyte_2PU")
    private EntityManager em;


    public List findWithNameAndPassword(String uName, String pWord) {
    return em.createQuery(
        "SELECT c FROM Member1 c WHERE c.userName = :userName AND c.passWord = :passWord")
        .setParameter("userName", uName)
        .setParameter("passWord", pWord)
        .getResultList();
    }  
    
    public int checkValidUser(String uName, String pWord) {

        List<Member1> l = this.findWithNameAndPassword(uName, pWord);
        if (!(l.isEmpty())) {
            Member1 m = l.get(0);
            int memberID = m.getMemberID();
            return memberID;
        } else return 0;
        
        //return (!(l.isEmpty()));
    }
}
