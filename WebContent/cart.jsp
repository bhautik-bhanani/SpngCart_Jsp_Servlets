<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Cart</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.username != null}">
			<p>
				Welcom:
				<c:out value="${sessionScope.username}" />
			</p>
		</c:when>
		<c:otherwise>
			<c:redirect url="login.jsp" />
		</c:otherwise>
	</c:choose>
	<p>
		Menu: <a href="index.jsp">Home</a> | <a href="wishlist.jsp">Wishlist</a> | <a href="./CartServlet?type=logout">Logout</a>
	</p>
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
		<c:set var="total" value="0" />
		<c:forEach var="product"
			items="${sessionScope.userBean.getCartlist(sessionScope.username)}">
			<tr>
				<td>${product.productId}</td>
				<td><img src="${product.productImg}"
					style="max-width: 100px; max-height: 100px;" /></td>
				<td>${product.productName}</td>
				<td>${product.productDesc}</td>
				<td>${product.productType}</td>
				<td>$${product.productPrice}</td>
				<td><a
					href="./CartServlet?type=movetowishlist&productId=${product.productId}">Move
						to Wishlist</a> | <a
					href="./CartServlet?type=removecart&productId=${product.productId}">Remove</a>
				</td>
			</tr>
			<c:set var="total" value="${total+product.productPrice}" />
		</c:forEach>
		<tfoot>
			<tr>
				<td colspan="6" align="right"><b>Total:</b></td>
				<td>$<c:out value="${total}" /></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>