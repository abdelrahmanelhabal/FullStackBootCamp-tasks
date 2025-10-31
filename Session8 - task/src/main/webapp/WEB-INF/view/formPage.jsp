<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
<form:form action="processForm" modelAttribute="userModel" class="container mt-4 p-4 border rounded shadow-sm bg-light" style="max-width: 500px;">

    <h3 class="mb-4 text-center">User Registration</h3>

    <div class="mb-3">
        <label class="form-label">Username</label>
        <form:input path="username" type="text" class="form-control" placeholder="Enter your username" />
    </div>

    <div class="mb-3">
        <label class="form-label">Password</label>
        <form:input path="password" type="password" class="form-control" placeholder="Enter your password" />
    </div>

    <div class="mb-3">
        <label class="form-label">Country</label>
        <form:select path="country" class="form-select">
            <form:option value="Egypt" label="Egypt" />
            <form:option value="Sudan" label="Sudan" />
            <form:option value="Saudi Arabia" label="KSA" />
        </form:select>
    </div>

    <div class="mb-3">
        <label class="form-label d-block">Programming Language</label>
        <div class="form-check form-check-inline">
            <form:radiobutton path="programmingLanguage" value="C++" class="form-check-input" id="cpp"/>
            <label class="form-check-label" for="cpp">C++</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="programmingLanguage" value="Java" class="form-check-input" id="java"/>
            <label class="form-check-label" for="java">Java</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="programmingLanguage" value="C#" class="form-check-input" id="csharp"/>
            <label class="form-check-label" for="csharp">C#</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="programmingLanguage" value="Python" class="form-check-input" id="python"/>
            <label class="form-check-label" for="python">Python</label>
        </div>
    </div>

    <div class="mb-3">
        <label class="form-label d-block">Operating Systems</label>
        <div class="form-check">
            <form:checkbox path="operatingSystems" value="Windows" class="form-check-input" id="windows"/>
            <label class="form-check-label" for="windows">Windows</label>
        </div>
        <div class="form-check">
            <form:checkbox path="operatingSystems" value="Linux" class="form-check-input" id="linux"/>
            <label class="form-check-label" for="linux">Linux</label>
        </div>
        <div class="form-check">
            <form:checkbox path="operatingSystems" value="Mac" class="form-check-input" id="mac"/>
            <label class="form-check-label" for="mac">Mac</label>
        </div>
    </div>

    <div class="text-center">
        <input type="submit" class="btn btn-primary px-4" value="Submit">
    </div>

</form:form>

</body>
</html>
