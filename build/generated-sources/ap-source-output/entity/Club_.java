package entity;

import entity.Category;
import entity.ClubMembers;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-16T09:37:46")
@StaticMetamodel(Club.class)
public class Club_ { 

    public static volatile SingularAttribute<Club, Integer> maxMembers;
    public static volatile SingularAttribute<Club, String> clubName;
    public static volatile SingularAttribute<Club, String> clubOwner;
    public static volatile SingularAttribute<Club, Integer> clubID;
    public static volatile SingularAttribute<Club, String> description;
    public static volatile CollectionAttribute<Club, ClubMembers> clubMembersCollection;
    public static volatile SingularAttribute<Club, Category> category;

}