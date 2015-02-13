/*
 * No license found
 * 
 * 
 */
package session;

import entity.AttendingEvent;
import entity.AttendingEventPK;
import entity.Club;
import entity.Event;
import entity.Member1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jtony_000
 */
@Stateless
public class EventManager {

    @PersistenceContext(unitName = "cluBbyte_2PU")
    private EntityManager em;
    
    
    public boolean addNewEvent(String name, String venue, String date, String time, String details, Club thisClub) {
        
        Event e = new Event();
        e.setEventName(name);
        e.setEventVenue(venue);
        e.setEventDate(date);
        //e.setEventTime(time);  // come back and fix the date object set in db for time *********
        e.setEventDetails(details);
        e.setClubclubID1(thisClub);
        
        em.persist(e);
        em.flush(); 
        // come back here and do some validation checks, eg, time in the future, not the past, etc..
        return true;
    }

    
    public boolean gotoEvent (Member1 m, Event e) {
        
        AttendingEventPK attendingEventPK = new  AttendingEventPK(m.getMemberID(), e.getEventID());
            
        AttendingEvent attendingEvent = new AttendingEvent(attendingEventPK);
        
        em.persist(attendingEvent);
        em.flush();
        
        return true;
    }
    
   
    
    
    
    
}
