<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <style>
        /* Set the size of the div element that contains the map */
        #map {
            height: 500px; /* The height is 400 pixels */
            width: 100%; /* The width is the width of the web page */
        }

        .zoom {
            transition: transform .2s; /* Animation */
        }

        .zoom:hover {
            transform: scale(1.2); /* (150% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
        }
    </style>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Playfair+Display|Roboto:500');
    </style>
    <title>Errorzy presents:</title>
    <link rel="shortcut icon" type="image/png" href="https://i.imgur.com/A9yFQNe.png"/>
</head>
<body background="https://wallpapers-house.com/data/out/6/wallpaper2you_109365.jpg">

<div id="nav-placeholder">

</div>


<!--NAVIGATION BAR-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top mb-4 shadow-lg">
    <div class="container">

        <a class="navbar-brand" href="/portal/home"><strong class="googlefont"><img class="zoom"
                                                                                    src="https://imgur.com/VYijABi.png"
                                                                                    height="70" width="70"></strong></a>


        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">


                <li class="nav-item">
                    <a class="nav-link" href="/bike-servlet">
                        <button type="button" class="btn btn-outline-light">
                            Find free bike
                        </button>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/closestPlace-servlet">
                        <button type="button" class="btn btn-outline-light">
                            Find the nearest station
                        </button>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/country-servlet">
                        <button type="button" class="btn btn-outline-light">
                            Show all countries
                        </button>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/show-city-list">
                        <button type="button" class="btn btn-outline-light">
                            Show all cities
                        </button>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin">
                        <button type="button" class="btn btn-outline-light">
                            Admin
                        </button>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">
                        <button type="button" class="btn btn-outline-light">
                            Logout
                        </button>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div id="intro" class="view">

    <div class="mask">

    </div>

</div>
<!-- Page Content -->

<main>

    <div class="container">
        <div class="card border-0 shadow my-5 bg-dark">
            <div class="card-body p-5">
                <div>

                    <h1 class="text-light text-center">
                        ЯvR application
                    </h1>
                    <p class="text-light text-center">ЯvR is meant to help city-bike users to find the nearest
                        bicycle.</p>
                </div>
                <div class="col">
                    <#if countries??>
                        <div>
                            <div id="map"></div>
                            <script type="text/javascript">
                                function initMap() {
                                    var locations = [];

                                    <#list countries as country>
                                    locations.push(['${country.countryName}', ${country.lat}, ${country.lng}])
                                    </#list>

                                    var image = 'https://imgur.com/KoD1BLN.png';
                                    var map = new google.maps.Map(document.getElementById('map'), {
                                        mapTypeId: 'roadmap',
                                        styles: [
                                            {
                                                "elementType": "geometry",
                                                "stylers": [
                                                    {
                                                        "color": "#f5f5f5"
                                                    }
                                                ]
                                            },
                                            {
                                                "elementType": "labels.icon",
                                                "stylers": [
                                                    {
                                                        "visibility": "off"
                                                    }
                                                ]
                                            },
                                            {
                                                "elementType": "labels.text.fill",
                                                "stylers": [
                                                    {
                                                        "color": "#616161"
                                                    }
                                                ]
                                            },
                                            {
                                                "elementType": "labels.text.stroke",
                                                "stylers": [
                                                    {
                                                        "color": "#f5f5f5"
                                                    }
                                                ]
                                            },
                                            {
                                                "featureType": "administrative.land_parcel",
                                                "elementType": "labels.text.fill",
                                                "stylers": [
                                                    {
                                                        "color": "#bdbdbd"
                                                    }
                                                ]
                                            },
                                            {
                                                "featureType": "poi",
                                                "elementType": "geometry",
                                                "stylers": [
                                                    {
                                                        "color": "#eeeeee"
                                                    }
                                                ]
                                            },
                                            {
                                                "featureType": "poi",
                                                "elementType": "labels.text.fill",
                                                "stylers": [
                                                    {
                                                        "color": "#757575"
                                                    }
                                                ]
                                            },
                                            {
                                                "featureType": "poi.park",
                                                "elementType": "geometry",
                                                "stylers": [
                                                    {
                                                        "color": "#e5e5e5"
                                                    }
                                                ]
                                            },
                                            {
                                                "featureType": "poi.park",
                                                "elementType": "labels.text.fill",
                                                "stylers": [
                                                    {
                                                        "color": "#9e9e9e"
                                                    }
                                                ]
                                            },
                                            {
                                                "featureType": "road",
                                                "elementType": "geometry",
                                                "stylers": [
                                                    {
                                                        "color": "#ffffff"
                                                    }
                                                ]
                                            },
                                            {
                                                "featureType": "road.arterial",
                                                "elementType": "labels.text.fill",
                                                "stylers": [
                                                    {
                                                        "color": "#757575"
                                                    }
                                                ]
                                            },
                                            {
                                                "featureType": "road.highway",
                                                "elementType": "geometry",
                                                "stylers": [
                                                    {
                                                        "color": "#dadada"
                                                    }
                                                ]
                                            },
                                            {
                                                "featureType": "road.highway",
                                                "elementType": "labels.text.fill",
                                                "stylers": [
                                                    {
                                                        "color": "#616161"
                                                    }
                                                ]
                                            },
                                            {
                                                "featureType": "road.local",
                                                "elementType": "labels.text.fill",
                                                "stylers": [
                                                    {
                                                        "color": "#9e9e9e"
                                                    }
                                                ]
                                            },
                                            {
                                                "featureType": "transit.line",
                                                "elementType": "geometry",
                                                "stylers": [
                                                    {
                                                        "color": "#e5e5e5"
                                                    }
                                                ]
                                            },
                                            {
                                                "featureType": "transit.station",
                                                "elementType": "geometry",
                                                "stylers": [
                                                    {
                                                        "color": "#eeeeee"
                                                    }
                                                ]
                                            },
                                            {
                                                "featureType": "water",
                                                "elementType": "geometry",
                                                "stylers": [
                                                    {
                                                        "color": "#c9c9c9"
                                                    }
                                                ]
                                            },
                                            {
                                                "featureType": "water",
                                                "elementType": "labels.text.fill",
                                                "stylers": [
                                                    {
                                                        "color": "#9e9e9e"
                                                    }
                                                ]
                                            }
                                        ]
                                    });


                                    var infowindow = new google.maps.InfoWindow();

                                    var marker, i;

                                    var bounds = new google.maps.LatLngBounds();

                                    for (i = 0; i < locations.length; i++) {

                                        marker = new google.maps.Marker({
                                            position: new google.maps.LatLng(locations[i][1], locations[i][2]),
                                            map: map,
                                            icon: 'http://cdn.com/my-custom-icon.png'
                                        });

                                        google.maps.event.addListener(marker, 'click', (function (marker, i) {
                                            return function () {
                                                infowindow.setContent(locations[i][0]);
                                                infowindow.open(map, marker);
                                            }
                                        })(marker, i));

                                        loc = new google.maps.LatLng(marker.position.lat(), marker.position.lng());
                                        bounds.extend(loc);
                                    }

                                    map.fitBounds(bounds);
                                    map.panToBounds(bounds);
                                }
                            </script>
                            <script async defer
                                    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBmgne83Z8Yl58mQT7AQnU_vS5MZViZznU&callback=initMap">
                            </script>
                        </div>
                    </#if>
                </div>
            </div>

        </div>
    </div>
    </div>

</main>
<footer>
    <h5 style="text-align: center; font-size: 12pt; font-weight: 200; color:white">2019</h5>
    <img class="zoom" src="https://imgur.com/EhqOLb3.png"
         style="display: block; margin-bottom: 30px; ; margin-left: auto; margin-right: auto;">
</footer>
</body>

</html>
