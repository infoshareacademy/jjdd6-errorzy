<!doctype html>
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
    </style>
    <style>
        div.dataTables_info {
            padding-top: 0.85em;
            white-space: nowrap;
            color: white;
        }
    </style>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Playfair+Display|Roboto:500');
    </style>
    <title>Errorzy presents:</title>
    <link rel="shortcut icon" type="image/png" href="https://i.imgur.com/A9yFQNe.png"/>
</head>

<body background="https://wallpapers-house.com/data/out/6/wallpaper2you_109365.jpg">
<header>

    <!--NAVIGATION BAR-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top mb-4 shadow-lg">
        <div class="container">

            <a class="navbar-brand" href="/portal/home">
                <img width="70" height="70" class="ui-widget-shadow" src="https://i.imgur.com/A9yFQNe.png" alt="RvR application logo">
            </a>


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
                <#--                <div style="height: 500px">-->
                <center>
                    <h2 class="text-light">All cities available</h2>
                    <#if rootCity??>
                        <table class="table table-striped text-light mx-auto w-auto">

                            <thead>
                            <tr>
                                <th>City</th>
                                <th>Lateral</th>
                                <th>Longitudinal</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list rootCity as values>
                                <tr>
                                    <td>${values.name}</td>
                                    <td>${values.lat}</td>
                                    <td>${values.lng}</td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </#if>
                </center>
            </div>
            <#--            </div>-->
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