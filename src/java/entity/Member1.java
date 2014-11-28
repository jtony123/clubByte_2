/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
    @NamedQuery(name = "Member1.findByUserName", query = "SELECT m FROM Member1 m WHERE m.userName = :userName"),
    @NamedQuery(name = "Member1.findByAddress", query = "SELECT m FROM Member1 m WHERE m.address = :address"),
    @NamedQuery(name = "Member1.findByDob", query = "SELECT m FROM Member1 m WHERE m.dob = :dob"),
    @NamedQuery(name = "Member1.findByMobileNumber", query = "SELECT m FROM Member1 m WHERE m.mobileNumber = :mobileNumber"),
    @NamedQuery(name = "Member1.findByContactNumICE", query = "SELECT m FROM Member1 m WHERE m.contactNumICE = :contactNumICE"),
    @NamedQuery(name = "Member1.findByFirstName", query = "SELECT m FROM Member1 m WHERE m.firstName = :firstName"),
    @NamedQuery(name = "Member1.findBySurName", query = "SELECT m FROM Member1 m WHERE m.surName = :surName"),
    @NamedQuery(name = "Member1.findByEmailAddress", query = "SELECT m FROM Member1 m WHERE m.emailAddress = :emailAddress")})
public class Member1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "memberID")
    private Integer memberID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "userName")
    private String userName;
    @Size(max = 255)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MobileNumber")
    private int mobileNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contactNumICE")
    private int contactNumICE;
    @Column(name = "firstName")
    private Integer firstName;
    @Column(name = "surName")
    private Integer surName;
    @Column(name = "emailAddress")
    private Integer emailAddress;
    @ManyToMany(mappedBy = "member1Collection")
    private Collection<Club> clubCollection;
    @JoinColumn(name = "memberID", referencedColumnName = "personID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Member1() {
    }

    public Member1(Integer memberID) {
        this.memberID = memberID;
    }

    public Member1(Integer memberID, String userName, Date dob, int mobileNumber, int contactNumICE) {
        this.memberID = memberID;
        this.userName = userName;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
        this.contactNumICE = contactNumICE;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getContactNumICE() {
        return contactNumICE;
    }

    public void setContactNumICE(int contactNumICE) {
        this.contactNumICE = contactNumICE;
    }

    public Integer getFirstName() {
        return firstName;
    }

    public void setFirstName(Integer firstName) {
        this.firstName = firstName;
    }

    public Integer getSurName() {
        return surName;
    }

    public void setSurName(Integer surName) {
        this.surName = surName;
    }

    public Integer getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(Integer emailAddress) {
        this.emailAddress = emailAddress;
    }

    @XmlTransient
    public Collection<Club> getClubCollection() {
        return clubCollection;
    }

    public void setClubCollection(Collection<Club> clubCollection) {
        this.clubCollection = clubCollection;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
