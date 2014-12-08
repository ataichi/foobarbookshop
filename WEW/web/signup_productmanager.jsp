<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeadmin = (AccountBean) session.getAttribute("homeadmin");
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
        <script src="js/managercheck.js" type="text/javascript"></script>

        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <link href="dist/css/morris.css" rel="stylesheet">
        <link href="dist/css/font-awesome.min.css" rel="stylesheet">
        <title>Sign up Product Manager</title>
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
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + homeadmin.getUsername());%> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="adminAccount.jsp"><span class="glyphicon glyphicon-edit"></span>Edit Account</a></li>
                                <!--
                                <li><a href="#"><span class="glyphicon glyphicon-edit"></span>Add Product Manager</a></li>
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

        <div class="container-fluid" style="padding-top: 100px;">
            <div class="row row-offcanvas row-offcanvas-left">

                <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
                    <div class="list-group">
                        <a href="#" class="list-group-item active"><span class="glyphicon glyphicon-edit"></span> Add Product Manager</a>
                        <a href="signup_accountingmanager.jsp" class="list-group-item"><span class="glyphicon glyphicon-edit"></span> Add Accounting Manager</a>
                        <a href="viewlogs.jsp" class="list-group-item"><span class="glyphicon glyphicon-edit"></span> View Activity Log</a>
                        <a href="unlock_account.jsp" class="list-group-item"><span class="glyphicon glyphicon-edit"></span> Unlock Account</a>
                    </div>
                </div><!--/span-->
                <div class="col-xs-12 col-sm-9 content">

                    <div class="text-center">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Add Product Manager</h3>
                            </div>
                            <div class="panel-body">
                                <form class="form-horizontal" role="form" id="managercheck" name="managercheck" onsubmit="return managerCustomerCheck();" action="ProductManagerSignupServlet" method="post">
                                    <div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-4" for="fname">First Name</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" id="fname" name="fname" placeholder="Enter First Name" onblur="fnameManagerCheck();" onfocus="backWhite(this);" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-4" for="mname">Middle Initial</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" id="mname" name="mname" placeholder="Enter Middle Initial" onblur="mnameManagerCheck();" onfocus="backWhite(this);" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-4" for="lname">Last Name</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" id="lname" name="lname" placeholder="Enter Last Name" onblur="lnameManagerCheck();" onfocus="backWhite(this);" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-4" for="uname">Username</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" id="uname" name="uname" placeholder="Enter Username" onblur="unameManagerCheck();" onfocus="backWhite(this);" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-4" for="email">Email</label>
                                            <div class="col-sm-3">
                                                <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email" onblur="emailManagerCheck();" onfocus="backWhite(this);" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-4" for="pass1">Password</label>
                                            <div class="col-sm-3">
                                                <input type="password" class="form-control" id="pass1" name="pass1" placeholder="Enter Password" onblur="passManagerCheck();" onfocus="backWhite(this);" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-4" for="pass2">Verify Password</label>
                                            <div class="col-sm-3">
                                                <input type="password" class="form-control" id="pass2" name="pass2" placeholder="Verify Password" onblur="verifyPassCheck();" onfocus="backWhite(this);" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-lg-4" for="prodType">Product Type</label>
                                            <div class="col-sm-3">
                                                <select name="prodType" id="prodType" class="form-control">
                                                    <option value="Audio CD" name="prodType" id="prodType">Audio CD</option>
                                                    <option value="Book" name="prodType" id="prodType">Book</option>
                                                    <option value="DVD" name="prodType" id="prodType">DVD</option>
                                                    <option value="Magazine" name="prodType" id="prodType">Magazine</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <button class="btn btn-primary btn-lg center-block">Add Account</button>
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
