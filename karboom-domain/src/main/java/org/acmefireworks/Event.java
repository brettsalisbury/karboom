package org.acmefireworks;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 17/03/12
 * Time: 3:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Event {
    private Set<Person> people;

    public Event() {
        this.people = new HashSet<Person>();
    }

    public Collection<Person> getPeopleAttendingEvent() {
        return people;
    }

    public void addPersonToEvent(Person person) {
        this.people.add(person);
    }
}
