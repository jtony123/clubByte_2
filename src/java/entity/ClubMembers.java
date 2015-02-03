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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jtony_000
 */
@Entity
@Table(name = "clubMembers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClubMembers.findAll", query = "SELECT c FROM ClubMembers c"),
    @NamedQuery(name = "ClubMembers.findByClubclubID", query = "SELECT c FROM ClubMembers c WHERE c.clubMembersPK.clubclubID = :clubclubID"),
    @NamedQuery(name = "ClubMembers.findByMembermemberID", query = "SELECT c FROM ClubMembers c WHERE c.clubMembersPK.membermemberID = :membermemberID"),
    @NamedQuery(name = "ClubMembers.findByFeepaid", query = "SELECT c FROM ClubMembers c WHERE c.feepaid = :feepaid"),
    @NamedQuery(name = "ClubMembers.findByDateJoined", query = "SELECT c FROM ClubMembers c WHERE c.dateJoined = :dateJoined")})
public class ClubMembers implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClubMembersPK clubMembersPK;
    @Size(max = 45)
    @Column(name = "feepaid")
    private String feepaid;
    @Column(name = "dateJoined")
    @Temporal(TemporalType.DATE)
    private Date dateJoined;
    @JoinColumn(name = "Member_memberID", referencedColumnName = "memberID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Member1 member1;
    @JoinColumn(name = "Club_clubID", referencedColumnName = "clubID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Club club;

    public ClubMembers() {
    }

    public ClubMembers(ClubMembersPK clubMembersPK) {
        this.clubMembersPK = clubMembersPK;
    }

    public ClubMembers(int clubclubID, int membermemberID) {
        this.clubMembersPK = new ClubMembersPK(clubclubID, membermemberID);
    }

    public ClubMembersPK getClubMembersPK() {
        return clubMembersPK;
    }

    public void setClubMembersPK(ClubMembersPK clubMembersPK) {
        this.clubMembersPK = clubMembersPK;
    }

    public String getFeepaid() {
        return feepaid;
    }

    public void setFeepaid(String feepaid) {
        this.feepaid = feepaid;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Member1 getMember1() {
        return member1;
    }

    public void setMember1(Member1 member1) {
        this.member1 = member1;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clubMembersPK != null ? clubMembersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClubMembers)) {
            return false;
        }
        ClubMembers other = (ClubMembers) object;
        if ((this.clubMembersPK == null && other.clubMembersPK != null) || (this.clubMembersPK != null && !this.clubMembersPK.equals(other.clubMembersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClubMembers[ clubMembersPK=" + clubMembersPK + " ]";
    }
    
}
