<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

    <meta http-equiv="Cache-Control" content="no-store"/>
    <style>
        /* Set the size of the div element that contains the map */
        #map {
            height: 500px; /* The height is 500 pixels */
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
    <title>Errorzy presents</title>
</head>

<body background="https://wallpapers-house.com/data/out/6/wallpaper2you_109365.jpg">
<header>

    <!--NAVIGATION BAR-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top mb-4 shadow-lg">
        <div class="container">

            <a class="navbar-brand" href="hello.ftlh"><strong class="googlefont"><img class="zoom" src="https://imgur.com/VYijABi.png" height="70" width="70"></strong></a>


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
                                Show list of cities
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
</header>

<!-- Page Content -->

<main>

    <div class="container">
        <div class="card border-0 shadow my-5 bg-dark ">
            <div class="card-body p-5">
                <div class="text-center">
                    <h2 class="text-light">Find your bike</h2>
                    <p class="text-light">Click the links below to find available bicycle</p>
                </div>

            <div class="row">
                <div class="col-md-4">
<!-- tu tabele -->
<#if countryRoot??>
                        <table class="table table-striped text-light">
                            <br>
                            <tbody>
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Country</th>
                            </tr>
                            </thead>

                            <#list countryRoot?keys as key>
                                <tr>
                                    <td scope="row">${key?index+1}</td>
                                    <td><a href="/bike-servlet?country=${key}" style="color:white">${key}</a></td>
                                </tr>
                            </#list>

                            </tbody>
                        </table>
                    </#if>

                    <#if cityRoot??>
                        <table class="table table-striped text-light">
                            <br>
                            <tbody>
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">City</th>
                            </tr>
                            </thead>

                            <#list cityRoot?keys as key>
                                <tr>
                                    <td scope="row">${key?index+1}</td>
                                    <td><a href="/bike-servlet?city=${key}" style="color:white">${key}</a></td>
                                </tr>
                            </#list>

                            </tbody>
                        </table>
                    </#if>

                    <#if placeRoot??>
                        <table class="table table-striped text-light">
                            <br>
                            <tbody>
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">City</th>
                            </tr>
                            </thead>

                            <#list placeRoot?keys as key>
                                <tr>
                                    <td scope="row">${key?index+1}</td>
                                    <td><a href="/bike-servlet?place=${key}" style="color:white">${key}</a></td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </#if>

                    <#if bikeRoot??>
                        <table class="table table-striped text-light>
                            <br>
                            <tbody>
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Bike</th>
                            </tr>
                            </thead>

                            <#list bikeRoot?keys as key>
                                <tr>
                                    <td scope="row">${key?index+1}</td>
                                    <td>${key}</td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </#if>
                </div>
                <div class="col-md-8">
<!-- tu google map -->
            <#if places??>
                   
                        <div id="map">
                            <script type="text/javascript">
                                function initMap() {
                                    var locations = [];

                                    <#list places as place>
                                    locations.push(['${place.name}', ${place.lat}, ${place.lng}])
                                    </#list>

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

                                    map.setMap(map);
                                    


                                    var infowindow = new google.maps.InfoWindow();

                                    var marker, i;

                                    var bounds = new google.maps.LatLngBounds();

                                    for (i = 0; i < locations.length; i++) {

                                        marker = new google.maps.Marker({
                                            position: new google.maps.LatLng(locations[i][1], locations[i][2]),
                                            map: map
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
<!--Footer-->
<footer>
    
        <h5 style="text-align: center; font-size: 12pt; font-weight: 200; font-family:Segoe UI; color:white">made in 2019 by</h5>
    <img src="https://imgur.com/EhqOLb3.png" style="display: block; margin-bottom: 30px; ; margin-left: auto; margin-right: auto;">

    </footer>
</body>
</html>
