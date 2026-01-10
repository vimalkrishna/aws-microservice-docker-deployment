<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Vehicle Information -
                    <c:out value="${model.vehicle.name}" escapeXml="true" />
                </title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        margin: 20px;
                    }

                    h1 {
                        color: #333;
                    }

                    .info {
                        margin: 10px 0;
                    }

                    #map {
                        margin: 20px auto;
                        width: 70%;
                        height: 500px;
                        border: 1px solid #ccc;
                        border-radius: 8px;
                    }
                </style>
            </head>

            <body>
                <h1>Vehicle Info for
                    <c:out value="${model.vehicle.name}" escapeXml="true" />
                </h1>

                <div class="info">
                    <p><strong>Last Report:</strong>
                        <c:out value="${model.position.timestamp}" escapeXml="true" />
                    </p>
                    <p><strong>Location:</strong> Lat:
                        <c:out value="${model.position.lat}" />, Lng:
                        <c:out value="${model.position.longitude}" />
                    </p>
                </div>

                <div id="map"></div>
                <script>
                    function initMap() {
                        const lat = parseFloat('<c:out value="${model.position.lat}"/>');
                        const lng = parseFloat('<c:out value="${model.position.longitude}"/>');
                        const timestamp = '<c:out value="${model.position.timestamp}" escapeXml="true"/>';

                        if (isNaN(lat) || isNaN(lng)) {
                            document.getElementById('map').innerHTML = '<p>Invalid coordinates provided</p>';
                            return;
                        }

                        const myLatLng = { lat: lat, lng: lng };
                        const mapDiv = document.getElementById('map');
                        const map = new google.maps.Map(mapDiv, {
                            center: myLatLng,
                            zoom: 16,
                            mapTypeId: google.maps.MapTypeId.ROADMAP
                        });

                        const marker = new google.maps.Marker({
                            position: myLatLng,
                            map: map,
                            title: timestamp,
                            animation: google.maps.Animation.DROP
                        });

                        const infoWindow = new google.maps.InfoWindow({
                            content: '<div><strong>Last Update:</strong><br>' + timestamp + '</div>'
                        });

                        marker.addListener('click', function () {
                            infoWindow.open(map, marker);
                        });
                    }

                    function handleMapError() {
                        document.getElementById('map').innerHTML = '<p>Error loading Google Maps. Please check your internet connection.</p>';
                    }
                </script>
                <script async defer
                    src="https://maps.googleapis.com/maps/api/js?key=${googleMapsApiKey}&callback=initMap&onerror=handleMapError">
                    </script>
            </body>

            </html>