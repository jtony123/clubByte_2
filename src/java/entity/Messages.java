/*
 * No license found
 * 
 * 
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "Messages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m"),
    @NamedQuery(name = "Messages.findByMessageID", query = "SELECT m FROM Messages m WHERE m.messagesPK.messageID = :messageID"),
    @NamedQuery(name = "Messages.findByFromMembermemberID", query = "SELECT m FROM Messages m WHERE m.messagesPK.fromMembermemberID = :fromMembermemberID"),
    @NamedQuery(name = "Messages.findByMessageDate", query = "SELECT m FROM Messages m WHERE m.messageDate = :messageDate"),
    @NamedQuery(name = "Messages.findByMessageDetails", query = "SELECT m FROM Messages m WHERE m.messageDetails = :messageDetails")})
public class Messages implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MessagesPK messagesPK;
    @Size(max = 45)
    @Column(name = "messageDate")
    private String messageDate;
    @Size(max = 250)
    @Column(name = "messageDetails")
    private String messageDetails;
    @JoinColumn(name = "toMember_memberID", referencedColumnName = "memberID")
    @ManyToOne(optional = false)
    private Member1 toMembermemberID;
    @JoinColumn(name = "fromMember_memberID", referencedColumnName = "memberID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Member1 member1;
    @JoinColumn(name = "Club_clubID", referencedColumnName = "clubID")
    @ManyToOne(optional = false)
    private Club clubclubID;

    public Messages() {
    }

    public Messages(MessagesPK messagesPK) {
        this.messagesPK = messagesPK;
    }

    public Messages(int messageID, int fromMembermemberID) {
        this.messagesPK = new MessagesPK(messageID, fromMembermemberID);
    }

    public MessagesPK getMessagesPK() {
        return messagesPK;
    }

    public void setMessagesPK(MessagesPK messagesPK) {
        this.messagesPK = messagesPK;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessageDetails() {
        return messageDetails;
    }

    public void setMessageDetails(String messageDetails) {
        this.messageDetails = messageDetails;
    }

    public Member1 getToMembermemberID() {
        return toMembermemberID;
    }

    public void setToMembermemberID(Member1 toMembermemberID) {
        this.toMembermemberID = toMembermemberID;
    }

    public Member1 getMember1() {
        return member1;
    }

    public void setMember1(Member1 member1) {
        this.member1 = member1;
    }

    public Club getClubclubID() {
        return clubclubID;
    }

    public void setClubclubID(Club clubclubID) {
        this.clubclubID = clubclubID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messagesPK != null ? messagesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.messagesPK == null && other.messagesPK != null) || (this.messagesPK != null && !this.messagesPK.equals(other.messagesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Messages[ messagesPK=" + messagesPK + " ]";
    }
    
}
