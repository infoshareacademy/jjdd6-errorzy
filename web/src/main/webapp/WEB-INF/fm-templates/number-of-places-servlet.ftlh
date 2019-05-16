<!doctype html>
<html xmlns="http://java.sun.com/jsf/html">
<head>
    <#--    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">-->
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Number of places</title>
    <link rel="shortcut icon" type="image/png" href="https://i.imgur.com/A9yFQNe.png"/>
</head>
<body>

<#if countryRoot??>
    <form action="/number-of-places" method="get" enctype="application/x-www-form-urlencoded" accept-charset="UTF-8">
        <select name="country">
            <#list countryRoot?keys as key>
                <option value"${key}?lower_case">${key}</option>
            </#list>
            <input type="submit" value="Show list of cities">
        </select>
    </form>
</#if>



<#if cityRoot??>
    <p> In this country is ${numberOfCountries!} places. For show number of places for city from this country, choice
        name of city from list.</p>
    <form action="/number-of-places" method="get" enctype="application/x-www-form-urlencoded" accept-charset="UTF-16">
        <select name="city">
            <#list cityRoot?keys as key>
                <option value"${key}?lower_case">${key}</option>
            </#list>
            <input type="submit" value="Show number of places for city.">
        </select>
    </form>
</#if>


<#if numberOfCities??>
    <p> In this city is ${numberOfCities!} places.</p>
</#if>
</body>

</html>