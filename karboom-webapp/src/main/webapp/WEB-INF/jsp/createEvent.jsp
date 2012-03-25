<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Create a new event</title>
        <link rel="stylesheet" href="resources/css/blueprint/screen.css" type="text/css" media="screen, projection">
        <link rel="stylesheet" href="resources/css/blueprint/print.css" type="text/css" media="print">

        <!--[if lt IE 8]>
            <link rel="stylesheet" href="resources/css/blueprint/ie.css" type="text/css" media="screen, projection">
        <![endif]-->
    </head>

    <body>
        <div class="container">
            <div id="header" class="span-24">
                <h1>Create a new event!</h1>
                <p>Enter the names and address of the people attending your event and the app will calculate the most
                efficient method of getting everyone there and back again</p>
            </div>

            <div class="span-16" id="content">
                <h2>Add a new attendee to the event!</h2>

                <form:form commandName="person">
                    <table>
                        <tr>
                            <td>First Name:</td>
                            <td><form:input path="firstname"/></td>
                        </tr>
                        <tr>
                            <td>Surname:</td>
                            <td><form:input path="surname"/></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="Add Person"/>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </div>

            <div class="span-8 last">
                <h2>Who is attending this event?</h2>
                <table id="currentNames">
                    <c:forEach var="attendee" items="${peopleAttendingEvent}">
                    <tr>
                        <td>${attendee}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>


</html>