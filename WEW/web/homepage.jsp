

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
session.invalidate();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>Home Page</title>

        <link href="dist/css/bootstrap.min.css" rel="stylesheet">

        <link href="dist/css/dashboard.css" rel="stylesheet">

    </head>
    <body>
        <!-- Fixed navbar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Foobar</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="login.jsp">Log In</a></li>
                        <li><a href="signup.jsp">Sign Up</a></li>
                        <li><a href="#about">About</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div id="myCarousel" class="carousel slide">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                <li data-target="#myCarousel" data-slide-to="3"></li>
            </ol>
            <div class="carousel-inner">
                <div class="item active">
                    <img src="./images/book.jpg" style="width:100%" class="img-responsive">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Book</h1>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img src="./images/magazine.jpg" class="img-responsive">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Magazine</h1>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <center>
                        <img src="./images/dvd.jpg" class="img-responsive">
                        <div class="container">
                            <div class="carousel-caption">
                                <h1>DVD</h1>
                            </div>
                        </div>
                    </center>
                </div>
                <div class="item">
                    <center>
                    <img src="./images/audiocd.png" class="img-responsive">
                    <div  class="container">
                        <div class="carousel-captio">
                            <h1>Audio CD</h1>
                        </div>
                    </div>
                    </center>
                </div>
            </div>
            <!-- Controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="icon-prev"></span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="icon-next"></span>
            </a>  
        </div>
        <!-- /.carousel -->

        <script src="dist/js/jquery-2.1.0.min.js"></script>
        <script src="dist/js/query.js"></script>
        <script src="dist/js/bootstrap.min.js"></script>
    </body>
</html>
