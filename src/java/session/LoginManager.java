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
    
    
    @PersistenceContext(unitName = "cluBbyte_2PU")
    private EntityManager em;


    public List findWithNameAndPassword(String uName, String pWord) {
    return em.createQuery(
        "SELECT c FROM Member1 c WHERE c.userName = :userName AND c.passWord = :passWord")
        .setParameter("userName", uName)
        .setParameter("passWord", pWord)
        .getResultList();
    }  
    
    public boolean checkValidUser(String uName, String pWord) {
     
        List<Member1> l = this.findWithNameAndPassword(uName, pWord);
        
        return (!(l.isEmpty()));
    }
}
