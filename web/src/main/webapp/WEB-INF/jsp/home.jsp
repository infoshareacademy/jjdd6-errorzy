<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>

<body background="https://wallpapers-house.com/data/out/6/wallpaper2you_109365.jpg">
<div id="nav-placeholder">

</div>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top mb-4 shadow-lg">
    <div class="container">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


        <div class="collapse navbar-collapse" id="navbarResponsive">

            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/login">
                        <button type="button" class="btn btn-outline-light">
                            HOME
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


    <div>

        <footer class="jumbotron">
            <center>
                <h1 class="text-white-150"> Welcome in RvR application!!! </h1>
                <h2 class="text-white-100">Thought RvR api you can quickly and 100% reliably find the nearest nextbike
                    station. </h2>
                <h4 class="text-white-100">Login by yours gmail and ENJOY CYCLING !!! </h4>
            </center>
        </footer>
    </div>


    <div>

        <footer class="jumbotron">
            <center>
                <h4 class="text-white-80"> &copy; 2019 Company Inc</h4>
                <h5 class="text-white-80"> &copy; Made by Errorzy </h5>
            </center>
        </footer>

    </div>


    <script type="text/javascript">
        $("#qsLogoutBtn").click(function (e) {
            e.preventDefault();
            $("#home").removeClass("active");
            $("#password-login").removeClass("active");
            $("#qsLogoutBtn").addClass("active");
            // assumes we are not part of SSO so just logout of local session
            window.location = "${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, '')}/logout";
        });
    </script>

</body>
</html>
