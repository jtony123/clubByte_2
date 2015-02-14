/*
 * No license found
 * 
 * 
 */
package session;

import entity.Club;
import entity.Member1;
import entity.Messages;
import entity.MessagesPK;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jtony_000
 */
@Stateless
public class MessageManager {

    
    @PersistenceContext(unitName = "cluBbyte_2PU")
    private EntityManager em;
    
    public boolean postMessage(Member1 mSending, Member1 mReceiving, Club club, String msg ) {
        
                    
        MessagesPK msgPK = new MessagesPK();
        msgPK.setFromMembermemberID(mSending.getMemberID());
        Messages thismsg = new Messages();
        thismsg.setToMembermemberID(mReceiving);
        thismsg.setMessageDetails(msg);
        thismsg.setMessagesPK(msgPK);
        Date date = new Date();
        //String x = date.toString();
        thismsg.setMessageDate(date.toString());
        thismsg.setClubclubID(club);

        em.persist(thismsg);
        em.flush();
              
        return true;
    } 
    
    
    
    
}
