<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <#--    BOOTSTRAP 4-4.1.1 + JQUERY 3.3.1 + DataTable 1.10.18-->
    <link rel="stylesheet" type="text/css"
          href="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.18/datatables.min.css"/>
    <script type="text/javascript"
            src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.18/datatables.min.js"></script>

    <script>
        $(document).ready(function () {
            $('.table').DataTable();
        });
    </script>
    <style>
        label {
            display: inline-block;
            margin-bottom: .5rem;
            color: white;
        }

        div.dataTables_info {
            padding-top: 0.85em;
            white-space: nowrap;
            color: white;
        }
    </style>
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
<body>

</body>
</html>
<body background="https://wallpapers-house.com/data/out/6/wallpaper2you_109365.jpg">
<header>

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
</header>
<!-- Page Content -->

<main>

    <div class="container">
        <div class="card border-0 shadow my-5 bg-dark card-body p-5">
            <div class="text-center">
                <h2 class="text-light">Number of country visits</h2>
            </div>
            <#if countryNumber??>
                <table class="table table-striped text-light mx-auto w-100">

                    <thead>
                    <tr>
                        <th>Country</th>
                        <th>Number of visits</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list countryNumber as values>
                        <tr>
                            <td>${values.country}</td>
                            <td>${values.numberOfVisits}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </#if>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <div class="text-center">
                <h2 class="text-light">Number of city visits</h2>
            </div>
            <#if cityNumber??>
                <table class="table table-striped text-light mx-auto w-100">

                    <thead>
                    <tr>
                        <th>City</th>
                        <th>Number of visits</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list cityNumber as values>
                        <tr>
                            <td>${values.city}</td>
                            <td>${values.numberOfVisits}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </#if>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <div class="text-center">
                <h2 class="text-light">Number of places visits</h2>
            </div>
            <#if placeNumber??>
                <table class="table table-striped text-light mx-auto w-100">

                    <thead>
                    <tr>
                        <th>Place</th>
                        <th>Number of visits</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list placeNumber as values>
                        <tr>
                            <td>${values.place}</td>
                            <td>${values.numberOfVisits}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </#if>
        </div>
    </div>
    </div>
</main>

<!--Footer-->
<footer>
    <h5 style="text-align: center; font-size: 12pt; font-weight: 200; color:white">made in 2019
        by</h5>
    <img class="zoom" src="https://imgur.com/EhqOLb3.png"
         style="display: block; margin-bottom: 30px; ; margin-left: auto; margin-right: auto;">
</footer>
</body>
