<%-- 
    Document   : home
    Created on : Mar 26, 2018, 5:20:00 PM
    Author     : org.vpllop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            /* Remove the navbar's default rounded borders and increase the bottom margin */ 
            .navbar {
                margin-bottom: 50px;
                border-radius: 0;
            }

            /* Remove the jumbotron's default bottom margin */ 
            .jumbotron {
                margin-bottom: 0;
            }

            /* Add a gray background color and some padding to the footer */
            footer {
                background-color: #f2f2f2;
                padding: 25px;
            }
        </style>
    </head>
    <body>
        <div class="jumbotron">
            <div class="container text-center">
                <h1>Online Store</h1>      
                <p>Mission, Vission & Values</p>
            </div>
        </div>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#">Logo</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">Products</a></li>
                        <li><a href="#">Deals</a></li>
                        <li><a href="#">Stores</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Your Account</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <br>
        <div class="container-fluid">
            <h1>Hello World!</h1>
            <p>Resize the browser window to see the effect.</p>
            <p>The columns will automatically stack on top of each other when the screen is less than 576px wide.</p>
            <div class="row">
                <div class="col-sm-3 col-md-6 col-lg-4 bg-success" style="background-color:lavender;">
                    <table class="table">

                        <tr>
                            <td> <img src="resources/images/bird2.jpg" class="img-circle"  width="100" height="100"  href="showproducts.jsp?categoryName=Birds"> </td>

                        </tr>
                        <tr>
                            <td>Mary</td>

                        </tr>
                        <tr>
                            <td>July</td>

                        </tr>

                    </table>
                    <div class="row vertical-align">
                        <div class="col-sm-4">
                            <a href="#" title=""><img src="../img/my-image-1.png" class="img-responsive"></a>
                        </div>
                        <div class="col-sm-4">
                            <a href="#" title=""><img src="../img/my-image-1.png" class="img-responsive"></a>
                        </div>
                        <div class="col-sm-4">
                            <a href="#" title=""><img src="../img/my-image-1.png" class="img-responsive"></a>
                        </div>    
                    </div>
                </div>
                <div class="col-sm-9 col-md-6 col-lg-8 bg-warning" style="background-color:lavenderblush;">.col-sm-8</div>
            </div>
        </div>
        <footer class="container-fluid text-center">
            <p>Online Store Copyright</p>  
            <form class="form-inline">Get deals:
                <input type="email" class="form-control" size="50" placeholder="Email Address">
                <button type="button" class="btn btn-danger">Sign Up</button>
            </form>
        </footer>
    </body>
</html>

