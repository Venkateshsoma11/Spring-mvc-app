<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Success</title>
</head>
<body>
    <h1>Logged in successfully ! ${username}</h1>
    <form action="/listAll" method="get">
    <a >list</a>
	</form>

</body>
</html>