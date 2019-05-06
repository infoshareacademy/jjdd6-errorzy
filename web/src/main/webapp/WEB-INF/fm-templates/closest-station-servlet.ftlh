<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Closest Bike Station</title>
</head>
<body>
<#if place??>

    <p>The closest bike stand is ${place.name}, it is ${distanceToPlace} ${distanceUnit} from you.</p>

<#else>

    <form action="/closestPlace-servlet" method="get">
        Lateral coordinates: <input type="text" name="lat"><br>
        Longitudinal coordinates: <input type="text" name="lng"><br>

        Distance unit:
        <input class="radioButon" type="radio" name="unit" value="kilometer" checked> Km
        <input class="radioButon" type="radio" name="unit" value="meter"> m<br>
        <input type="submit" value="Submit">
    </form>

</#if>
</body>
</html>