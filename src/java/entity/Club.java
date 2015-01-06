/*
 * No license found
 * 
 * 
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jtony_000
 */
@Entity
@Table(name = "Club")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Club.findAll", query = "SELECT c FROM Club c"),
    @NamedQuery(name = "Club.findByClubID", query = "SELECT c FROM Club c WHERE c.clubID = :clubID"),
    @NamedQuery(name = "Club.findByClubName", query = "SELECT c FROM Club c WHERE c.clubName = :clubName"),
    @NamedQuery(name = "Club.findByClubOwner", query = "SELECT c FROM Club c WHERE c.clubOwner = :clubOwner"),
    @NamedQuery(name = "Club.findByDescription", query = "SELECT c FROM Club c WHERE c.description = :description"),
    @NamedQuery(name = "Club.findByMaxMembers", query = "SELECT c FROM Club c WHERE c.maxMembers = :maxMembers")})
public class Club implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clubID")
    private Integer clubID;
    @Size(max = 45)
    @Column(name = "clubName")
    private String clubName;
    @Size(max = 45)
    @Column(name = "clubOwner")
    private String clubOwner;
    @Size(max = 150)
    @Column(name = "Description")
    private String description;
    @Column(name = "maxMembers")
    private Integer maxMembers;
    @JoinColumn(name = "category", referencedColumnName = "name")
    @ManyToOne(optional = false)
    private Category category;

    public Club() {
    }

    public Club(Integer clubID) {
        this.clubID = clubID;
    }

    public Integer getClubID() {
        return clubID;
    }

    public void setClubID(Integer clubID) {
        this.clubID = clubID;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubOwner() {
        return clubOwner;
    }

    public void setClubOwner(String clubOwner) {
        this.clubOwner = clubOwner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(Integer maxMembers) {
        this.maxMembers = maxMembers;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clubID != null ? clubID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Club)) {
            return false;
        }
        Club other = (Club) object;
        if ((this.clubID == null && other.clubID != null) || (this.clubID != null && !this.clubID.equals(other.clubID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Club[ clubID=" + clubID + " ]";
    }
    
}
