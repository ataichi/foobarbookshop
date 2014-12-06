<%@page import="Beans.CustomerBean"%>
<%@page import="DAO.Implementation.CustomerDAOImplementation"%>
<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
    CustomerBean cbean = (CustomerBean) session.getAttribute("tempcustomer");
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

        <title>Edit Billing Information</title>

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
                                <li><a href="#"><span class="glyphicon glyphicon-edit"></span>Address</a></li>
                                <li><a href="customerPayments.jsp"><span class="glyphicon glyphicon-edit"></span>Credit Card</a></li>
                                <li><a href="changepassword.jsp"><span class="glyphicon glyphicon-pencil"></span>Change Password</a></li>
                                <li><a href="customerTransactions.jsp"><span class="glyphicon glyphicon-usd"></span> View Transactions</a></li>
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
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Address</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" id="customercheck" name="editbilling" onsubmit="return billingCheck();" method="post" action="EditBillingInfoServlet">
                            <div class="form-group" style="font-size: 20px;">
                                <label class="control-label col-lg-4">Billing Address</label>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-4" for="apartmentnoBA">Apartment No</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="apartmentnoBA" name="apartmentnoBA" placeholder="Apartment No" onblur="apartmentnoBACheck();" onfocus="backWhite(this);" value="<% out.println(cbean.getApartmentNoBA()); %>" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-4" for="streetBA">Street</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="streetBA" name="streetBA" placeholder="Street" onblur="streetBACheck();" onfocus="backWhite(this);" value="<% out.println(cbean.getStreetBA()); %>" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-4" for="subdivisionBA">Subdivision</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="subdivisionBA" name="subdivisionBA" placeholder="Subdivision" onblur="subdivisionBACheck();" onfocus="backWhite(this);" value="<% out.println(cbean.getSubdivisionBA()); %>"  required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-4" for="cityBA">City</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="cityBA" name="cityBA" placeholder="City" onblur="cityBACheck();" onfocus="backWhite(this);" value="<% out.println(cbean.getCityBA()); %>" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-4" for="countryBA">Country</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="countryBA" name="countryBA" placeholder="Country" onblur="countryBACheck();" onfocus="backWhite(this);" value="<% out.println(cbean.getCountryBA()); %>" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-4" for="postalcodeBA">Postal Code</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="postalcodeBA" name="postalcodeBA" placeholder="Postal Code" onblur="postalcodeBACheck();" onfocus="backWhite(this);" value="<% out.println(cbean.getPostalCodeBA()); %>" required>
                                </div>
                            </div>
                            <div class="form-group" style="font-size: 20px;">
                                <label class="control-label col-lg-4">Delivery Address</label>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-4" for="apartmentnoDA">Apartment No</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="apartmentnoDA" name="apartmentnoDA" placeholder="Apartment No" onblur="apartmentnoDACheck();" onfocus="backWhite(this);" value="<% out.println(cbean.getApartmentNoDA()); %>" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-4" for="streetDA">Street</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="streetDA" name="streetDA" placeholder="Street" onblur="streetDACheck();" onfocus="backWhite(this);" value="<% out.println(cbean.getStreetDA()); %>" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-4" for="subdivisionDA">Subdivision</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="subdivisionDA" name="subdivisionDA" placeholder="Subdivision" onblur="subdivisionDACheck();" onfocus="backWhite(this);" value="<% out.println(cbean.getSubdivisionDA()); %>" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-4" for="cityDA">City</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="cityDA" name="cityDA" placeholder="City" onblur="cityDACheck();" onfocus="backWhite(this);" value="<% out.println(cbean.getCityDA()); %>" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-4" for="countryDA">Country</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="countryDA" name="countryDA" placeholder="Country" onblur="countryDACheck();" onfocus="backWhite(this);" value="<% out.println(cbean.getCountryDA()); %>" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-lg-4" for="postalcodeDA">Postal Code</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="postalcodeDA" name="postalcodeDA" placeholder="Postal Code" onblur="postalcodeDACheck();" onfocus="backWhite(this);" value="<% out.println(cbean.getPostalCodeDA());%>" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-primary btn-lg center-block">Edit Billing Account</button>
                            </div>
                            <div class="form-group">
                                <a href='customerHOME.jsp'><button class="btn btn-primary btn-lg center-block">Cancel</button></a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script src="dist/js/jquery-2.1.0.min.js"></script>
        <script src="dist/js/query.js"></script>
        <script src="dist/js/bootstrap.min.js"></script>

    </body>
</html>
