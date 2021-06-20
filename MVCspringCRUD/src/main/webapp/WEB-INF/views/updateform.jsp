<!doctype html>
<html lang="en">
<head>

<%@include file="./all_js_css.jsp"%>
</head>
<body>

	<div class="container mt-3">
		<div class="row">

			<div class="col-md-6 offset-md-3">

				<h1 class="text-center">Update Product Details</h1>
				<form action="${pageContext.request.contextPath }/handle-product" method="post">
				
				<input type="text" value="${product.id }" name="id">

					<div class="form-group">
						<label for="name">Product Name</label> <input type="text"
							class="form-control" id="exampleInputEmail1"
							placeholder="Enter name" name="name"
							value="${product.name }"
							>
					</div>

					<div class="form-group">

						<label for="name">Product Description</label>
						<textarea class="form-control" rows="5" name="description"
							id="description" placeholder="Enter Description">${product.description }
							</textarea>
					</div>

					<div class="form-group">
						<label for="name">Product Price</label> <input type="text"
							class="form-control" id="exampleInputEmail1"
							placeholder="Enter $$$" name="price" value="${product.price }">
					</div>

					<div class="container text-center">
						<a href="${pageContext.request.contextPath }/"
							class="btn btn-outline-danger">Back</a>

						<button type="submit" class="btn btn-primary">UPDATE</button>
					</div>

				</form>
			</div>
		</div>

	</div>

</body>
</html>