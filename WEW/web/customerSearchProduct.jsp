<%@page import="Beans.AccountBean"%>
<%@page import="Beans.MagazineBean"%>
<%@page import="Beans.DVDBean"%>
<%@page import="Beans.BookBean"%>
<%@page import="Beans.AudioCDBean"%>
<%@page import="Beans.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
    if (homeuser == null) {
        response.sendRedirect("login.jsp");
    } else {
        ArrayList<ProductBean> searchproductlist = (ArrayList<ProductBean>) session.getAttribute("searchproductlist");
        ArrayList<AudioCDBean> searchaudiocdlist = (ArrayList<AudioCDBean>) session.getAttribute("searchaudiocdlist");
        ArrayList<BookBean> searchbooklist = (ArrayList<BookBean>) session.getAttribute("searchbooklist");
        ArrayList<DVDBean> searchdvdlist = (ArrayList<DVDBean>) session.getAttribute("searchdvdlist");
        ArrayList<MagazineBean> searchmagazinelist = (ArrayList<MagazineBean>) session.getAttribute("searchmagazinelist");
        ProductBean product = new ProductBean();
%>
<!DOCTYPE html>
<html>
    <head>
        <% response.addHeader("X-FRAME-OPTIONS", "DENY");
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
        <title>Search Product</title>
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
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + homeuser.getUsername());%> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="customerAccount.jsp"><span class="glyphicon glyphicon-edit"></span> Account</a></li>
                                <li><a href="customerBilling.jsp"><span class="glyphicon glyphicon-edit"></span> Address</a></li>
                                <li><a href='customerviewreviews.jsp'><span class="glyphicon glyphicon-edit"></span>View Reviews</a></li>
                                <li><a href="customerChangePassword.jsp"><span class="glyphicon glyphicon-pencil"></span> Change Password</a></li>
                                <li><span class="glyphicon glyphicon-usd"></span><form action='ViewCustomerTransactions'><input type='submit' value='View Transactions' style='background-color: transparent; border: none'/></form></li>
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
        <div class="container-fluid" style="padding-top: 80px; padding-left: 30px;">
            <div class="row">
                <div class="col-md-7" style="padding-left: 20px;">
                    <div class="well" id="shoplist">
                        <%
                            if (searchproductlist.size() > 0) { //not empty
                                for (int i = 0; i < searchproductlist.size(); i++) {
                                    out.println("Title:" + searchproductlist.get(i).getTitle()
                                            + "<br/>Price: " + searchproductlist.get(i).getPrice()
                                            + "<br/>Product Type: " + searchproductlist.get(i).getType()
                                            + "<br/>Summary: " + searchproductlist.get(i).getSummary()
                                            + "<form action='ShoppingCart' method='post'>"
                                            + "<input type='hidden' name='product' value='" + searchproductlist.get(i).getProductID() + "'/>"
                                            + "<input type='submit' value='View Details' name='viewProduct'/></form>"
                                            + "<form action='ShoppingCart' method='post'>"
                                            + "<input type='hidden' name='productid' value='" + searchproductlist.get(i).getProductID() + "'/>"
                                            + "<input type='number' name='qty' min='0' max='10' value='0'/>"
                                            + "<input type='submit' name='action' value='Add to Cart'/>"
                                            + "<input type='submit' name='action' value='Buy'/></form>"
                                            + "<br/><br/>"
                                    );
                                }
                            }
                        %>
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