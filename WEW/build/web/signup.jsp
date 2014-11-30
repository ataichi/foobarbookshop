<%-- 
    Document   : login
    Created on : Nov 27, 2014, 1:05:07 AM
    Author     : Danica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script src="js/customercheck.js" type="text/javascript"></script>
        <title>Log In</title>

        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <style>
            body  {
                background-color: gray;
            }
        </style>
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
                    <a class="navbar-brand" href="homepage.jsp">Foobar</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="homepage.jsp">Home</a></li>
                        <li><a href="login.jsp">Log In</a></li>
                        <li class="active"><a href="#">Sign Up</a></li>
                        <li><a href="#about">About</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class="container"  style="padding-top: 100px;">
            <div class="row">
                <form class="form-horizontal" role="form" id="customercheck" name="signin" onsubmit="return customerCheck();" method="post" action="SignupServlet">
                    <div>
                        <div class="form-group">
                            <label class="control-label col-lg-4">Basic Info</label>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="fname">First Name</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="fname" name="fname" placeholder="Enter First Name" onblur="fnameCheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="mname">Middle Initial</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="mname" name="mname" placeholder="Enter Middle Initial (Use 1 letter only)" onblur="mnameCheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="lname">Last Name</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="lname" name="lname" placeholder="Enter Last Name" onblur="lnameCheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="uname">Username</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="uname" name="uname" placeholder="Enter Username" onblur="unameCheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="email">Email</label>
                            <div class="col-sm-3">
                                <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email" onblur="emailCheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="pass1">Password</label>
                            <div class="col-sm-3">
                                <input type="password" class="form-control" id="pass1" name="pass1" placeholder="Enter Password" onblur="passCheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="pass2">Verify Password</label>
                            <div class="col-sm-3">
                                <input type="password" class="form-control" id="pass2" name="pass2" placeholder="Verify Password" onblur="passCheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="form-group">
                            <label class="control-label col-lg-4">Billing Address</label>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="apartmentnoBA">Apartment No</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="apartmentnoBA" name="apartmentnoBA" placeholder="Apartment No" onblur="apartmentnoBACheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="streetBA">Street</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="streetBA" name="streetBA" placeholder="Street" onblur="streetBACheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="subdivisionBA">Subdivision</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="subdivisionBA" name="subdivisionBA" placeholder="Subdivision" onblur="subdivisionBACheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="cityBA">City</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="cityBA" name="cityBA" placeholder="City" onblur="cityBACheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="countryBA">Country</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="countryBA" name="countryBA" placeholder="Country" onblur="countryBACheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="postalcodeBA">Postal Code</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="postalcodeBA" name="postalcodeBA" placeholder="Postal Code" onblur="postalcodeBACheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4">Delivery Address</label>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="apartmentnoDA">Apartment No</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="apartmentnoDA" name="apartmentnoDA" placeholder="Apartment No" onblur="apartmentnoDACheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="streetDA">Street</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="streetDA" name="streetDA" placeholder="Street" onblur="streetDACheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="subdivisionDA">Subdivision</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="subdivisionDA" name="subdivisionDA" placeholder="Subdivision" onblur="subdivisionDACheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="cityDA">City</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="cityDA" name="cityDA" placeholder="City" onblur="cityDACheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="countryDA">Country</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="countryDA" name="countryDA" placeholder="Country" onblur="countryDACheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="postalcodeDA">Postal Code</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="postalcodeDA" name="postalcodeDA" placeholder="Postal Code" onblur="postalcodeDACheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary btn-lg center-block">Sign Up</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <script src="dist/js/jquery-2.1.0.min.js"></script>
        <script src="dist/js/query.js"></script>
        <script src="dist/js/bootstrap.min.js"></script>
    </body>
</html>