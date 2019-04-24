<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bike finder</title>
</head>
<body>
<#list root?keys as key>
    <ol>
        <li><a href="/url">${key}</a></li>
    </ol>
</#list>
</body>
</html>