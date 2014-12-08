<%@page import="Beans.ProductBean"%>
<%@page import="Beans.ProductOrderBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
    if (homeuser == null) {
        response.sendRedirect("login.jsp");
    } else {

        ArrayList<ProductOrderBean> temporder = (ArrayList<ProductOrderBean>) session.getAttribute("temporder");
        ArrayList<ProductBean> tempproductlist = (ArrayList<ProductBean>) session.getAttribute("tempproductlist");
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
        <title>Confirm Shopping Cart</title>
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
                                <li><span class="glyphicon glyphicon-usd"></span><form action='ViewCustomerTransactions'><input type='submit' value='View Transactions' style='background-color: transparent; border: none'/></form></li>
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
        <div class="container-fluid" style="padding-top: 80px; padding-left: 30px;">
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

                <div class="col-md-4 well" style="padding-left: 20px;">
                    <div class="pull-right affix">
                        <div class="panel-body"> 
                            <%
                                // insert shopping cart here!
                                if (temporder.size() == 0) {
                                    out.println("<p> Shopping cart empty.</p>");
                                } else {
                                    out.println("<form action='ShoppingServlet'>"
                                            + "<input type='submit' value='Buy' name='action'/>"
                                            + "</form>");
                                    for (int i = 0; i < temporder.size(); i++) { //gets total order
                                        for (int j = 0; j < tempproductlist.size(); j++) {
                                            if (temporder.get(i).getProductorder_productID() == tempproductlist.get(j).getProductID()) {

                                                out.println("<table>"
                                                        + "<form action='EditShoppingCartServlet'>"
                                                        + "<tr><td>Title: " + tempproductlist.get(j).getTitle() + "</td></tr>"
                                                        + "<tr><td>Price: " + tempproductlist.get(j).getPrice() + "</td></tr>"
                                                        + "<tr><td>Qty: <input type='number' name='qty' id='qty' min='1' max='10' value='" + temporder.get(i).getQuantity() + "' onClick='updateTotal()'/></td></tr>"
                                                        + "<tr><td>Total: " + temporder.get(i).getPrice() + "</td></tr>"
                                                        // pakiayos nalang yung edit hehe thanks di ko alam pano sya dynamically magcchange pag nagclick e
                                                        + "<tr><input type='hidden' value='" + tempproductlist.get(j).getProductID() + "' name='productid'/></tr>"
                                                        + "<tr><input type='submit' value='Save' name='action'/></tr>"
                                                        + "<tr><input type='submit' value='Remove' name='action'/></tr>"
                                                        + "</table>"
                                                        + "</form>"
                                                        + "<br/><br/>");
                                                break;
                                            }
                                        }

                                    }

                                }
                            %>

                        </div>
                    </div>
                </div>
            </div>

    </body>
</html>
<%}%>