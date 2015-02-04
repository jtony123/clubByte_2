/*
 * No license found
 * 
 * 
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jtony_000
 */
@Entity
@Table(name = "Fee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fee.findAll", query = "SELECT f FROM Fee f"),
    @NamedQuery(name = "Fee.findByFeeID", query = "SELECT f FROM Fee f WHERE f.feeID = :feeID"),
    @NamedQuery(name = "Fee.findByName", query = "SELECT f FROM Fee f WHERE f.name = :name"),
    @NamedQuery(name = "Fee.findByPeriod", query = "SELECT f FROM Fee f WHERE f.period = :period"),
    @NamedQuery(name = "Fee.findByType", query = "SELECT f FROM Fee f WHERE f.type = :type"),
    @NamedQuery(name = "Fee.findByDetails", query = "SELECT f FROM Fee f WHERE f.details = :details")})
public class Fee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "feeID")
    private Integer feeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "period")
    private String period;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @Size(max = 255)
    @Column(name = "details")
    private String details;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "feefeeID")
    private Collection<Club> clubCollection;

    public Fee() {
    }

    public Fee(Integer feeID) {
        this.feeID = feeID;
    }

    public Fee(Integer feeID, String name) {
        this.feeID = feeID;
        this.name = name;
    }

    public Integer getFeeID() {
        return feeID;
    }

    public void setFeeID(Integer feeID) {
        this.feeID = feeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @XmlTransient
    public Collection<Club> getClubCollection() {
        return clubCollection;
    }

    public void setClubCollection(Collection<Club> clubCollection) {
        this.clubCollection = clubCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feeID != null ? feeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fee)) {
            return false;
        }
        Fee other = (Fee) object;
        if ((this.feeID == null && other.feeID != null) || (this.feeID != null && !this.feeID.equals(other.feeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Fee[ feeID=" + feeID + " ]";
    }
    
}
