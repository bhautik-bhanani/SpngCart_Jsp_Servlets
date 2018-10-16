<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="productBean" type="com.shopping.doe.ProductImpl"
	class="com.shopping.doe.ProductImpl" scope="session"></jsp:useBean>
<jsp:useBean id="userBean" type="com.shopping.doe.UserImpl"
	class="com.shopping.doe.UserImpl" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.username != null}">
			<p>
				Welcom:
				<c:out value="${sessionScope.username}" />
			</p>
			<p>Menu: <a href="cart.jsp">Cart</a> | <a href="wishlist.jsp">Wishlist</a> | <a href="./CartServlet?type=logout">Logout</a></p>
		</c:when>
		<c:otherwise>
			<p>Existing user: <a href="login.jsp">Login</a> here</p>
		</c:otherwise>
	</c:choose>
	<table border="1">
		<tr>
			<th>Product ID</th>
			<th>Product Image</th>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Product Type</th>
			<th>Product Price</th>
			<th>Action</th>
		</tr>
		<c:forEach var="product" items="${productBean.getProducts()}">
			<tr>
				<td>${product.productId}</td>
				<td><img src="${product.productImg}"
					style="max-width: 100px; max-height: 100px;" /></td>
				<td>${product.productName}</td>
				<td>${product.productDesc}</td>
				<td>${product.productType}</td>
				<td>$${product.productPrice}</td>
				<td><a
					href="./CartServlet?type=addtocart&productId=${product.productId}">Add
						to Cart</a> | <a
					href="./CartServlet?type=addtowishlist&productId=${product.productId}">Add
						to Wishlist</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>