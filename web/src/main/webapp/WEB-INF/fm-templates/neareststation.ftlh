<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Playfair+Display|Roboto:500');
    </style>
    <title>Errorzy presents:</title>
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
                        <a class="nav-link" href="#">
                            <button type="button" class="btn btn-outline-light">
                                Show list of cities
                            </button>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <button type="button" class="btn btn-outline-light">
                                Show statistics
                            </button>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <button type="button" class="btn btn-outline-light">
                                Contact us
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
                    <h2 class="text-light">
                        <strong>Find the nearest bike station <br></strong>
                    </h2>
                    <br>
                    <br>

                </center>
                <form class="col-md-12" action="/closestPlace-servlet" method="get">
                    <div class="form-group col-md-6">
                        <label for="latInput"> <font color="white">Lateral coordinates:</font></label>
                        <input type="number" step="any" class="form-control" id="latInput" name="lat">
                        <small id="latHelp" class="form-text text-muted">Insert lateral coordinates (i.e.
                            54.5188900), North with '+', South with'-'
                        </small>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="lngInput"> <font color="white"> Longitudinal coordinates:</font></label>
                        <input type="number" step="any" class="form-control" id="lngInput" name="lng">
                        <small id="lngHelp" class="form-text text-muted">Insert longitudinal coordinates (i.e.
                            18.5318800), East with '+', West with'-'
                        </small>
                    </div>

                    <div class="form-group col-md-6">
                        <p><font color="white"> Distance unit:</font><br></p>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="kilometersUnit" name="unit" class="custom-control-input"
                                   value="kilometer" checked="checked">
                            <label class="custom-control-label" for="kilometersUnit"><font
                                        color="white">km</font></label>
                        </div>

                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="meterUnit" name="unit" class="custom-control-input" value="meter">
                            <label class="custom-control-label" for="meterUnit"><font
                                        color="white">m</font></label>
                        </div>
                        <br>
                    </div>
                    <div class="form-group col">
                        <button type="submit" class="btn btn-primary">Find</button>
                    </div>
                </form>

                <#if place??>
                    <h5 class="text-light">The closest bike stand is ${place.name}, it is ${distanceToPlace} ${distanceUnit} from you.</h5>
                </#if>

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