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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "Club.findByDescription", query = "SELECT c FROM Club c WHERE c.description = :description"),
    @NamedQuery(name = "Club.findByMaxMembers", query = "SELECT c FROM Club c WHERE c.maxMembers = :maxMembers"),
    @NamedQuery(name = "Club.findByParentOrganisation", query = "SELECT c FROM Club c WHERE c.parentOrganisation = :parentOrganisation"),
    @NamedQuery(name = "Club.findByParentURL", query = "SELECT c FROM Club c WHERE c.parentURL = :parentURL"),
    @NamedQuery(name = "Club.findByClubImageFilename", query = "SELECT c FROM Club c WHERE c.clubImageFilename = :clubImageFilename")})
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
    @Size(max = 150)
    @Column(name = "Description")
    private String description;
    @Column(name = "maxMembers")
    private Integer maxMembers;
    @Size(max = 45)
    @Column(name = "parentOrganisation")
    private String parentOrganisation;
    @Size(max = 100)
    @Column(name = "parentURL")
    private String parentURL;
    @Size(max = 90)
    @Column(name = "clubImageFilename")
    private String clubImageFilename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "club")
    private Collection<ClubMembers> clubMembersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clubclubID1")
    private Collection<Event> eventCollection;
    @JoinColumn(name = "category", referencedColumnName = "name")
    @ManyToOne(optional = false)
    private Category category;
    @JoinColumn(name = "clubAdminID", referencedColumnName = "memberID")
    @ManyToOne
    private Member1 clubAdminID;
    @JoinColumn(name = "clubOwnerID", referencedColumnName = "memberID")
    @ManyToOne(optional = false)
    private Member1 clubOwnerID;
    @JoinColumn(name = "Fee_feeID", referencedColumnName = "feeID")
    @ManyToOne(optional = false)
    private Fee feefeeID;

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

    public String getParentOrganisation() {
        return parentOrganisation;
    }

    public void setParentOrganisation(String parentOrganisation) {
        this.parentOrganisation = parentOrganisation;
    }

    public String getParentURL() {
        return parentURL;
    }

    public void setParentURL(String parentURL) {
        this.parentURL = parentURL;
    }

    public String getClubImageFilename() {
        return clubImageFilename;
    }

    public void setClubImageFilename(String clubImageFilename) {
        this.clubImageFilename = clubImageFilename;
    }

    @XmlTransient
    public Collection<ClubMembers> getClubMembersCollection() {
        return clubMembersCollection;
    }

    public void setClubMembersCollection(Collection<ClubMembers> clubMembersCollection) {
        this.clubMembersCollection = clubMembersCollection;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Member1 getClubAdminID() {
        return clubAdminID;
    }

    public void setClubAdminID(Member1 clubAdminID) {
        this.clubAdminID = clubAdminID;
    }

    public Member1 getClubOwnerID() {
        return clubOwnerID;
    }

    public void setClubOwnerID(Member1 clubOwnerID) {
        this.clubOwnerID = clubOwnerID;
    }

    public Fee getFeefeeID() {
        return feefeeID;
    }

    public void setFeefeeID(Fee feefeeID) {
        this.feefeeID = feefeeID;
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
