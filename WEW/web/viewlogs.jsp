<%@page import="Beans.LogBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
    AccountBean homeadmin = (AccountBean) session.getAttribute("homeadmin");
	if(homeadmin==null){
	response.sendRedirect("login.jsp");
	}else{
    ArrayList<LogBean> loglist = (ArrayList<LogBean>) session.getAttribute("loglist");
%>

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

        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <link href="dist/css/morris.css" rel="stylesheet">
        <link href="dist/css/font-awesome.min.css" rel="stylesheet">
        <title>View Logs</title>
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
                                <li><a href="adminAccount.jsp"><span class="glyphicon glyphicon-edit"></span> Edit Account</a></li>
                                <li><a href="adminChangePassword.jsp"><span class="glyphicon glyphicon-edit"></span> Change Password</a></li>
                            </ul>
                        </li>
                        <li><a href="homepage.jsp"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
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
                        <a href="#" class="list-group-item active"><span class="glyphicon glyphicon-edit"></span> View Activity Log</a>
                        <a href="unlock_account.jsp" class="list-group-item"><span class="glyphicon glyphicon-edit"></span> Unlock Account</a>
                    </div>
                </div><!--/span-->
                <div class="col-xs-12 col-sm-9 content">

                    <div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">View Logs</h3>
                            </div>
                            <div class="panel-body">
                                <%
                                   out.println("<div class='table-responsive'>"
                                            + "<table class='table table-striped'>"
                                            + "<thead><tr>"
                                            + "<th>Time</th>"
                                            + "<th>Activity</th>"
                                            + "<th>By</th>"
                                            + "</tr></thead>"
                                            + "<tbody>");
                                    for (int i = 0; i < loglist.size(); i++) {
                                        out.println("<tr>"
                                                + "<td>"
                                                + loglist.get(i).getTime()
                                                + "</td>"
                                                + "<td>"
                                                + loglist.get(i).getActivity()
                                                + "</td>"
                                                + "<td>"
                                                + loglist.get(i).getLog_accountID()
                                                + "</td>"
                                                + "</tr>");
                                    }
                                   out.println(""
                                            + "</tbody></table></div>");
                                %>
                            </div>
                        </div>
                    </div>
                </div><!--/span-->

            </div><!--/row-->

        </div><!-- /.container -->

    </body>
</html>
<%}%>