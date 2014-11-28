/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jtony_000
 */
@Entity
@Table(name = "Venue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venue.findAll", query = "SELECT v FROM Venue v"),
    @NamedQuery(name = "Venue.findByVenueID", query = "SELECT v FROM Venue v WHERE v.venueID = :venueID"),
    @NamedQuery(name = "Venue.findByVenueName", query = "SELECT v FROM Venue v WHERE v.venueName = :venueName"),
    @NamedQuery(name = "Venue.findByCapacity", query = "SELECT v FROM Venue v WHERE v.capacity = :capacity"),
    @NamedQuery(name = "Venue.findByVenueFunction", query = "SELECT v FROM Venue v WHERE v.venueFunction = :venueFunction"),
    @NamedQuery(name = "Venue.findByAccessibility", query = "SELECT v FROM Venue v WHERE v.accessibility = :accessibility"),
    @NamedQuery(name = "Venue.findByTimeSlotStartTime", query = "SELECT v FROM Venue v WHERE v.timeSlotStartTime = :timeSlotStartTime"),
    @NamedQuery(name = "Venue.findByDate", query = "SELECT v FROM Venue v WHERE v.date = :date"),
    @NamedQuery(name = "Venue.findByTimePeriod", query = "SELECT v FROM Venue v WHERE v.timePeriod = :timePeriod")})
public class Venue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "venueID")
    private Integer venueID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "venueName")
    private String venueName;
    @Column(name = "capacity")
    private Integer capacity;
    @Size(max = 255)
    @Column(name = "venueFunction")
    private String venueFunction;
    @Size(max = 255)
    @Column(name = "accessibility")
    private String accessibility;
    @Column(name = "timeSlotStartTime")
    @Temporal(TemporalType.TIME)
    private Date timeSlotStartTime;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "timePeriod")
    private Integer timePeriod;

    public Venue() {
    }

    public Venue(Integer venueID) {
        this.venueID = venueID;
    }

    public Venue(Integer venueID, String venueName) {
        this.venueID = venueID;
        this.venueName = venueName;
    }

    public Integer getVenueID() {
        return venueID;
    }

    public void setVenueID(Integer venueID) {
        this.venueID = venueID;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getVenueFunction() {
        return venueFunction;
    }

    public void setVenueFunction(String venueFunction) {
        this.venueFunction = venueFunction;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    public Date getTimeSlotStartTime() {
        return timeSlotStartTime;
    }

    public void setTimeSlotStartTime(Date timeSlotStartTime) {
        this.timeSlotStartTime = timeSlotStartTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(Integer timePeriod) {
        this.timePeriod = timePeriod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (venueID != null ? venueID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venue)) {
            return false;
        }
        Venue other = (Venue) object;
        if ((this.venueID == null && other.venueID != null) || (this.venueID != null && !this.venueID.equals(other.venueID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Venue[ venueID=" + venueID + " ]";
    }
    
}
