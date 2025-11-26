<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add / Edit Product</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>

<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">

            <div class="card product-card shadow-sm">
                <div class="card-body p-4">
                    <h3 class="text-center mb-4 text-primary fw-semibold">Add / Edit Product</h3>

                    <form:form
                            action="${pageContext.request.contextPath}/processForm"
                            modelAttribute="productDetailsModel">

                        <form:hidden path="id"/>

                        <!-- Product Name -->
                        <div class="mb-3">
                            <label class="form-label fw-semibold">Product Name</label>
                            <form:input path="name" type="text" class="form-control" placeholder="Enter product name" />
                            <form:errors path="name" cssClass="error" />
                        </div>

                        <!-- Expiration Date -->
                        <div class="mb-3">
                            <label class="form-label fw-semibold">Expiration Date</label>
                            <form:input path="expirationDate" type="date" class="form-control" />
                            <form:errors path="expirationDate" cssClass="error" />
                        </div>

                        <!-- Manufacturer -->
                        <div class="mb-3">
                            <label class="form-label fw-semibold">Manufacturer</label>
                            <form:input path="manufacturer" type="text" class="form-control" placeholder="Enter manufacturer" />
                            <form:errors path="manufacturer" cssClass="error" />
                        </div>

                        <!-- Price -->
                        <div class="mb-3">
                            <label class="form-label fw-semibold">Price</label>
                            <form:input path="price" type="number" step="0.01" class="form-control" placeholder="Enter price" />
                            <form:errors path="price" cssClass="error" />
                        </div>

                        <!-- Availability -->
                        <div class="form-check mb-4">
                            <form:checkbox path="available" class="form-check-input" id="availableCheck" />
                            <label class="form-check-label" for="availableCheck">Available</label>
                            <form:errors path="available" cssClass="error" />
                        </div>

                        <!-- Submit Button -->
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary btn-lg">Save Product</button>
                        </div>

                    </form:form>
                </div>
            </div>

            <div class="text-center mt-3">
                <a href="${pageContext.request.contextPath}/" class="btn btn-outline-secondary btn-sm">
                    ← Back to Product List
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
