<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean account = (AccountBean) session.getAttribute("homeadmin");
    if (account == null) {
        response.sendRedirect("login.jsp");
    } else {
%>
<!DOCTYPE html>
<html>
    <head>
        <%
            response.addHeader("X-FRAME-OPTIONS", "DENY");
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
        <script src="js/editadmincheck.js" type="text/javascript"></script>

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
                        <li class="active"><a href="adminHOME.jsp"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + account.getUsername());%> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="adminAccount.jsp"><span class="glyphicon glyphicon-edit"></span> Edit Account</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-edit"></span> Change Password</a></li>
                                <!--
                                <li><a href="signup_productmanager.jsp"><span class="glyphicon glyphicon-edit"></span>Add Product Manager</a></li>
                                <li><a href="signup_accountingmanager.jsp"><span class="glyphicon glyphicon-edit"></span>Add Accounting Manager</a></li>
                                <li><a href="viewlogs.jsp"><span class="glyphicon glyphicon-edit"></span>View Activity Log</a></li>
                                <li><a href="unlock_account.html"><span class="glyphicon glyphicon-edit"></span> Unlock Account</a></li>-->
                            </ul>
                        </li>
                        <li><a href="homepage.jsp"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container"  style="padding-top: 100px;">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Change Password</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" id="admincheck" name="admincheck" onsubmit="return adminEditPassword();" action="ChangePasswordServlet" method="post">
                            <div>
                                <div class="form-group" style="font-size: 20px;">
                                    <label class="control-label col-lg-4">Password</label>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4">Current Password</label>
                                    <div class="col-sm-3">
                                        <input type="password" class="form-control" id="currpass" name="currpass" placeholder="Enter Current Password" onblur="admincheckcurrentpass();" onfocus="backWhite(this);" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" >New Password</label>
                                    <div class="col-sm-3">
                                        <input type="password" class="form-control" id="pass1" name="pass1" placeholder="Enter New Password (strong)" onblur="adminpasscheck();" onfocus="backWhite(this);" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4">Re-Enter New Password</label>
                                    <div class="col-sm-3">
                                        <input type="password" class="form-control" id="pass2" name="pass2" placeholder="Re-Enter New Password" onblur="adminpasscheck();" onfocus="backWhite(this);" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button class="btn btn-primary btn-lg center-block">Save Changes</button>
                                </div>
                            </div>
                        </form>
                        <div class="form-group">
                            <a href='adminHOME.jsp'><button class="btn btn-primary btn-lg center-block">Cancel</button></a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <script src="dist/js/jquery-2.1.0.min.js"></script>
        <script src="dist/js/query.js"></script>
        <script src="dist/js/bootstrap.min.js"></script>
    </body>
</html>
<%}%>