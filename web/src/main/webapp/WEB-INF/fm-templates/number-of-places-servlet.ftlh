<!doctype html>
<html>
<head>
    <#--    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">-->
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Stattistics</title>
</head>
<body>

<#if countryRoot??>
    <form action="/number-of-places" method="get" enctype="application/x-www-form-urlencoded" accept-charset="UTF-8">
        <select name="country">
            <#list countryRoot?keys as key>
                <option value"${key}?lower_case">${key}</option>
            </#list>
            <input type="submit" value="Submit">
        </select>
    </form>
</#if>


<#--<#if countryRoot??>-->
<#--    <form action="/statistics-servlet" method="get" enctype="application/x-www-form-urlencoded" accept-charset="UTF-8">-->
<#--        <select name="country">-->
<#--            <#list countryRoot?keys as key>-->
<#--                <option value"${key}?lower_case">${key}</option>-->
<#--            </#list>-->
<#--            <input type="submit" value="Submit">-->
<#--        </select>-->
<#--    </form>-->
<#--</#if>-->

<#--<#if cityRoot??>-->
<#--    <form action="/statistics-servlet" method="get" enctype="application/x-www-form-urlencoded"-->
<#--          accept-charset="UTF-16">-->
<#--        <select name="city">-->
<#--            <#list cityRoot?keys as key>-->
<#--                <option value"${key}?lower_case">${key}</option>-->
<#--            </#list>-->
<#--            <input type="submit" value="Submit">-->
<#--        </select>-->
<#--    </form>-->
<#--    <#assign city = cityName?values>-->

<#--</#if>-->

<#--<#if placeRoot??>-->
<#--<form action="/bike-servlet" method="get" enctype="application/x-www-form-urlencoded"-->
<#--      accept-charset="UTF-8">-->
<#--    <select name="place">-->
<#--        <#list placeRoot?keys as key>-->
<#--            <option value"${key}?lower_case">${key}</option>-->
<#--        </#list>-->
<#--        <input type="submit" value="Submit">-->
<#--    </select>-->
<#--</form>-->
<#--</#if>-->
<#--<#if bikeRoot??>-->
<#--    <p>There are ${bikeRoot?keys?size} bicycles</p>-->
<#--    <ul>-->
<#--        <#list bikeRoot?keys as key>-->
<#--            <li>${key}</li>-->
<#--        </#list>-->
<#--    </ul>-->
<#--</#if>-->

</body>

</html>