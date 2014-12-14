<%@page import="Beans.AccountBean"%>
<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeadmin");
    if (homeuser == null) {
        response.sendRedirect("login.jsp");
    } else {

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%                    response.addHeader("X-FRAME-OPTIONS", "DENY");
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
        <script src="js/editadmincheck.js" type="text/javascript"></script>

        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <link href="dist/css/morris.css" rel="stylesheet">
        <link href="dist/css/font-awesome.min.css" rel="stylesheet">
        <title>Admin Account</title>
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
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + homeuser.getUsername());%> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#"><span class="glyphicon glyphicon-edit"></span> Account</a></li>
                                <li><a href="adminChangePassword.jsp"><span class="glyphicon glyphicon-edit"></span> Change Password</a></li>
                            </ul>
                        </li>
                        <li><a><span class="glyphicon glyphicon-log-out"></span><form action="LogoutServlet"><input type="submit" value="Logout" style='background-color: transparent; border: none'/></form></a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container-fluid" style="padding-top: 100px;">
            <div class="row row-offcanvas row-offcanvas-left">

                <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
                    <div class="list-group">
                        <a href="signup_productmanager.jsp" class="list-group-item"><span class="glyphicon glyphicon-edit"></span> Add Product Manager</a>
                        <a href="signup_accountingmanager.jsp" class="list-group-item"><span class="glyphicon glyphicon-edit"></span> Add Accounting Manager</a>
                        <a href="viewlogs.jsp" class="list-group-item"><span class="glyphicon glyphicon-edit"></span> View Activity Log</a>
                        <a href="unlock_account.jsp" class="list-group-item"><span class="glyphicon glyphicon-edit"></span> Unlock Account</a>
                    </div>
                </div><!--/span-->
                <div class="col-xs-12 col-sm-9 content">

                    <div class="text-center">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Account Information</h3>
                            </div>
                            <div class="panel-body">
                                <form class="form-horizontal" role="form" id="editadmin" name="editadmin" action="EditAdminAccountServlet" onsubmit="return editadmincheck(this)" method="post">
                                    <div>
                                        <div class="form-group" style="font-size: 20px;">
                                            <label class="control-label col-lg-4">Basic Info</label>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-4" for="fname">First Name</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" placeholder="Enter First Name" type='text' id='editfirst' name='editfirst' value='<% out.println(homeuser.getFirstName()); %>' onblur='fnameAdminCheck();' onfocus='backWhite(this);' required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-4" for="mname">Middle Initial</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" placeholder="Enter Middle Initial"  id='editmiddle' name='editmiddle' value='<% out.println(homeuser.getMiddleInitial()); %>' onblur='mnameAdminCheck();' onfocus='backWhite(this)' required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-4" for="lname">Last Name</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" id="editlast" name="editlast" placeholder="Enter Last Name" id='editlast' name='editlast' value='<% out.println(homeuser.getLastName()); %>' onblur='lnameAdminCheck();' onfocus='backWhite(this);' required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-4" for="uname">Username</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" id="edituser" name="edituser" placeholder="Enter Username" id='edituser' name="edituser" value='<% out.println(homeuser.getUsername()); %>' onblur='unameAdminCheck();' onfocus='backWhite(this);' required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-4" for="email">Email</label>
                                            <div class="col-sm-3">
                                                <input type="email" class="form-control" id='editemail' name="editemail" value="<% out.println(homeuser.getEmailAdd());%>" onblur='emailAdminCheck();' onfocus='backWhite(this);' required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <button class="btn btn-primary btn-lg center-block">Edit Account</button>
                                        </div>
                                    </div>
                                </form>
                                <div class="form-group">
                                    <a href='adminHOME.jsp'><button class="btn btn-primary btn-lg center-block">Cancel</button></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!--/span-->

            </div><!--/row-->

        </div><!-- /.container -->



        <script src="dist/js/jquery-2.1.0.min.js"></script>
        <script src="dist/js/query.js"></script>
        <script src="dist/js/bootstrap.min.js"></script>

    </body>
</html>
<%}%>
