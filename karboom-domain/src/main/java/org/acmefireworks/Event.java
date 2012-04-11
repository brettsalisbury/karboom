package org.acmefireworks;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 17/03/12
 * Time: 3:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Event implements Serializable {

    private static final long serialVersionUID = -2058765367800155049L;

    private Set<Person> nonDrivers;
    private Set<Person> drivers;

    public Event() {
        this.nonDrivers = new HashSet<Person>();
        this.drivers = new HashSet<Person>();
    }

    public Collection<Person> getPeopleAttendingEvent() {
        Set<Person> allAttendees = new HashSet<Person>(nonDrivers);
        allAttendees.addAll(this.drivers);
        return allAttendees;
    }

    public void addPersonToEvent(Person person) {
        this.nonDrivers.add(person);
    }

    public Collection<Person> getDrivers() {
        return drivers;
    }

    public void addDriver(Person driver) {
        this.nonDrivers.remove(driver);
        this.drivers.add(driver);
    }

    public Collection<Person> getNonDrivingEventAttendees() {
        return nonDrivers;
    }
}
