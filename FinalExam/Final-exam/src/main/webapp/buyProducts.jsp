<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>

<h2> Products Available : </h2>
	
		<table>
		 <tr>
		    <th>Name</th>
		    <th>Company</th>
		    <th>Categories</th>
		    <th>Price</th>
		    <th>Quantity</th>
		    <th>Stock</th>
       
		</tr>
			<c:forEach items="${products}" var="product">
				
				<tr>
					
					    <td>${product.name}</td>
					    <td>${product.company.name}</td>
					    <td>
						    <c:forEach items="${product.categories}" var="categorie">
						    	${categorie.name}<br>
						    </c:forEach>
					    </td>
					    <td>${product.price}</td>
					    <td>${product.stock}</td>
					    <form:form method="POST" modelAttribute="quantity" action="/buyProducts?id=${product.id}">
					    <td>
							  <form:select path="quantity">
							    <form:option value="1">1</form:option>
   							    <form:option value="2">2</form:option>
   							    <form:option value="3">3 </form:option>
							 
							  </form:select>


						</td>
					    <td>
					     <Input type="submit" name="submit" value="buy">
		        		</td>
					  </form:form>
					
				</tr>
				  
			</c:forEach>	
		</table>

</body>
</html>