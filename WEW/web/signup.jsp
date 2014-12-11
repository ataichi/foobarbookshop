<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("homeuser") != null) {
        response.sendRedirect("customerHOME.jsp");
    } else if (session.getAttribute("homeadmin") != null) {
        response.sendRedirect("adminHOME.jsp");
    } else if (session.getAttribute("homeproduct") != null) {
        response.sendRedirect("productmanagerHOME.jsp");
    } else if (session.getAttribute("homeaccounting") != null) {
        response.sendRedirect("accountingmanagerHOME.jsp");
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <% response.addHeader("X-FRAME-OPTIONS", "DENY");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
        %>
        <style id="antiClickjack">body{display:none !important;}</style>
        <script type="text/javascript">
            if (self === top) {
                var antiClickjack = document.getElementById("antiClickjack");
                antiClickjack.parentNode.removeChild(antiClickjack);
            } else {
                top.location = self.location;
            }
        </script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <script src="js/customercheck.js" type="text/javascript"></script>
        <title>Sign Up</title>

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
                <form class="form-horizontal" role="form" id="customercheck" name="customercheck" onsubmit="return customerCheck();" method="post" action="SignupServlet">
                    
                        <div class="form-group">
                            <label class="control-label col-lg-4">Basic Info</label>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="fname">First Name</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="fname" name="fname" placeholder="no special characters" onblur="fnameCheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="mname">Middle Initial</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="mname" name="mname" placeholder="up to 2 letters are allowed" onblur="mnameCheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="lname">Last Name</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="lname" name="lname" placeholder="no special characters" onblur="lnameCheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="uname">Username</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="uname" name="uname" placeholder="only letters, numbers, - and _" onblur="unameCheck();" onfocus="backWhite(this);" required>
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
                                <input type="password" class="form-control" id="pass1" name="pass1" placeholder="should be strong Ex: Sakura7!" onblur="passCheck();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="pass2">Verify Password</label>
                            <div class="col-sm-3">
                                <input type="password" class="form-control" id="pass2" name="pass2" placeholder="should be same as above" onblur="passCheck2();" onfocus="backWhite(this);" required>
                            </div>
                        </div>
                    
                    <div class="form-group">
                        <label class="control-label col-lg-4" for="BA">Billing Address</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="BA" name="BA" placeholder="Billing Address" onblur="BACheck();" onfocus="backWhite(this);" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-4" for="DA">Delivery Address</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="DA" name="DA" placeholder="Delivery Address" onblur="DACheck();" onfocus="backWhite(this);" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary btn-lg center-block">Sign Up</button>
                    </div>

                </form>
            </div>
        </div>
        <script src="dist/js/jquery-2.1.0.min.js"></script>
        <script src="dist/js/query.js"></script>
        <script src="dist/js/bootstrap.min.js"></script>
    </body>
</html>