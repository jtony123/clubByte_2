/*
 * No license found
 * 
 * 
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jtony_000
 */
@Embeddable
public class EventPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "EventID")
    private int eventID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Club_clubID")
    private int clubclubID;

    public EventPK() {
    }

    public EventPK(int eventID, int clubclubID) {
        this.eventID = eventID;
        this.clubclubID = clubclubID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getClubclubID() {
        return clubclubID;
    }

    public void setClubclubID(int clubclubID) {
        this.clubclubID = clubclubID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) eventID;
        hash += (int) clubclubID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventPK)) {
            return false;
        }
        EventPK other = (EventPK) object;
        if (this.eventID != other.eventID) {
            return false;
        }
        if (this.clubclubID != other.clubclubID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EventPK[ eventID=" + eventID + ", clubclubID=" + clubclubID + " ]";
    }
    
}
