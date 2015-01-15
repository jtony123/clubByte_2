/*
 * No license found
 * 
 * 
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jtony_000
 */
@Entity
@Table(name = "Member")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Member1.findAll", query = "SELECT m FROM Member1 m"),
    @NamedQuery(name = "Member1.findByMemberID", query = "SELECT m FROM Member1 m WHERE m.memberID = :memberID"),
    @NamedQuery(name = "Member1.findByFirstName", query = "SELECT m FROM Member1 m WHERE m.firstName = :firstName"),
    @NamedQuery(name = "Member1.findBySurName", query = "SELECT m FROM Member1 m WHERE m.surName = :surName"),
    @NamedQuery(name = "Member1.findByEmailAddress", query = "SELECT m FROM Member1 m WHERE m.emailAddress = :emailAddress"),
    @NamedQuery(name = "Member1.findByUserName", query = "SELECT m FROM Member1 m WHERE m.userName = :userName"),
    @NamedQuery(name = "Member1.findByPassWord", query = "SELECT m FROM Member1 m WHERE m.passWord = :passWord"),
    @NamedQuery(name = "Member1.findByDob", query = "SELECT m FROM Member1 m WHERE m.dob = :dob"),
    @NamedQuery(name = "Member1.findByMobileNo", query = "SELECT m FROM Member1 m WHERE m.mobileNo = :mobileNo"),
    @NamedQuery(name = "Member1.findByContactICE", query = "SELECT m FROM Member1 m WHERE m.contactICE = :contactICE"),
    @NamedQuery(name = "Member1.findByLocation", query = "SELECT m FROM Member1 m WHERE m.location = :location")})
public class Member1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "memberID")
    private Integer memberID;
    @Size(max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 45)
    @Column(name = "surName")
    private String surName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "emailAddress")
    private String emailAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "passWord")
    private String passWord;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 45)
    @Column(name = "mobileNo")
    private String mobileNo;
    @Size(max = 45)
    @Column(name = "contactICE")
    private String contactICE;
    @Size(max = 45)
    @Column(name = "location")
    private String location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member1")
    private Collection<ClubMembers> clubMembersCollection;
    @OneToMany(mappedBy = "clubAdminID")
    private Collection<Club> clubCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clubOwnerID")
    private Collection<Club> clubCollection1;

    public Member1() {
    }

    public Member1(Integer memberID) {
        this.memberID = memberID;
    }

    public Member1(Integer memberID, String emailAddress, String userName, String passWord, Date dob) {
        this.memberID = memberID;
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.passWord = passWord;
        this.dob = dob;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getContactICE() {
        return contactICE;
    }

    public void setContactICE(String contactICE) {
        this.contactICE = contactICE;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public Collection<ClubMembers> getClubMembersCollection() {
        return clubMembersCollection;
    }

    public void setClubMembersCollection(Collection<ClubMembers> clubMembersCollection) {
        this.clubMembersCollection = clubMembersCollection;
    }

    @XmlTransient
    public Collection<Club> getClubCollection() {
        return clubCollection;
    }

    public void setClubCollection(Collection<Club> clubCollection) {
        this.clubCollection = clubCollection;
    }

    @XmlTransient
    public Collection<Club> getClubCollection1() {
        return clubCollection1;
    }

    public void setClubCollection1(Collection<Club> clubCollection1) {
        this.clubCollection1 = clubCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberID != null ? memberID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Member1)) {
            return false;
        }
        Member1 other = (Member1) object;
        if ((this.memberID == null && other.memberID != null) || (this.memberID != null && !this.memberID.equals(other.memberID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Member1[ memberID=" + memberID + " ]";
    }
    
}
