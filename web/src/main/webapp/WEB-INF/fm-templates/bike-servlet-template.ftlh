<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bike finder</title>
</head>
<body>

<#if root??>
    <select>
        <#list root?keys as key>
            <option value"${key}">${key}</option>
        </#list>
    </select>
</#if>



</body>
</html>