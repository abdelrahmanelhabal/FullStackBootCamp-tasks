<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
<div class="container mt-5">
    <div class="card shadow-sm p-4">
        <h2 class="text-center mb-4">User Registration</h2>

        <form action="processForm" method="get">
            <div class="form-group">
                <label for="first name">First name</label>
                <input type="text" class="form-control"  name="firstName" placeholder="Enter your first name">
            </div>

            <div class="form-group">
                <label for="last name">Last Name</label>
                <input type="text" class="form-control"  name="lastName" placeholder="Enter your last name">
            </div>

            <div class="form-group">
                <label for="email">Email address</label>
                <input type="email" class="form-control"  name="email" placeholder="Enter your email address">
            </div>

            <div class="form-group">
                <label for="date">Date of birth</label>
                <input type="date" class="form-control"  name="date">
            </div>


            <div class="form-group">
                <label for="city">City</label>
                <textarea class="form-control" name="city" placeholder="Enter City"></textarea>
            </div>

            <button type="submit" class="btn btn-primary btn-block">Submit</button>
        </form>
    </div>
</div>

</body>
</html>
