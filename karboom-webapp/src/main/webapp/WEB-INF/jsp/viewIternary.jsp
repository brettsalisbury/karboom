<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>View iternary</title>
        <link rel="stylesheet" href="resources/css/blueprint/screen.css" type="text/css" media="screen, projection">
        <link rel="stylesheet" href="resources/css/blueprint/print.css" type="text/css" media="print">

        <!--[if lt IE 8]>
            <link rel="stylesheet" href="resources/css/blueprint/ie.css" type="text/css" media="screen, projection">
        <![endif]-->

        <style type="text/css">
          html { height: 100% }
          body { height: 100%; margin: 0; padding: 0 }
          #map_canvas { height: 100% }
        </style>
        <script type="text/javascript"
          src="http://maps.googleapis.com/maps/api/js?sensor=false">
        </script>
        <script type="text/javascript">
          function initialize() {
            var myOptions = {
              center: new google.maps.LatLng(-34.397, 150.644),
              zoom: 8,
              mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("map_canvas"),
                myOptions);
          }
        </script>
    </head>

    <body onload="initialize()">
        <div class="container">
            <div id="header" class="span-24">
                <h1>Calculated iternary</h1>
            </div>

            <div class="span-24" id="content">
                <h2>Map of suggested routes</h2>
                <div id="map_canvas" style="width:100%; height:100%"></div>
            </div>
        </div>
    </body>


</html>