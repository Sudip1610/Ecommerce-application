<%-- 
    Document   : get_product
    Created on : Sep 20, 2018, 2:34:41 PM
    Author     : hello
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="com.ecom.dbconnection.DbConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
  DbConnection obj = new DbConnection();
Connection con = null;
Statement st = null;
ResultSet rs = null;
%>
  <%
try{ 
con=obj.dbConnection();
st=con.createStatement();
String sql ="SELECT *FROM products";

rs = st.executeQuery(sql);
while(rs.next()){
%>
                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="<%=rs.getString("product_img") %>" alt="" style="width:60%">
                            <div class="caption">
                                <h4 class="pull-right">$<%=rs.getString("product_price") %></h4>
                                <h4><a href="product.html"><%=rs.getString("product_title") %></a>
                                </h4>
                                <p><%=rs.getString("product_description") %></p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">15 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </p>
                                <p>
                              <a href="CartController?id=<%=rs.getString("product_id") %>&quantity=1/" class="btn btn-default">Add to Cart</a>  
                            <a href="item.jsp?id=<%=rs.getString("product_id") %>" class="btn btn-default">More Info</a>
                                </p>
                            </div>
                        </div>
                    </div>
                    <% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
