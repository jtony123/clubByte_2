package entity;

import entity.Club;
import entity.EventPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-16T15:31:08")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, EventPK> eventPK;
    public static volatile SingularAttribute<Event, String> eventVenue;
    public static volatile SingularAttribute<Event, Date> eventTime;
    public static volatile SingularAttribute<Event, Club> club;
    public static volatile SingularAttribute<Event, String> eventName;
    public static volatile SingularAttribute<Event, Date> eventDate;

}