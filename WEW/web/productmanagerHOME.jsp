
<%@page import="Beans.DVDBean"%>
<%@page import="Beans.MagazineBean"%>
<%@page import="Beans.AudioCDBean"%>
<%@page import="Beans.BookBean"%>
<%@page import="DAO.Interface.DVDManagerDAOInterface"%>
<%@page import="DAO.Implementation.DVDManagerDAOImplementation"%>
<%@page import="DAO.Interface.MagazineManagerDAOInterface"%>
<%@page import="DAO.Implementation.MagazineManagerDAOImplementation"%>
<%@page import="DAO.Interface.AudioCDManagerDAOInterface"%>
<%@page import="DAO.Implementation.AudioCDManagerDAOImplementation"%>
<%@page import="DAO.Interface.BookManagerDAOInterface"%>
<%@page import="DAO.Implementation.BookManagerDAOImplementation"%>
<%@page import="Beans.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Interface.ProductManagerDAOInterface"%>
<%@page import="DAO.Implementation.ProductManagerDAOImplementation"%>
<%@page import="Beans.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    AccountBean homeproduct = (AccountBean) session.getAttribute("homeproduct");
    if (homeproduct == null) {
        response.sendRedirect("login.jsp");
    } else {
        ProductManagerDAOInterface pdao = new ProductManagerDAOImplementation();
        ArrayList<ProductBean> productlist = (ArrayList<ProductBean>) session.getAttribute("productlist");
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
        <title>Product Manager Home</title>

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
                        <li><a href="productmanagerHOME.jsp"><span class="glyphicon glyphicon-home active"></span> Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + homeproduct.getUsername());%> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="productmanagerAccount.jsp"><span class="glyphicon glyphicon-edit"></span>Account</a></li>
                                <li><a href="productmanagerChangePassword.jsp"><span class="glyphicon glyphicon-pencil"></span>Change Password</a></li>
                            </ul>
                        </li>
                        <!--<li><span class="glyphicon glyphicon-log-out"></span><form action="LogoutServlet"><input type="submit" value="Log out" style='border: none'/></form></li>-->
                        <li><a><span class="glyphicon glyphicon-log-out"></span><form action="LogoutServlet"><input type="submit" value="Logout" style='background-color: transparent; border: none'/></form></a></li>
                    </ul>
                    <form class="navbar-form navbar-right" action='SearchProductServlet' method="post">
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

        <div class="container-fluid" style="padding-top: 100px;">
            <div class="row">
                <div class="col-sm-9 col-sm-offset-2 col-md-10 col-md-offset-1 main">
                    <h1 class="page-header">List of Products</h1>
                    <h3 class="sub-header"><a href="addproduct.jsp"><button class="btn btn-primary btn-sm">Add Product</button></a></h3>
                    <div class="dropdown-header">Sort By:
                        <select name="sort" id="sort">
                            <option value="Title" name="sort" id="sort" class="dropdown-toggle">Title</option>
                            <option value="Stocks" name="sort" id="sort" class="dropdown-toggle">Stocks</option>
                            <option value="Year" name="sort" id="sort" class="dropdown-toggle">Year</option>
                        </select>
                    </div> 
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Title</th>
                                    <th>Stocks</th>
                                    <th>Summary</th>
                                    <th>Price</th>
                                    <th>Genre</th>
                                    <th>Year</th>
                                    <th>Option</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    int i;
                                    for (i = 0; i < productlist.size(); i++) {
                                        out.println("<tr>"
                                                + "<td>"
                                                + productlist.get(i).getTitle()
                                                + "</td><td>"
                                                + productlist.get(i).getNumberStocks()
                                                + "</td><td>"
                                                + productlist.get(i).getSummary()
                                                + "</td><td>"
                                                + productlist.get(i).getPrice()
                                                + "</td><td>"
                                                + productlist.get(i).getGenre()
                                                + "</td><td>"
                                                + productlist.get(i).getYear()
                                                + "</td><td>"
                                                + "<form id='" + productlist.get(i).getProductID() + "' method='post' action='ViewProductServlet'>"
                                                + "<input type='hidden' id='product' name='product' value='" + productlist.get(i).getProductID() + "'/>"
                                                + "<input type='submit' id='submit' value='View Details' name='action' style='border-color: transparent; background-color: transparent'/>"
                                                + "</form>"
                                                + "<form id='" + productlist.get(i).getProductID() + "' method='post' action='EditProductServlet'>"
                                                + "<input type='hidden' id='product' name='product' value='" + productlist.get(i).getProductID() + "'/>"
                                                + "<input type='submit' id='submit' value='Edit' name='action' style='border-color: transparent; background-color: transparent'/>"
                                                + "</form>"
                                                + "<form id='" + productlist.get(i).getProductID() + "' method='post' action='RemoveProductServlet'>"
                                                + "<input type='hidden' id='product' name='product' value='" + productlist.get(i).getProductID() + "'/>"
                                                + "<input type='submit' value='Remove' name='action' style='border-color:transparent; background-color: transparent'/>"
                                                + "</form>"
                                                + "<form id='" + productlist.get(i).getProductID() + "' method='post' action='RestockProductServlet'>"
                                                + "<input type='hidden' id='product' name='product' value='" + productlist.get(i).getProductID() + "'/>"
                                                + "<input type='submit' value='Restock' name='action' style='border-color:transparent; background-color: transparent'/>"
                                                + "</form>"
                                                + "</td></tr>");
                                    }
                                %>
                            </tbody>
                        </table>
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