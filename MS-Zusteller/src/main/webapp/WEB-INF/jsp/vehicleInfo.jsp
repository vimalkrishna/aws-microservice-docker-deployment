<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>

  <head>
    <!-- <meta http-equiv="refresh" content="3"> -->
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Vehicle Information</title>
    <style>
      #map {
        margin: auto;
        width: 70%;
        height: 700px;
      }
    </style>
  </head>

  <body>
    <h1>Vehicle Info for ${model.vehicle.name}</h1>

    <p>The last report for this vehicle was at ${model.position.timestamp}</p>

    <p>It was at lat long ${model.position.lat}, ${model.position.longitude}</p>

    <div id="map"></div>
    <script>
      function initMap() {
        var myLatLng = { lat: ${ model.position.lat }, lng: ${ model.position.longitude }
      };

      var mapDiv = document.getElementById('map');
      var map = new google.maps.Map(mapDiv, {

        center: myLatLng,
        zoom: 16
      });

      var marker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        title: '${model.position.timestamp}'
      });
      /*
    
       // Initialize Polyline to track the route
  	var routePath = new google.maps.Polyline({
    path: [myLatLng], // Start with current position
    geodesic: true,
    strokeColor: "#FF0000", // Red color for travelled route
    strokeOpacity: 1.0,
    strokeWeight: 4
  });
      
      routePath.setMap(map);

  // Function to update position & route dynamically
  function updateRoute(newLatLng) {
    var path = routePath.getPath();
    path.push(newLatLng); // Add new coordinate to the route

    marker.setPosition(newLatLng); // Move marker to new position
    map.setCenter(newLatLng); // Keep the map centered
  }
      
      // Simulating position updates (replace this with real-time GPS data)
  setInterval(() => {
    var newLatLng = {
      lat: model.position.lat + (Math.random() * 0.001 - 0.0005), // Simulated movement
      lng: model.position.longitude + (Math.random() * 0.001 - 0.0005)
    };
    updateRoute(new google.maps.LatLng(newLatLng.lat, newLatLng.lng));
  }, 3000); // Updates every 3 seconds

      */
      // end
      
      }


    </script>

    
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=XXXXXXXX&callback=initMap">
// put your API
      </script>
  </body>

  </html>