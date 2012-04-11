package org.acmefireworks;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.IsCollectionContaining.hasItem;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 17/03/12
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class EventTest {

    private Event event;

    @Before
    public void setUp() {
        this.event = new Event();
    }

    @Test
    public void shouldAddPersonToEvent() {

        // given
        Person person = new Person("Basil", "Faulty");

        // when
        this.event.addPersonToEvent(person);

        // then
        assertThat(this.event.getPeopleAttendingEvent().size(), is(equalTo(1)));
    }

    @Test
    public void shouldNotIncrementPeopleAttendingCountIfPersonIsAlreadyAttending() {
        // given
        Person person = new Person("Bart", "Simpson");
        Person samePerson = new Person("Bart", "Simpson");

        // when
        this.event.addPersonToEvent(person);
        this.event.addPersonToEvent(samePerson);

        // then
        assertThat(this.event.getPeopleAttendingEvent().size(), is(equalTo(1)));
    }

    @Test
    public void shouldNominatePersonAsDriverToEvent() {
        // given
        Person person = new Person("Bart", "Simpson");

        // when
        this.event.addDriver(person);

        // then
        assertThat(this.event.getDrivers().size(), is(equalTo(1)));
    }

    @Test
    public void shouldNotIncrementDriversCountIfPersonIsAlreadyAttending() {
        // given
        Person person = new Person("Bart", "Simpson");
        Person samePerson = new Person("Bart", "Simpson");

        // when
        this.event.addDriver(person);
        this.event.addDriver(samePerson);

        // then
        assertThat(this.event.getDrivers().size(), is(equalTo(1)));
    }

    @Test
    public void shouldReturnListOfAllAttendeesNotDriving() {
        // given
        Person driver = new Person("Bart", "Simpson");
        Person nonDriver = new Person("Homer", "Simpson");

        // when
        this.event.addPersonToEvent(driver);
        this.event.addPersonToEvent(nonDriver);
        this.event.addDriver(driver);

        // then
        assertThat(this.event.getNonDrivingEventAttendees().size(), is(equalTo(1)));
        assertThat(this.event.getNonDrivingEventAttendees(), hasItem(nonDriver));
    }
}
