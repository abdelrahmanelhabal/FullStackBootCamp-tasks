<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Product List</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-lg-10">

            <div class="d-flex justify-content-between align-items-center mb-4">
                <h2 class="text-primary fw-semibold">Product List</h2>
                <a href="${pageContext.request.contextPath}/add" class="btn btn-success">
                    + Add Product
                </a>
            </div>

            <div class="card shadow-sm">
                <div class="card-body p-0">
                    <table class="table table-striped table-hover mb-0">
                        <thead class="table-primary">
                        <tr>
                            <th style="width: 5%;">#</th>
                            <th style="width: 35%;">Name</th>
                            <th style="width: 30%;">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <jsp:useBean id="products" scope="request" type="java.util.List" />
                        <c:forEach var="product" items="${products}" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${product.name}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/showDetails/${product.id}" class="btn btn-sm btn-outline-info">Details</a>
                                    <a href="${pageContext.request.contextPath}/edit/${product.id}" class="btn btn-sm btn-outline-primary">Edit</a>
                                    <a href="${pageContext.request.contextPath}/delete/${product.id}"
                                       class="btn btn-sm btn-outline-danger"
                                       onclick="return confirm('Are you sure you want to delete this product?');">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="text-center mt-4">
                <p class="text-muted small mb-0">Total products: <strong>${fn:length(products)}</strong></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
