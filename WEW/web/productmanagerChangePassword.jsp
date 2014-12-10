<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeproduct = (AccountBean) session.getAttribute("homeproduct");
    if (homeproduct == null) {
        response.sendRedirect("login.jsp");
    } else {
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
        <script src="js/customercheck.js" type="text/javascript"></script>
        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <link href="dist/css/morris.css" rel="stylesheet">
        <link href="dist/css/font-awesome.min.css" rel="stylesheet">
        <title>Change Password</title>
    </head>
    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
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
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="customerHOME.jsp"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + homeproduct.getUsername());%> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="productmanagerAccount.jsp"><span class="glyphicon glyphicon-edit"></span>Account</a></li>
                                <li><a href="productmanagerChangePassword.jsp"><span class="glyphicon glyphicon-pencil"></span>Change Password</a></li>
                            </ul>
                        </li>
                        <li><form action="LogoutServlet"><span class="glyphicon glyphicon-log-out"></span><input type="submit" value="Log out" style=' border:none'/></form></li>
                    </ul>
                    <form class="navbar-form navbar-right" action='SearchProductServlet' method="post">
                        <div class="input-group input-group-sm" style="max-width:360px;">
                            <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
                            <div class="input-group-btn">
                                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </nav>

        <div class="container"  style="padding-top: 100px;">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Account Information</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" id="changepassword" name="changepassword" action="ProductManagerChangePasswordServlet" method="post">
                            <div>
                                <div class="form-group" style="font-size: 20px;">
                                    <label class="control-label col-lg-4">Change Password</label>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Current Password:</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" id="currpass" name="currpass" placeholder="Enter Password" onblur="currPassCheck();"  onfocus="backWhite(this);" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="mname">New Password:</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" id="pass1" name="pass1" placeholder="Enter Password"  onblur="passCheck();" onfocus="backWhite(this);" required>
                                    </div>
                                </div> 
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="mname">Confirm Password:</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" id="pass2" name="pass2" placeholder="Enter Password"  onblur="passCheck();" onfocus="backWhite(this);" required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <button class="btn btn-primary btn-lg center-block">Edit Account</button>
                                </div>
                            </div>
                        </form>
                        <div class="form-group">
                            <a href='productmanagerHOME.jsp'><button class="btn btn-primary btn-lg center-block">Cancel</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="dist/js/jquery-2.1.0.min.js"></script>
        <script src="dist/js/query.js"></script>
        <script src="dist/js/bootstrap.min.js"></script>
        <script>

                                            function currPassCheck() {
                                                var currPass = document.forms["changepassword"]["currentpassword"].value;
                                                var password1 = document.forms["changepassword"]["password1"].value;
                                                if ((currPass != password1) || password1 == "") {
                                                    document.forms["changepassword"]["password1"].style.backgroundColor = "pink";
                                                    return false;
                                                } else {
                                                    document.forms["changepassword"]["password1"].style.backgroundColor = "white";
                                                    return true;
                                                }

                                            }

                                            function passCheck() {
                                                var pass1 = document.forms["changepassword"]["password2"].value;
                                                var pass2 = document.forms["changepassword"]["password3"].value;
                                                if (!(/^[A-Za-z0-9!@#$%^&*()_]{8,20}$/.test(pass1))//!pass1.match(/(.[!,@,#,$,%,\^,&,*,?,_,~])/) 
                                                        || pass1 == "" || pass1 == null || pass2 == "" || pass2 == null || pass1 != pass2) {
                                                    document.forms["changepassword"]["password2"].style.backgroundColor = "pink";
                                                    document.forms["changepassword"]["password3"].style.backgroundColor = "pink";
                                                    return false;
                                                }
                                                else {
                                                    document.forms["changepassword"]["password2"].style.backgroundColor = "white";
                                                    document.forms["changepassword"]["password3"].style.backgroundColor = "white";
                                                    return true;
                                                }
                                            }
        </script>
    </body>
</html>
<%}%>