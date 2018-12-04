

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
String s=request.getParameter("id");
%>

    <link href="css/heroic-features.css" rel="stylesheet">

    <!-- Page Content -->
    <div class="container">
        

        <!-- Jumbotron Header -->
        <header class="jumbotron hero-spacer">
            <h1>A Warm Welcome!</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, ipsam, eligendi, in quo sunt possimus non incidunt odit vero aliquid similique quaerat nam nobis illo aspernatur vitae fugiat numquam repellat.</p>
        </header>

        <hr>

        <!-- Title -->
        <div class="row">
            <div class="col-lg-12">
                <h3>Latest Features</h3>
            </div>
        </div>
        <!-- /.row -->

        <!-- Page Features -->

        <div class="row text-center">

<%
try{ 
con=obj.dbConnection();
st=con.createStatement();
String sql ="SELECT *FROM products WHERE product_category_id='"+s+"'";

rs = st.executeQuery(sql);
while(rs.next()){
%>
            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">

                    <img src="<%=rs.getString("product_img") %>" alt="">
                    <div class="caption">
                        <h3><%=rs.getString("product_title") %></h3>
                        <p><%=rs.getString("product_description") %></p>
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
        </div>
        <!-- /.row -->

       
