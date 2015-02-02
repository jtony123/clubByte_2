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
public class AttendingEventPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Member_memberID")
    private int membermemberID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Event_EventID")
    private int eventEventID;

    public AttendingEventPK() {
    }

    public AttendingEventPK(int membermemberID, int eventEventID) {
        this.membermemberID = membermemberID;
        this.eventEventID = eventEventID;
    }

    public int getMembermemberID() {
        return membermemberID;
    }

    public void setMembermemberID(int membermemberID) {
        this.membermemberID = membermemberID;
    }

    public int getEventEventID() {
        return eventEventID;
    }

    public void setEventEventID(int eventEventID) {
        this.eventEventID = eventEventID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) membermemberID;
        hash += (int) eventEventID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttendingEventPK)) {
            return false;
        }
        AttendingEventPK other = (AttendingEventPK) object;
        if (this.membermemberID != other.membermemberID) {
            return false;
        }
        if (this.eventEventID != other.eventEventID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AttendingEventPK[ membermemberID=" + membermemberID + ", eventEventID=" + eventEventID + " ]";
    }
    
}
