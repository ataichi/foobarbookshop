<%@page import="Beans.LockReportBean"%>
<%@page import="Beans.AccountBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    AccountBean homeadmin = (AccountBean) session.getAttribute("homeadmin");
    if (homeadmin == null) {
        response.sendRedirect("login.jsp");
    } else {
        ArrayList<LockReportBean> lockreportlist = (ArrayList<LockReportBean>) session.getAttribute("lockreportlist");
        ArrayList<AccountBean> lockedAccounts = (ArrayList<AccountBean>) session.getAttribute("lockedAccounts");
%>

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

        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <link href="dist/css/morris.css" rel="stylesheet">
        <link href="dist/css/font-awesome.min.css" rel="stylesheet">

        <title>Unlock Account</title>
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
                        <li><a href="adminHOME.jsp"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + homeadmin.getUsername());%> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="adminAccount.jsp"><span class="glyphicon glyphicon-edit"></span>Edit Account</a></li>
                                <li><a href="adminChangePassword.jsp"><span class="glyphicon glyphicon-edit"></span> Change Password</a></li>
                                <!--
                                <li><a href="signup_productmanager.jsp"><span class="glyphicon glyphicon-edit"></span>Add Product Manager</a></li>
                                <li><a href="signup_accountingmanager.jsp"><span class="glyphicon glyphicon-edit"></span>Add Accounting Manager</a></li>
                                <li><a href="viewlogs.html"><span class="glyphicon glyphicon-edit"></span>View Activity Log</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-edit"></span> Unlock Account</a></li>-->
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
                        <a href="#" class="list-group-item active"><span class="glyphicon glyphicon-edit"></span> Unlock Account</a>
                    </div>
                </div><!--/span-->
                <div class="col-xs-12 col-sm-9 content">

                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                    <th>Email Address</th>
                                    <th>Type</th>
                                    <th>Reason</th>
                                    <th>Unlock Account<th>
                                </tr>
                            </thead>
                            <tbody>
                                <% int i;
                                    for (i = 0; i < lockedAccounts.size(); i++) {
                                        for (int j = 0; j < lockreportlist.size(); j++) {
                                            if (lockreportlist.get(j).getLockreport_accountID() == lockedAccounts.get(i).getAccountID()) {
                                                out.println("<tr><td>" + lockedAccounts.get(i).getFirstName() + "</td>"
                                                        + "<td>" + lockedAccounts.get(i).getLastName() + "</td>"
                                                        + "<td>" + lockedAccounts.get(i).getUsername() + "</td>"
                                                        + "<td>" + lockreportlist.get(j).getEmailaddress() + "</td>"
                                                        + "<td>" + lockedAccounts.get(i).getAccountType() + "</td>"
                                                        + "<td>" + lockreportlist.get(j).getReason() + "</td>"
                                                        + "<td><form action='UnlockAccountServlet'>"
                                                        + "<input type='hidden' name='lockreportid' value='" + lockreportlist.get(j).getLockreportID() + "'/>"
                                                        + "<input type='hidden' name='accountid' value='" + lockedAccounts.get(i).getAccountID() + "'/>"
                                                        + "<input type='submit' value='unlock' style='border-color: transparent; background-color: transparent'/>"
                                                        + "</td></form></tr>");
                                            }
                                        }
                                    }
                                %>

                            </tbody>
                        </table>
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