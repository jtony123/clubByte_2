package entity;

import entity.Club;
import entity.ClubMembers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-16T15:31:08")
@StaticMetamodel(Member1.class)
public class Member1_ { 

    public static volatile SingularAttribute<Member1, String> passWord;
    public static volatile SingularAttribute<Member1, String> surName;
    public static volatile CollectionAttribute<Member1, Club> clubCollection;
    public static volatile CollectionAttribute<Member1, Club> clubCollection1;
    public static volatile SingularAttribute<Member1, String> mobileNo;
    public static volatile SingularAttribute<Member1, String> userName;
    public static volatile CollectionAttribute<Member1, ClubMembers> clubMembersCollection;
    public static volatile SingularAttribute<Member1, String> firstName;
    public static volatile SingularAttribute<Member1, String> emailAddress;
    public static volatile SingularAttribute<Member1, Date> dob;
    public static volatile SingularAttribute<Member1, String> location;
    public static volatile SingularAttribute<Member1, String> contactICE;
    public static volatile SingularAttribute<Member1, Integer> memberID;

}