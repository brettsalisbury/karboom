package com.acme.karboom.webapp.web;

import com.acme.karboom.webapp.domainwrappers.EventSpringService;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 15/04/12
 * Time: 4:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewIternaryControllerTest {

    private ViewIternaryController viewIternaryController;
    private EventSpringService event;

    @Before
    public void setUp() throws Exception {
        EventSpringService event = new EventSpringService();
        this.viewIternaryController = new ViewIternaryController(event);
        this.event = event;
    }

    @Test
    public void shouldReturnCorrectViewName() {

        // given
        String expectedViewName = "viewIternary";
        ModelMap model = new ModelMap();

        // when
        String actualViewName = viewIternaryController.getViewForInitialPageLoad(model);

        // then
        assertThat(actualViewName, is(CoreMatchers.equalTo(expectedViewName)));
    }
}
