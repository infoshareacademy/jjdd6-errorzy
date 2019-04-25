<!DOCTYPE html>
<html>
<head>
    <title>City List</title>
    <#--<link type="text/css" rel="stylesheet" href="/css/styles.css"/>-->
    <#--<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>-->
</head>
<body>

<#-- text -->
<#list city>
    <#items as user>
        <div>
            <ul class="${class}">
                <li>City: ${user.id}</li>
            </ul>
            <#sep><br/>=============================<br/></#sep>
        </div>
    </#items>
</#list>
</body>
</html>