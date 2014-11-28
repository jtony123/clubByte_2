/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "Event.findByRecurrent", query = "SELECT e FROM Event e WHERE e.recurrent = :recurrent"),
    @NamedQuery(name = "Event.findByVenue", query = "SELECT e FROM Event e WHERE e.venue = :venue")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eventID")
    private Integer eventID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "eventName")
    private String eventName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recurrent")
    private int recurrent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venue")
    private int venue;

    public Event() {
    }

    public Event(Integer eventID) {
        this.eventID = eventID;
    }

    public Event(Integer eventID, String eventName, int recurrent, int venue) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.recurrent = recurrent;
        this.venue = venue;
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

    public int getRecurrent() {
        return recurrent;
    }

    public void setRecurrent(int recurrent) {
        this.recurrent = recurrent;
    }

    public int getVenue() {
        return venue;
    }

    public void setVenue(int venue) {
        this.venue = venue;
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
