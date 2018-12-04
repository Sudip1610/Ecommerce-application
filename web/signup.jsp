<%-- 
    Document   : signup
    Created on : Nov 27, 2018, 10:33:45 PM
    Author     : hello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <link href="css/shop-homepage.css" rel="stylesheet">

    <!-- Page Content -->
    <div class="container">

      <header>
            <h1 class="text-center">Sign-up</h1>
        <div class="col-sm-4 col-sm-offset-5">         
            <form class="" action="ControllerServlet" method="post" >
                <div class="form-group"><label for="username">
                    username<input type="text" name="name" class="form-control"></label>
                </div>
                 <div class="form-group"><label for="password">
                    Password<input type="text" name="pass" class="form-control"></label>
                </div>
                <div class="form-group"><label for="email">
                    E-mail<input type="email" name="email" class="form-control"></label>
                </div>
                <label class="radio-inline">
                <input type="radio" name="optradio" checked>Male
                 </label>
                 <label class="radio-inline">
                  <input type="radio" name="optradio">Female
                </label>
                <div class="form-group">
                  <input type="submit" name="submit" class="btn btn-primary" >
                </div>
            </form>
        </div>  


    </header>


        </div>
