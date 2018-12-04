

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



    <link href="css/shop-homepage.css" rel="stylesheet">

<div class="container">

       <!-- Side Navigation -->

       <jsp:include page="templates/front/side_nav.jsp" /> 

<div class="col-md-9">

<!--Row For Image and Short Description-->
 <%
try{ 
con=obj.dbConnection();
st=con.createStatement();
String sql ="SELECT *FROM products WHERE product_id='"+s+"'";

rs = st.executeQuery(sql);
while(rs.next()){
%>
<div class="row">
   

    <div class="col-md-7">
        <img class="img-responsive" src="<%=rs.getString("long_image") %>" alt="" style="width: 100%">

    </div>

    <div class="col-md-5">

        <div class="thumbnail">
         

    <div class="caption-full">
        <h4><a href="#"><%=rs.getString("product_title") %></a> </h4>
        <hr>
        <h4 class=""><%=rs.getString("product_price") %></h4>

    <!--<div class="ratings">
     
        <p>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star"></span>
            <span class="glyphicon glyphicon-star-empty"></span>
            4.0 stars
        </p>
    </div>-->
          
        <p><%=rs.getString("product_description") %></p>
        <a href="CartController?id=<%=rs.getString("product_id") %>&quantity=1/" class="btn btn-default">Add to Cart</a>  

    </div>
 
</div>

</div>


</div><!--Row For Image and Short Description-->


        <hr>


<!--Row for Tab Panel-->

<div class="row">

<div role="tabpanel">

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Description</a></li>
    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Reviews</a></li>

  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="home">

<p></p>
           
    <p><%=rs.getString("long_description") %></p>


    </div>
    <div role="tabpanel" class="tab-pane" id="profile">

  <div class="col-md-6">

       <h3>2 Reviews From </h3>

        <hr>

        <div class="row">
            <div class="col-md-12">
                <span class="glyphicon glyphicon-star"></span>
                <span class="glyphicon glyphicon-star"></span>
                <span class="glyphicon glyphicon-star"></span>
                <span class="glyphicon glyphicon-star"></span>
                <span class="glyphicon glyphicon-star-empty"></span>
                Anonymous
                <span class="pull-right">10 days ago</span>
                <p>This product was great in terms of quality. I would definitely buy another!</p>
            </div>
        </div>
        <hr>   
    </div>


    <div class="col-md-6">
        <h3>Add A review</h3>

     <form action="" class="form-inline">
        <div class="form-group">
            <label for="">Name</label>
                <input type="text" class="form-control" >
            </div>
             <div class="form-group">
            <label for="">Email</label>
                <input type="test" class="form-control">
            </div>

        <div>
            <h3>Your Rating</h3>
            
        </div>

            <br>
            
             <div class="form-group">
             <textarea name="" id="" cols="60" rows="10" class="form-control"></textarea>
            </div>

             <br>
              <br>
            <div class="form-group">
                <input type="submit" class="btn btn-primary" value="SUBMIT">
            </div>
        </form>

    </div>

 </div>

 </div>

</div>


</div><!--Row for Tab Panel-->

<% 
    }
} catch (Exception e) {
e.printStackTrace();
}
%>


</div>

</div>
    <!-- /.container -->

