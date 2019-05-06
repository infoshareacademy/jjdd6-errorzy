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

    <script>function bs_input_file() {
            $(".input-file").before(
                function () {
                    if (!$(this).prev().hasClass('input-ghost')) {
                        var element = $("<input type='file' class='input-ghost' style='visibility:hidden; height:0'>");
                        element.attr("name", $(this).attr("name"));
                        element.change(function () {
                            element.next(element).find('input').val((element.val()).split('\\').pop());
                        });
                        $(this).find("button.btn-choose").click(function () {
                            element.click();
                        });
                        $(this).find("button.btn-reset").click(function () {
                            element.val(null);
                            $(this).parents(".input-file").find('input').val('');
                        });
                        $(this).find('input').css("cursor", "pointer");
                        $(this).find('input').mousedown(function () {
                            $(this).parents('.input-file').prev().click();
                            return false;
                        });
                        return element;
                    }
                }
            );
        }

        $(function () {
            bs_input_file();
        });</script>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Playfair+Display|Roboto:500');
    </style>
    <title>Errorzy presents:</title>

</head>
<body background="https://wallpapers-house.com/data/out/6/wallpaper2you_109365.jpg">

<div id="nav-placeholder">

</div>


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
<!-- Page Content -->

<main>

    <div class="container">
        <div class="card border-0 shadow my-5 bg-dark">
            <div class="card-body p-5">
                <div style="height: 500px">
                    <center>
                        <h1 class="text-light">
                            RvЯ application
                        </h1>
                        <br>
                        <br>
                        <form method="post" action="/upload" enctype="multipart/form-data">
                            <!-- COMPONENT START -->
                            <div class="form-group">
                                <div class="input-group input-file" name="file">
                                    <input type="text" class="form-control" placeholder='Choose an xml file...'
                                           name="file"/>
                                    <span class="input-group-btn">
        		                    <button class="btn btn-light btn-choose" type="button">Choose</button>
    		                    </span>
                                </div>
                            </div>
                            <!-- COMPONENT END -->
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary" name="save">Submit</button>
                                <button type="reset" class="btn btn-danger">Reset</button>
                            </div>
                        </form>
                </div>
            </div>
        </div>
    </div>
    </center>
</main>

<!--Footer-->
<footer>
    <center>
        <h5 class="text-black-50">Made by Errorzy©</h5>
    </center>

</footer>

</body>

</html>

