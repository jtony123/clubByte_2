/*
 * No license found
 * 
 * 
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jtony_000
 */
@Entity
@Table(name = "AttendingEvent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttendingEvent.findAll", query = "SELECT a FROM AttendingEvent a"),
    @NamedQuery(name = "AttendingEvent.findByMembermemberID", query = "SELECT a FROM AttendingEvent a WHERE a.attendingEventPK.membermemberID = :membermemberID"),
    @NamedQuery(name = "AttendingEvent.findByEventEventID", query = "SELECT a FROM AttendingEvent a WHERE a.attendingEventPK.eventEventID = :eventEventID"),
    @NamedQuery(name = "AttendingEvent.findByDatelogged", query = "SELECT a FROM AttendingEvent a WHERE a.datelogged = :datelogged")})
public class AttendingEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AttendingEventPK attendingEventPK;
    @Column(name = "Datelogged")
    @Temporal(TemporalType.DATE)
    private Date datelogged;
    @JoinColumn(name = "Member_memberID", referencedColumnName = "memberID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Member1 member1;
    @JoinColumn(name = "Event_EventID", referencedColumnName = "EventID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Event event;

    public AttendingEvent() {
    }

    public AttendingEvent(AttendingEventPK attendingEventPK) {
        this.attendingEventPK = attendingEventPK;
    }

    public AttendingEvent(int membermemberID, int eventEventID) {
        this.attendingEventPK = new AttendingEventPK(membermemberID, eventEventID);
    }

    public AttendingEventPK getAttendingEventPK() {
        return attendingEventPK;
    }

    public void setAttendingEventPK(AttendingEventPK attendingEventPK) {
        this.attendingEventPK = attendingEventPK;
    }

    public Date getDatelogged() {
        return datelogged;
    }

    public void setDatelogged(Date datelogged) {
        this.datelogged = datelogged;
    }

    public Member1 getMember1() {
        return member1;
    }

    public void setMember1(Member1 member1) {
        this.member1 = member1;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attendingEventPK != null ? attendingEventPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttendingEvent)) {
            return false;
        }
        AttendingEvent other = (AttendingEvent) object;
        if ((this.attendingEventPK == null && other.attendingEventPK != null) || (this.attendingEventPK != null && !this.attendingEventPK.equals(other.attendingEventPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AttendingEvent[ attendingEventPK=" + attendingEventPK + " ]";
    }
    
}
