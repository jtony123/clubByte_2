/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "Club")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Club.findAll", query = "SELECT c FROM Club c"),
    @NamedQuery(name = "Club.findByClubID", query = "SELECT c FROM Club c WHERE c.clubID = :clubID"),
    @NamedQuery(name = "Club.findByClubName", query = "SELECT c FROM Club c WHERE c.clubName = :clubName"),
    @NamedQuery(name = "Club.findByClubOwner", query = "SELECT c FROM Club c WHERE c.clubOwner = :clubOwner"),
    @NamedQuery(name = "Club.findByDescription", query = "SELECT c FROM Club c WHERE c.description = :description"),
    @NamedQuery(name = "Club.findByMaxMembers", query = "SELECT c FROM Club c WHERE c.maxMembers = :maxMembers"),
    @NamedQuery(name = "Club.findByCategory", query = "SELECT c FROM Club c WHERE c.category = :category")})
public class Club implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clubID")
    private Integer clubID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "clubName")
    private String clubName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "clubOwner")
    private String clubOwner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxMembers")
    private int maxMembers;
    @Size(max = 255)
    @Column(name = "category")
    private String category;
    @JoinTable(name = "clubMembership", joinColumns = {
        @JoinColumn(name = "ClubclubID", referencedColumnName = "clubID")}, inverseJoinColumns = {
        @JoinColumn(name = "MembermemberID", referencedColumnName = "memberID")})
    @ManyToMany
    private Collection<Member1> member1Collection;

    public Club() {
    }

    public Club(Integer clubID) {
        this.clubID = clubID;
    }

    public Club(Integer clubID, String clubName, String clubOwner, String description, int maxMembers) {
        this.clubID = clubID;
        this.clubName = clubName;
        this.clubOwner = clubOwner;
        this.description = description;
        this.maxMembers = maxMembers;
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

    public int getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(int maxMembers) {
        this.maxMembers = maxMembers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @XmlTransient
    public Collection<Member1> getMember1Collection() {
        return member1Collection;
    }

    public void setMember1Collection(Collection<Member1> member1Collection) {
        this.member1Collection = member1Collection;
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
