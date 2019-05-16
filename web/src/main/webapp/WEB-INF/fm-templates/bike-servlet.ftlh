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

    <meta http-equiv="Cache-Control" content="no-store" />
    <style>
        /* Set the size of the div element that contains the map */
        #map {
            height: 400px;  /* The height is 400 pixels */
            width: 100%;  /* The width is the width of the web page */
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

            <a class="navbar-brand" href="hello.ftlh"><strong class="googlefont">RvЯ</strong></a>


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
        <div class="card border-0 shadow my-5 bg-dark">
            <div class="card-body p-5">

                <center>
                    <h2 class="text-light">Find your bike</h2>
                    <#if countryRoot??>

                        <table class="table table-striped text-light col-md-4">
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
                        <table class="table table-striped text-light col-md-4">
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
                        <table class="table table-striped text-light col-md-4">
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
                        <table class="table table-striped text-light col-md-4">
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

                    <#if places??>
                    <div>
                        <div id="map">
                            <script type="text/javascript">
                                function initMap() {
                                    var locations = [];

                                    <#list places as place>
                                        locations.push(['${place.name}', ${place.lat}, ${place.lng}])
                                    </#list>

                                    var map = new google.maps.Map(document.getElementById('map'), {
                                        mapTypeId: google.maps.MapTypeId.ROADMAP
                                    });

                                    var infowindow = new google.maps.InfoWindow();

                                    var marker, i;

                                    var bounds  = new google.maps.LatLngBounds();

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
                </center>
            </div>
        </div>
    </div>
    </div>
</main>
<!--Footer-->
<footer>
    <center>
        <h5 class="text-black-50">Made by Errorzy©</h5>
    </center>


</footer>
</body>
</html>