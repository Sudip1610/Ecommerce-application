
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="com.ecom.dbconnection.DbConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

    <!-- Page Content -->
   
    <div class="container">
<link href="css/shop-homepage.css" rel="stylesheet">
        <div class="row">
<%
  DbConnection obj = new DbConnection();
Connection con = null;
Statement st = null;
ResultSet rs = null;
%>

            <div class="col-md-3">
                <p class="lead">Shop Name</p>
                <div class="list-group">
                    <%
try{ 
con=obj.dbConnection();
st=con.createStatement();
String sql ="SELECT *FROM categories";

rs = st.executeQuery(sql);
while(rs.next()){
%>

           <a href="category.jsp?id=<%=rs.getString("cat_id") %>" class="list-group-item"><%=rs.getString("cat_title") %></a>
 
           <% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
                </div>
            </div>