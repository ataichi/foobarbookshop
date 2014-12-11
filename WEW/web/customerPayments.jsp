<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
    if (homeuser == null) {
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

        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <link href="dist/css/morris.css" rel="stylesheet">
        <link href="dist/css/font-awesome.min.css" rel="stylesheet">

        <title>Credit Card</title>
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
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + homeuser.getUsername());%> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="customerAccount.jsp"><span class="glyphicon glyphicon-edit"></span>Account</a></li>
                                <li><a href="customerBilling.jsp"><span class="glyphicon glyphicon-edit"></span>Address</a></li>
                                <li><span class="glyphicon glyphicon-edit"></span><form action='ViewCustomerReview'><input type='submit' value='View Review' style='background-color: transparent; border:none'/></form></li>
                                <li><a href="customeChangePassword.jsp"><span class="glyphicon glyphicon-pencil"></span>Change Password</a></li>
                                <li><span class="glyphicon glyphicon-usd"></span><form action='ViewCustomerTransactions'><input type='submit' value='View Transactions' style='background-color: transparent; border: none'/></form></li>
                            </ul>
                        </li>
                        <li><form action="LogoutServlet"><span class="glyphicon glyphicon-log-out"></span><input type="submit" value="Log out" style=' border:none'/></form></li>
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
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Change Password</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" id='addcreditcard' action='AddCreditCardServlet' method='post'>
                            <div>
                                <div class="form-group" style="font-size: 20px;">
                                    <label class="control-label col-lg-4">Credit Card Information</label>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4">Card Name</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" placeholder="Enter Card Name" name='cardName' required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" >Card Number</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" placeholder="Enter Card Number" name='cardNo' required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4">Card Type</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" placeholder="Enter Card Type" name='cardType' required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4">Expiration Date</label>
                                    <div class="col-sm-3">
                                        <input type="date" class="form-control" placeholder="Enter Expirtion Date"  name='cardExpDate' required>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <button class="btn btn-primary btn-lg center-block" type='submit' value='Submit'>Save Changes</button>
                                </div>
                            </div>
                        </form>
                        <div class="form-group">
                            <a href='customerHOME.jsp'><button class="btn btn-primary btn-lg center-block">Cancel</button></a>
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