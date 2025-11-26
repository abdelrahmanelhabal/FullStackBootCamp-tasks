<html>
<head>
    <title>Product Details</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">

            <div class="card product-details-card shadow-sm p-4">
                <h2 class="text-center text-primary mb-4 fw-semibold">Product Details</h2>

                <div class="product-info">
                    <p><strong>Name:</strong> <span>${product.name}</span></p>
                    <p><strong>Expiration Date:</strong> <span>${product.expirationDate}</span></p>
                    <p><strong>Manufacturer:</strong> <span>${product.manufacturer}</span></p>
                    <p><strong>Price:</strong> <span>$${product.price}</span></p>
                    <p>
                        <strong>Availability:</strong>
                        <span class="${product.available ? 'text-success' : 'text-danger'}">
                            ${product.available ? 'Available' : 'Not Available'}
                        </span>
                    </p>
                </div>

                <div class="text-center mt-4">
                    <a href="${pageContext.request.contextPath}/" class="btn btn-outline-primary px-4">
                        ← Back to Product List
                    </a>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
