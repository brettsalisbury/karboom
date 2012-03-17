package com.acme.karboom.webapp.web;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 5/02/12
 * Time: 8:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldControllerTest {

    private HelloWorldController controller;

    @Before
    public void setUp() throws Exception {
        this.controller = new HelloWorldController();
    }

    @Test
    public void testHelloWorldRequestControllerReturnsHelloWorldResponseText() throws Exception {

        // Given
        String expectedResponseContent = "<html><body>Hello World!</body></html>";

        // When
        String actualResponseContent = this.controller.helloWorld();

        // Then
        assertThat(expectedResponseContent, is(equalTo(actualResponseContent)));
    }
}
