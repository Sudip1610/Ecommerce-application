

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <link href="css/shop-homepage.css" rel="stylesheet">

    <!-- Page Content -->
    <div class="container">

      <header>
            <h1 class="text-center">Login</h1>
        <div class="col-sm-4 col-sm-offset-5">         
            <form action="ControllerServlet" method="post" >
                <div class="form-group"><label for="username">
                    username<input type="text" name="name" class="form-control"></label>
                </div>
                 <div class="form-group"><label for="password">
                    Password<input type="text" name="pass" class="form-control"></label>
                </div>

                <div class="form-group">
                  <input type="submit" name="login" class="btn btn-primary" >
                </div>
            </form>
        </div>  


    </header>


        </div>

    </div>
    <!-- /.container -->


