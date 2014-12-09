<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% int ctr_try = (Integer) session.getAttribute("ctr_try");

        String username = (String) session.getAttribute("username");
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <script src="js/logincheck.js" type="text/javascript"></script>
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
                        <li class="active"><a href="#">Log In</a></li>
                        <li><a href="signup.jsp">Sign Up</a></li>
                        <li><a href="#about">About</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>




        <div class="panel-body"  style="padding-left: 400px">
            <div class="row" style="padding-top: 200px;">
                <div class="alert alert-danger col-md-8" role="alert">
                    <strong>Try Again!</strong> The username and password you entered did not match our records.
                </div>
            </div>
            <div class="row" style="padding-left: 150px;">

                <%
                    out.println("  <form class='col-md-4' id='logform' name='login' onsubmit='return logcheck();' method='post' action='LoginServlet'>"
                            + "<div class='form-group'>"
                            + "<input id='loguser' name='loguser' onblur='usernameCheck();' onfocus='backWhite(this);' type='text' class='form-control input-lg' placeholder='Username'>"
                            + "<input type='hidden' name='ctr_try' value='" + ctr_try + "'/>"
                            + "</div>"
                            + "<div class='form-group'>"
                            + "<input id='logpass' name='logpass' onblur='passwordCheck();' onfocus='backWhite(this);' type='password' class='form-control input-lg' placeholder='Password'/>"
                            + "</div>"
                            + "<div class='form-group'>"
                            + "<button class='btn btn-primary btn-lg btn-block'> Sign In </button>"
                            + "<span class='pull-right'><a href='signup.jsp'> New Registration</a></span>"
                            + "</div>"
                            + "</form>"
                    );
                %>
            </div>
        </div>
        <script src="dist/js/jquery-2.1.0.min.js"></script>
        <script src="dist/js/query.js"></script>
        <script src="dist/js/bootstrap.min.js"></script>
    </body>
</html>

