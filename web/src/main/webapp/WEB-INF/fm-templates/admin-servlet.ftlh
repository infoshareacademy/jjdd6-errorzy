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

        <a class="navbar-brand" href="portal/home"><strong class="googlefont"><img class="zoom"
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
                            Show list of cities
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
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Statistics of visit
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/country-statistics">Country statistics</a>
                        <a class="dropdown-item" href="/city-statistics">City statistics</a>
                        <a class="dropdown-item" href="/place-statistics">Place statistics</a>
                    </div>
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
        <div class="card border-0 shadow my-5 bg-dark card-body p-5">

            <center>
                <h1 class="text-light">
                    RvЯ application
                </h1>
                <br>
                <br>
            </center>

            <form class="form-horizontal text-light" method="post" action="/db-load">
                <fieldset>

                    <!-- Form Name -->
                    <legend>Database information</legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="textinput">Number of countries</label>
                        <div class="col-md-4">
                            <input id="textinput" name="textinput" type="number" placeholder=${countryNumber!0}
                                   class="form-control input-md" disabled>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="textCities">Number of cities</label>
                        <div class="col-md-4">
                            <input id="textCities" name="textCities" type="number" placeholder=${cityNumber!0}
                                   class="form-control input-md" disabled>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="textPlace">Number of places</label>
                        <div class="col-md-4">
                            <input id="textPlace" name="textPlace" type="number" placeholder=${placeNumber!0}
                                   class="form-control input-md" disabled>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="textBikes">Number of bikes</label>
                        <div class="col-md-4">
                            <input id="textBikes" name="textBikes" type="number" placeholder=${bikeNumber!0}
                                   class="form-control input-md" disabled>
                        </div>
                    </div>
                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="singlebutton">Load to DB</label>
                        <div class="col-md-4">
                            <button id="singlebutton" name="singlebutton" class="btn btn-primary">Load !
                            </button>
                        </div>
                    </div>

                </fieldset>
            </form>

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
