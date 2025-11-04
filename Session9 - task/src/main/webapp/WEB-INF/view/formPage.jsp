<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>App</title>

    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

</head>
<body>
<form:form action="processForm" modelAttribute="userModel" class="container mt-4 p-4 border rounded shadow-sm bg-light" style="max-width: 500px;">

    <h3 class="mb-4 text-center">User Registration Form </h3>

    <div class="mb-3">
        <label class="form-label">Username</label>
        <form:input path="username" type="text" class="form-control" placeholder="Enter your username" />
        <form:errors path="username" cssClass="btn-danger"/>
    </div>

    <div class="mb-3">
        <label class="form-label">Email address</label>
        <form:input path="email" type="email" class="form-control" placeholder="Enter your email" />
        <form:errors path="email" cssClass="btn-danger"/>
    </div>


    <div class="mb-3">
        <label class="form-label">Password</label>
        <form:input path="password" type="password" class="form-control" placeholder="Enter your password" />
        <form:errors path="password" cssClass="btn-danger"/>
    </div>

    <div class="mb-3">
        <label class="form-label">confirmPassword</label>
        <form:input path="confirmPassword" type="password" class="form-control" placeholder="Enter your password" />
        <form:errors path="confirmPassword" cssClass="btn-danger"/>
    </div>

    <input type="submit" value="submit" class="btn btn-primary" />
</form:form>

</body>
</html>
