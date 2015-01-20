package entity;

import entity.Category;
import entity.ClubMembers;
import entity.Event;
import entity.Member1;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-16T15:31:08")
@StaticMetamodel(Club.class)
public class Club_ { 

    public static volatile SingularAttribute<Club, Integer> maxMembers;
    public static volatile SingularAttribute<Club, String> parentURL;
    public static volatile CollectionAttribute<Club, Event> eventCollection;
    public static volatile SingularAttribute<Club, Member1> clubAdminID;
    public static volatile SingularAttribute<Club, String> clubName;
    public static volatile SingularAttribute<Club, Integer> clubID;
    public static volatile SingularAttribute<Club, String> description;
    public static volatile SingularAttribute<Club, Member1> clubOwnerID;
    public static volatile SingularAttribute<Club, String> parentOrganisation;
    public static volatile CollectionAttribute<Club, ClubMembers> clubMembersCollection;
    public static volatile SingularAttribute<Club, Category> category;

}