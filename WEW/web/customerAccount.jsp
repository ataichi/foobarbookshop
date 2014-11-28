<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");

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
        <script src="js/customercheck.js" type="text/javascript"></script>

        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <link href="dist/css/morris.css" rel="stylesheet">
        <link href="dist/css/font-awesome.min.css" rel="stylesheet">

        <title>Edit Account</title>
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
                        <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + homeuser.getUsername());%> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#"><span class="glyphicon glyphicon-edit"></span>Account</a></li>
                                <li><a href="customerBilling.jsp"><span class="glyphicon glyphicon-edit"></span>Address</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-edit"></span>Credit Card</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-pencil"></span>Change Password</a></li>
                                <li><a href="#"><span class="glyphicon glyphicon-usd"></span> View Transactions</a></li>
                            </ul>
                        </li>
                        <li><a href="homepage.jsp"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                    </ul>
                    <form class="navbar-form navbar-right" action='CustomerSearchProductServlet' method="post">
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
                <form class="form-horizontal" role="form" id="customercheck" name="editaccount" onsubmit="return editCustomerCheck();" action="EditCustomerAccountServlet" method="post">
                    <div>
                        <div class="form-group">
                            <label class="control-label col-lg-4">Basic Info</label>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="fname">First Name</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="fname" name="fname" placeholder="Enter First Name" onblur="fnameCheck();" onfocus="backWhite(this);" value="<% out.println(homeuser.getFirstName()); %>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="mname">Middle Initial</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="mname" name="mname" placeholder="Enter Middle Initial" onblur="mnameCheck();" onfocus="backWhite(this);" value="<% out.println(homeuser.getMiddleInitial()); %>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="lname">Last Name</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="lname" name="lname" placeholder="Enter Last Name" onblur="lnameCheck();" onfocus="backWhite(this);" value="<% out.println(homeuser.getLastName()); %>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="uname">Username</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="uname" name="uname" placeholder="Enter Username" onblur="unameCheck();" onfocus="backWhite(this);" value="<% out.println(homeuser.getUsername()); %>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-4" for="email">Email</label>
                            <div class="col-sm-3">
                                <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email" onblur="emailCheck();" onfocus="backWhite(this);" value="<% out.println(homeuser.getEmailAdd()); %>">
                            </div>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary btn-lg center-block">Edit Account</button>
                        </div>
                    </div>
                </form>
                <a href='customerHOME.jsp'><button class="btn btn-primary btn-lg center-block">Cancel</button></a>
            </div>
        </div>
        <script src="dist/js/jquery-2.1.0.min.js"></script>
        <script src="dist/js/query.js"></script>
        <script src="dist/js/bootstrap.min.js"></script>

    </body>
</html>
