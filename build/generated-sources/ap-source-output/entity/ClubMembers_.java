package entity;

import entity.Club;
import entity.ClubMembersPK;
import entity.Member1;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-19T13:03:37")
@StaticMetamodel(ClubMembers.class)
public class ClubMembers_ { 

    public static volatile SingularAttribute<ClubMembers, ClubMembersPK> clubMembersPK;
    public static volatile SingularAttribute<ClubMembers, Club> club;
    public static volatile SingularAttribute<ClubMembers, String> feepaid;
    public static volatile SingularAttribute<ClubMembers, Member1> member1;

}