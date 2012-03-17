package com.acme.karboom.webapp.web;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 17/03/12
 * Time: 6:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateEventControllerTest {

    @Test
    public void shouldReturnCreateEventViewFromController()
    {
        // Given
        CreateEventController createEventController = new CreateEventController();
        String expectedViewName = "createEvent";

        // When
        String actualViewName = createEventController.getViewForPageLoad();

        // Then
        assertThat(actualViewName, is(equalTo(expectedViewName)));
    }
}
