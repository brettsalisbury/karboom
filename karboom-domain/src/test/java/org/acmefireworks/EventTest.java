package org.acmefireworks;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

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
    public void setUp()
    {
        this.event = new Event();
    }

    @Test
    public void shouldAddPersonToEvent()
    {

        // given
        Person person = new Person("Basil", "Faulty");

        // when
        this.event.addPersonToEvent(person);

        // then
        assertThat(this.event.getPeopleAttendingEvent().size(), is(equalTo(1)));
    }

    @Test
    public void shouldNotIncrementPeopleAttendingCountIfPersonIsAlreadyAttending()
    {
        // given
        Person person = new Person("Bart", "Simpson");
        Person samePerson = new Person("Bart", "Simpson");

        // when
        this.event.addPersonToEvent(person);
        this.event.addPersonToEvent(samePerson);

        // then
        assertThat(this.event.getPeopleAttendingEvent().size(), is(equalTo(1)));
    }
}
