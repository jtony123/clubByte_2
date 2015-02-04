/*
 * No license found
 * 
 * 
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jtony_000
 */
@Entity
@Table(name = "Event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByEventID", query = "SELECT e FROM Event e WHERE e.eventID = :eventID"),
    @NamedQuery(name = "Event.findByEventName", query = "SELECT e FROM Event e WHERE e.eventName = :eventName"),
    @NamedQuery(name = "Event.findByEventVenue", query = "SELECT e FROM Event e WHERE e.eventVenue = :eventVenue"),
    @NamedQuery(name = "Event.findByEventDate", query = "SELECT e FROM Event e WHERE e.eventDate = :eventDate"),
    @NamedQuery(name = "Event.findByEventDetails", query = "SELECT e FROM Event e WHERE e.eventDetails = :eventDetails"),
    @NamedQuery(name = "Event.findByEventTime", query = "SELECT e FROM Event e WHERE e.eventTime = :eventTime"),
    @NamedQuery(name = "Event.findByRecurring", query = "SELECT e FROM Event e WHERE e.recurring = :recurring")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EventID")
    private Integer eventID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "eventName")
    private String eventName;
    @Size(max = 45)
    @Column(name = "eventVenue")
    private String eventVenue;
    @Size(max = 45)
    @Column(name = "eventDate")
    private String eventDate;
    @Size(max = 450)
    @Column(name = "EventDetails")
    private String eventDetails;
    @Column(name = "eventTime")
    @Temporal(TemporalType.TIME)
    private Date eventTime;
    @Size(max = 45)
    @Column(name = "recurring")
    private String recurring;
    @JoinColumn(name = "Club_clubID1", referencedColumnName = "clubID")
    @ManyToOne(optional = false)
    private Club clubclubID1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private Collection<AttendingEvent> attendingEventCollection;

    public Event() {
    }

    public Event(Integer eventID) {
        this.eventID = eventID;
    }

    public Event(Integer eventID, String eventName) {
        this.eventID = eventID;
        this.eventName = eventName;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getRecurring() {
        return recurring;
    }

    public void setRecurring(String recurring) {
        this.recurring = recurring;
    }

    public Club getClubclubID1() {
        return clubclubID1;
    }

    public void setClubclubID1(Club clubclubID1) {
        this.clubclubID1 = clubclubID1;
    }

    @XmlTransient
    public Collection<AttendingEvent> getAttendingEventCollection() {
        return attendingEventCollection;
    }

    public void setAttendingEventCollection(Collection<AttendingEvent> attendingEventCollection) {
        this.attendingEventCollection = attendingEventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventID != null ? eventID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventID == null && other.eventID != null) || (this.eventID != null && !this.eventID.equals(other.eventID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Event[ eventID=" + eventID + " ]";
    }
    
}
