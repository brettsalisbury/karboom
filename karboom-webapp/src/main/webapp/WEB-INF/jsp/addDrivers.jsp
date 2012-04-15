<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Select your drivers</title>
        <link rel="stylesheet" href="resources/css/blueprint/screen.css" type="text/css" media="screen, projection">
        <link rel="stylesheet" href="resources/css/blueprint/print.css" type="text/css" media="print">

        <!--[if lt IE 8]>
            <link rel="stylesheet" href="resources/css/blueprint/ie.css" type="text/css" media="screen, projection">
        <![endif]-->
    </head>

    <body>
        <div class="container">
            <div id="header" class="span-24">
                <h1>Select your drivers!</h1>
                <p>Indicate who can drive a car and the number of people they can carry, and we'll calculate the
                optimal route</p>
            </div>

            <div class="span-16" id="content">
                <h2>Select a driver</h2>
                <form:form commandName="newDrivers">
                    <table id="nominateDrivers">
                        <c:forEach var="nonDriver" items="${nonDrivers}">
                        <tr name="${nonDriver}">
                            <td>${nonDriver}</td>
                            <td><form:checkbox value="${nonDriver}" path="drivers" id="nominateDriver"/></td>
                        </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="2"><input type="submit" /></td>
                        </tr>
                    </table>
                </form:form>
            </div>

            <div class="span-8 last">
                <h2>List of drivers</h2>
                <table id="currentDrivers">
                    <c:forEach var="driver" items="${nominatedDrivers}">
                    <tr>
                        <td>${driver}</td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <a id="nextPage" href="addDrivers">Next</a>
    </body>


</html>