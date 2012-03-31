package com.acme.karboom.webapp.web;

import com.acme.karboom.webapp.domainwrappers.EventSpringService;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 31/03/12
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddDriversControllerTest {
    private AddDriversController addDriversController;
    private EventSpringService event;

    @Before
    public void setUp() throws Exception {
        EventSpringService serviceEvent = new EventSpringService();
        this.addDriversController = new AddDriversController(serviceEvent);
        this.event = serviceEvent;
    }

    @Test
    public void shouldReturnCorrectViewName() {
        // given
        String expectedViewName = "addDrivers";

        // when
        String actualViewName = addDriversController.getViewForInitialPageLoad();

        // then
        assertThat(actualViewName, is(CoreMatchers.equalTo(expectedViewName)));

    }
}
