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
public class ClubMembersPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Club_clubID")
    private int clubclubID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Member_memberID")
    private int membermemberID;

    public ClubMembersPK() {
    }

    public ClubMembersPK(int clubclubID, int membermemberID) {
        this.clubclubID = clubclubID;
        this.membermemberID = membermemberID;
    }

    public int getClubclubID() {
        return clubclubID;
    }

    public void setClubclubID(int clubclubID) {
        this.clubclubID = clubclubID;
    }

    public int getMembermemberID() {
        return membermemberID;
    }

    public void setMembermemberID(int membermemberID) {
        this.membermemberID = membermemberID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) clubclubID;
        hash += (int) membermemberID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClubMembersPK)) {
            return false;
        }
        ClubMembersPK other = (ClubMembersPK) object;
        if (this.clubclubID != other.clubclubID) {
            return false;
        }
        if (this.membermemberID != other.membermemberID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClubMembersPK[ clubclubID=" + clubclubID + ", membermemberID=" + membermemberID + " ]";
    }
    
}
