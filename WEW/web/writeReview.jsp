<%@page import="Beans.ProductOrderBean"%>
<%@page import="Beans.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
    ArrayList<ProductBean> orderproductlist = (ArrayList<ProductBean>) session.getAttribute("orderproductlist");
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
        <link href="css/wadesign.css" rel="stylesheet">
        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <link href="dist/css/morris.css" rel="stylesheet">
        <link href="dist/css/font-awesome.min.css" rel="stylesheet">
        <title> Write Review</title>
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
                                <li><a href="customerAccount.jsp"><span class="glyphicon glyphicon-edit"></span> Account</a></li>
                                <li><a href="customerBilling.jsp"><span class="glyphicon glyphicon-edit"></span> Address</a></li>
                                <li><a href="changepassword.jsp"><span class="glyphicon glyphicon-pencil"></span> Change Password</a></li>
                                <li><a href="customerTransactions.jsp"><span class="glyphicon glyphicon-usd"></span> View Transactions</a></li>
                            </ul>
                        </li>
                        <li><a href="homepage.jsp"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                    </ul>
                    <form class="navbar-form navbar-right" action='CustomerSearchProductServlet' method="post">
                        <div class="input-group input-group-sm" style="max-width:360px;">
                            <input type="text" class="form-control" placeholder="Sea="input-group-btn">
                                   <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </nav>
    <div class="container-fluid" style="padding-top: 100px; padding-left: 30px;">
        <div class="row">
            <div class="col-md-1">
                <div class="affix">
                    <div class="well"> 
                        <ul class="nav">
                            <li class="active"><a href="#viewbook" id="viewbook"><img src="./images/book-small-icon.png" style="width: 50px; length:50px;" class="img-responsive"/></a></li>
                            <li><a href="#viewmag" id="viewmag"><img src="./images/magazine-small-icon.png" style="width: 50px; length:50px;" class="img-responsive"/></a></li>
                            <li><a href="#viewcd" id="viewcd"><img src="./images/cd-small-icon.png" style="width: 50px; length:50px;" class="img-responsive"/></a></li>
                            <li><a href="#viewdvd" id="viewdvd"><img src="./images/dvd-small-icon.png" style="width: 50px; length:50px;" class="img-responsive"/></a></li>
                        </ul>
                    </div>
                </div> 
            </div>
        </div>
    </div>
    <div class="col-md-7" style="padding-left: 200px; padding-top: 100px">
        <div class="well" id="shoplist">
            <dl class="dl-horizontal">
                <%
                    // insert shopping cart here!
                    if (orderproductlist.size() == 0) {
                        out.println("<p> Shopping cart empty.</p>");
                    } else {
                        for (int i = 0; i < orderproductlist.size(); i++) { //gets total order

                            out.println("<form action='WriteReview'>"
                                    + "<dt> Title</dt>"
                                    + "<dd>"
                                    + orderproductlist.get(i).getTitle()
                                    + "</dd>"
                                    + "<dt> Review: </dt>"
                                    + "<dd><input type='text' name='review'/>"
                                    + "<input type='hidden' name='productid' value='" + orderproductlist.get(i).getProductID() + "'/>"
                                    + "</dd>"
                                    + "<dt>"
                                    + "<input type='submit' value='Submit Review'/>"
                                    + "</dt>"
                                    + "</form>");

                        }
                    }
                %>

            </dl>
        </div>
    </div>



</body>
</html>
