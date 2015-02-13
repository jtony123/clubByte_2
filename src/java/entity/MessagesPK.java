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
public class MessagesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "messageID")
    private int messageID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fromMember_memberID")
    private int fromMembermemberID;

    public MessagesPK() {
    }

    public MessagesPK(int messageID, int fromMembermemberID) {
        this.messageID = messageID;
        this.fromMembermemberID = fromMembermemberID;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public int getFromMembermemberID() {
        return fromMembermemberID;
    }

    public void setFromMembermemberID(int fromMembermemberID) {
        this.fromMembermemberID = fromMembermemberID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) messageID;
        hash += (int) fromMembermemberID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessagesPK)) {
            return false;
        }
        MessagesPK other = (MessagesPK) object;
        if (this.messageID != other.messageID) {
            return false;
        }
        if (this.fromMembermemberID != other.fromMembermemberID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MessagesPK[ messageID=" + messageID + ", fromMembermemberID=" + fromMembermemberID + " ]";
    }
    
}
