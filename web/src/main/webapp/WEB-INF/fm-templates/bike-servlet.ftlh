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

    <style>
        @import url('https://fonts.googleapis.com/css?family=Playfair+Display|Roboto:500');
    </style>
    <title>Errorzy presents</title>
    <link rel="shortcut icon" type="image/png" href="https://i.imgur.com/A9yFQNe.png"/>
</head>

<body background="https://wallpapers-house.com/data/out/6/wallpaper2you_109365.jpg">
<header>

    <!--NAVIGATION BAR-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top mb-4 shadow-lg">
        <div class="container">

            <a class="navbar-brand" href="/portal/home">
                <img width="70" height="70" class="ui-widget-shadow" src="https://i.imgur.com/A9yFQNe.png" alt="RvR application logo"></a>


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

                            <#list countryRoot as values>
                                <tr>
                                    <td scope="row">${values?index+1}</td>
                                    <td><a href="/bike-servlet?country=${values.countryName}" style="color:white">${values.countryName}</a></td>
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

                            <#list cityRoot as values>
                                <tr>
                                    <td scope="row">${values?index+1}</td>
                                    <td><a href="/bike-servlet?city=${values.name}" style="color:white">${values.name}</a></td>
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
                                <th scope="col">Place</th>
                            </tr>
                            </thead>

                            <#list placeRoot as values>
                                <tr>
                                    <td scope="row">${values?index+1}</td>
                                    <td><a href="/bike-servlet?place=${values.name}" style="color:white">${values.name}</a></td>
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

                            <#list bikeRoot as values>
                                <tr>
                                    <td scope="row">${values?index+1}</td>
                                    <td>${values.number?c}</td>
                                </tr>
                            </#list>
                            </tbody>
                        </table≠>
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
        <h5 class="text-light">Made by Errorzy<br>2019</h5>
    </center>
</footer>
</body>
</html>