<%@page import="Beans.ProductOrderBean"%>
<%@page import="Beans.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<%
    AccountBean account = (AccountBean) session.getAttribute("homeuser");
    if (account == null) {
        response.sendRedirect("login.jsp");
    } else {


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
        <link href="css/wadesign.css" rel="stylesheet">
        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <link href="dist/css/morris.css" rel="stylesheet">
        <link href="dist/css/font-awesome.min.css" rel="stylesheet">
        <title> Enter Credit Card</title>
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
                        <li class="active"><a href="customerHOME.jsp"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + account.getUsername());%> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="customerAccount.jsp"><span class="glyphicon glyphicon-edit"></span> Account</a></li>
                                <li><a href="customerBilling.jsp"><span class="glyphicon glyphicon-edit"></span> Address</a></li>
                                <li><a href='customerviewreviews.jsp'><span class="glyphicon glyphicon-edit"></span> Reviews</a></li>
                                <li><a href="customerChangePassword.jsp"><span class="glyphicon glyphicon-pencil"></span> Change Password</a></li>
                                <li><span class="glyphicon glyphicon-usd"></span><form action='ViewCustomerTransactions'><input type='submit' value=' Transactions' style='background-color: transparent; border: none'/></form></li>
                            </ul>
                        </li>
                        <li><a><span class="glyphicon glyphicon-log-out"></span><form action="LogoutServlet"><input type="submit" value="Logout" style='background-color: transparent; border: none'/></form></a></li>
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

        <div class="container-fluid" style="padding-top: 100px; padding-left: 30px;">
            <div class="row">
                <div class="col-sm-9 col-md-offset-2 main">
                    <div class="panel panel-default" id="shoplist">
                        <div class="panel-heading">
                            <div class="panel-title">Add Credit Card Information</div>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" action="ShoppingServlet" onsubmit='return creditCardCheck();' id='creditcardcheck' name='creditcardcheck' method='post'>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="cardName">Credit Card Name</label>
                                    <div class="col-sm-3">
                                        <input class="form-control" type='text' name='cardName' required />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4"  for="cardType">Card Type</label>
                                    <div class="col-sm-3">
                                        <input type='radio' id='cardType' name='cardType' value='AmericanExpress'>American Express
                                        <input type='radio' id='cardType' name='cardType' value='Visa'>Visa
                                        <input type='radio' id='cardType' name='cardType' value='MasterCard'>MasterCard
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4">Credit Card No</label>
                                    <div class="col-sm-3">
                                        <input class="form-control" type='text' id='cardNo' name='cardNo' onblur='creditCardNoCheck();' onfocus="backWhite(this);"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4">Expiration Date</label>
                                    <div class="col-sm-3">
                                        <input class="form-control" type='date' id='cardExpDate' name='cardExpDate' required/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button type='submit' class="btn btn-primary btn-lg center-block">Buy</button>
                                </div>
                            </form>
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