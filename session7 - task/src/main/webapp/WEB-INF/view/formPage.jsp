<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
<h1> Enter your birthdate </h1>
<form action="processForm" method="GET" >
    <input type="text" placeholder="year" name="year" class="alert-success">
    <input type="text" placeholder="month" name="month" class="alert-success">
    <input type="text" placeholder="day" name="day" class="alert-success">
    <input type="submit" class="btn btn-primary">
</form>
</body>
</html>
