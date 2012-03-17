package com.acme.karboom.webapp.servlet;

import com.acme.karboom.webapp.servlet.mockWebApplication.MockWebApplication;
import com.acme.karboom.webapp.servlet.mockWebApplication.MockWebApplicationContextLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 5/02/12
 * Time: 9:16 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/karboom-servlet.xml", loader = MockWebApplicationContextLoader.class)
@MockWebApplication(name = "HelloWorldController")
public class HelloWorldControllerServletTest {

    @Autowired
    private DispatcherServlet servlet;

    @Test
    public void shouldReturnHelloWorldResponseFromRequestedController() throws IOException, ServletException {
        // Given
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/helloworld");
        MockHttpServletResponse response = new MockHttpServletResponse();
        String expectedResponse = "<html><body>Hello World!</body></html>";

        // When
        servlet.service(request, response);

        // Then
        String actualResponse = response.getContentAsString().trim();
        assertThat(actualResponse, is(equalTo(expectedResponse)));
    }

}
