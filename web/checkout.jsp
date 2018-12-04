
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.ecom.dbconnection.DbConnection"%>

<%@ page import="com.ecom.daoimpl.Order"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <link href="css/heroic-features.css" rel="stylesheet">
    <!-- Page Content -->
    <div class="container">



<div class="row">

      <h1>Checkout</h1>

    <table class="table table-striped">
        <thead>
          <tr>
           <th>Product</th>
           <th>Price</th>
           <th>Quantity</th>
           <th>Sub-total</th>
     
          </tr>
        </thead>

        <tbody>
            
           <c:forEach items="${order.items}" var="li">
				<tr>
                                    <td>${li.product.description}</td>
                                    <td>${li.product.price}</td>
					<form action="<c:url value="/CartController"/>" method="GET">
						<td><input type="text" name="quantity" value="${li.quantity}" />
							<input type="hidden" name="id" value="${li.product.prodId}" />
							<br> <input type="submit" value="Update"></td>
                                        </form>
					<td>${li.price}</td>
					
					<form action="<c:url value="/CartController"/>" method="GET" >
					<td><input type="submit" value="Remove Item" /> <input
						type="hidden" name="id" value="${li.product.prodId}" /> <input
						type="hidden" name="quantity" value="0" /></td>
					</form>
				</tr>
			</c:forEach>
			<tr>
				
        </tbody>
    </table>




<!--  ***********CART TOTALS*************-->
            
<div class="col-xs-4 pull-right ">
<h2>Cart Totals</h2>

<table class="table table-bordered" cellspacing="0">

<tr class="cart-subtotal">
<th>Items:</th>
<td><span class="amount"> $<c:out value="${order.itemCount}"/>  </span></td>
</tr>
<tr class="shipping">
<th>Shipping and Handling</th>
<td>Free Shipping</td>
</tr>

<tr class="order-total">
<th>Order Total</th>
<td><strong><span class="amount">$<c:out value="${order.totalPrice}"/> </span></strong> </td>
</tr>


</tbody>

</table>

</div><!-- CART TOTALS-->


 </div><!--Main Content-->


