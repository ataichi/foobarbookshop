<%@page import="Beans.ProductBean"%>
<%@page import="Beans.ShoppingCartBean"%>
<%@page import="Beans.ProductOrderBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.AccountBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean account = (AccountBean) session.getAttribute("homeaccounting");
    if (account == null) {
        response.sendRedirect("login.jsp");
    } else {
        ArrayList<ProductOrderBean> productorderlist = (ArrayList<ProductOrderBean>) session.getAttribute("productorderlist");

        ArrayList<ShoppingCartBean> shoppingcartlist = (ArrayList<ShoppingCartBean>) session.getAttribute("shoppingcartlist");

        ArrayList<ProductBean> audiolist = (ArrayList<ProductBean>) session.getAttribute("audiolist");

        ArrayList<ProductBean> booklist = (ArrayList<ProductBean>) session.getAttribute("booklist");

        ArrayList<ProductBean> dvdlist = (ArrayList<ProductBean>) session.getAttribute("dvdlist");

        ArrayList<ProductBean> magazinelist = (ArrayList<ProductBean>) session.getAttribute("magazinelist");

        double finalsales = 0;
        double sales = 0;
        double total = 0;
        int sales_ctr = 0;

%>
<!DOCTYPE html>
<html >
    <head>
        <%            response.addHeader("X-FRAME-OPTIONS", "DENY");
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
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <!-- BOOTSTRAP STYLES-->
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->
        <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
        <link href="assets/css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <script src="js/customercheck.js" type="text/javascript"></script>
        <script src="js/managercheck.js" type="text/javascript"></script>
        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <link href="dist/css/morris.css" rel="stylesheet">
        <link href="dist/css/font-awesome.min.css" rel="stylesheet">

        <title>Accounting Manager</title>

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
                        <li><a href="accountingmanagerHOME.jsp"><span class="glyphicon glyphicon-home active"></span> Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(account.getUsername()); %> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="accountingmanagerAccount.jsp"><span class="glyphicon glyphicon-edit"></span>Account</a></li>
                                <li><a href="accountingmanagerChangePassword.jsp"><span class="glyphicon glyphicon-pencil"></span>Change Password</a></li>
                            </ul>
                        </li>
                        <!--<li><span class="glyphicon glyphicon-log-out"></span><form action="LogoutServlet"><input type="submit" value="Log out" style='border: none'/></form></li>-->
                        <li><a><span class="glyphicon glyphicon-log-out"></span><form action="LogoutServlet"><input type="submit" value="Logout" style='background-color: transparent; border: none'/></form></a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container-fluid" style="padding-top: 100px;">
            <div class="row">            
                <div class="col-md-6 col-sm-12 col-xs-12">                     
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Sales by Product Type
                        </div>
                        <div class="panel-body">
                            <div id="morris-bar-chart"></div>
                        </div>

                        <div class="container-fluid" style="padding-left: 30px;">
                            <div class="row">
                                <div class="col-md-7" style="padding-left: 20px;">
                                    <div class="bs-docs-section">
                                        <div class="bs-example bs-example-tabs" role="tabpanel">
                                            <ul id="myTab" class="nav nav-tabs" role="tablist">
                                                <li role="presentation" class="active"><a href="#viewbook" id="book-tab" role="tab" data-toggle="tab" aria-controls="viewbook" aria-expanded="true"><img src="./images/book-small-icon.png" style="width: 50px; length:50px;" class="img-responsive"/></a></li>
                                                <li role="presentation"><a href="#viewmag" role="tab" id="mag-tab" data-toggle="tab" aria-controls="viewmag"><img src="./images/magazine-small-icon.png" style="width: 50px; length:50px;" class="img-responsive"/></a></li>
                                                <li role="presentation"><a href="#viewcd" role="tab" id="cd-tab" data-toggle="tab" aria-controls="viewcd"><img src="./images/cd-small-icon.png" style="width: 50px; length:50px;" class="img-responsive"/></a></li>
                                                <li role="presentation"><a href="#viewdvd" role="tab" id="dvd-tab" data-toggle="tab" aria-controls="viewdvd"><img src="./images/dvd-small-icon.png" style="width: 50px; length:50px;" class="img-responsive"/></a></li>
                                                <li role="presentation"><a href="#viewtotal" role="tab" id="total-tab" data-toggle="tab" aria-controls="viewtotal">TOTAL</a></li>
                                                <li role="presentation"><a href="#viewspecific" role="tab" id="specific-tab" data-toggle="tab" aria-controls="viewspecific">View Sales For This Year</a></li>
                                            </ul>
                                            <div id="myTabContent" class="tab-content">
                                                <div role="tabpanel" class="tab-pane fade in well active" id="viewbook" aria-labelledBy="book-tab" style='height: 500px; width: 500px; overflow-y: scroll;'>
                                                    <%                                                    finalsales = 0;
                                                        out.println("BOOK");
                                                        sales = 0;
                                                        sales_ctr = 0;
                                                        if (booklist.size() == 0) {
                                                            out.println("<h4>No books to display.</h4>");
                                                        } else {
                                                            for (int a = 0; a < booklist.size(); a++) {
                                                    %>
                                                    <h4>Title: <%out.println(booklist.get(a).getTitle());%>
                                                        <h4>Price: <%out.println(booklist.get(a).getPrice());%></h4>
                                                        <%
                                                            for (int b = 0; b < shoppingcartlist.size(); b++) {
                                                                for (int c = 0; c < productorderlist.size(); c++) {
                                                                    if (shoppingcartlist.get(b).getShoppingcartID() == productorderlist.get(b).getProductorder_shoppingcartID()
                                                                            && productorderlist.get(b).getProductorder_productID() == booklist.get(a).getProductID()) {
                                                                        sales = sales + (productorderlist.get(b).getPrice() * productorderlist.get(b).getQuantity());
                                                                        sales_ctr++;
                                                                        break;
                                                                    }
                                                                }

                                                            }
                                                            finalsales += sales;
                                                        %>
                                                        <h2>Total sales count: <%out.println(sales_ctr);%></h2>
                                                        <h2>Total sales: Php <%out.println(sales);%></h2>
                                                        <%
                                                            }
                                                        %>
                                                        <h3>Total Sales: <%out.println(finalsales);%> </h3>
                                                        <%}%>
                                                </div>
                                                <div role="tabpanel" class="tab-pane fade in well" id="viewmag" aria-labelledBy="mag-tab" style='height: 500px; width: 500px; overflow-y: scroll;'>
                                                    <%
                                                        out.println("MAGAZINE");
                                                        finalsales = 0;
                                                        sales = 0;
                                                        sales_ctr = 0;
                                                        if (magazinelist.size() == 0) {
                                                            out.println("<h4>No magazines.</h4>");
                                                        } else {
                                                            for (int a = 0; a < magazinelist.size(); a++) {
                                                    %>
                                                    <h4>Title: <%out.println(magazinelist.get(a).getTitle());%>
                                                        <h4>Price: <%out.println(magazinelist.get(a).getPrice());%></h4>
                                                        <%
                                                            for (int b = 0; b < shoppingcartlist.size(); b++) {
                                                                for (int c = 0; c < productorderlist.size(); c++) {
                                                                    if (shoppingcartlist.get(b).getShoppingcartID() == productorderlist.get(b).getProductorder_shoppingcartID()
                                                                            && productorderlist.get(b).getProductorder_productID() == magazinelist.get(a).getProductID()) {
                                                                        sales = sales + (productorderlist.get(b).getPrice() * productorderlist.get(b).getQuantity());
                                                                        sales_ctr++;
                                                                        break;
                                                                    }
                                                                }

                                                            }
                                                            finalsales += sales;
                                                        %>
                                                        <h2>Total sales count: <%out.println(sales_ctr);%></h2>
                                                        <h2>Total sales: Php <%out.println(sales);%></h2>
                                                        <%
                                                            }
                                                        %>
                                                        <h3>Total Sales: <%out.println(finalsales);%> </h3>
                                                        <%}%>
                                                </div>
                                                <div role="tabpanel" class="tab-pane fade in well " id="viewcd" aria-labelledBy="cd-tab" style='height: 500px; width: 500px; overflow-y: scroll;'>
                                                    <%
                                                        out.println("CD");

                                                        finalsales = 0;
                                                        sales = 0;
                                                        sales_ctr = 0;
                                                        if (audiolist.size() == 0) {
                                                            out.println("No Audio CD.");
                                                        } else {
                                                            for (int a = 0; a < audiolist.size(); a++) {
                                                    %>
                                                    <h4>Title: <%out.println(audiolist.get(a).getTitle());%>
                                                        <h4>Price: <%out.println(audiolist.get(a).getPrice());%></h4>
                                                        <%
                                                            for (int b = 0; b < shoppingcartlist.size(); b++) {
                                                                for (int c = 0; c < productorderlist.size(); c++) {
                                                                    if (shoppingcartlist.get(b).getShoppingcartID() == productorderlist.get(b).getProductorder_shoppingcartID()
                                                                            && productorderlist.get(b).getProductorder_productID() == audiolist.get(a).getProductID()) {
                                                                        sales = sales + (productorderlist.get(b).getPrice() * productorderlist.get(b).getQuantity());
                                                                        sales_ctr++;
                                                                        break;
                                                                    }
                                                                }

                                                            }
                                                            finalsales += sales;
                                                        %>
                                                        <h2>Total sales count: <%out.println(sales_ctr);%></h2>
                                                        <h2>Total sales: Php <%out.println(sales);%></h2>
                                                        <%
                                                            }
                                                        %>
                                                        <h3>Total Sales: <%out.println(finalsales);%> </h3>
                                                        <%}%>
                                                </div>
                                                <div role="tabpanel" class="tab-pane fade in well " id="viewdvd" aria-labelledBy="cd-tab" style='height: 500px; width: 500px; overflow-y: scroll;'>
                                                    <%
                                                        out.println("DVD");

                                                        finalsales = 0;
                                                        sales = 0;
                                                        sales_ctr = 0;
                                                        if (dvdlist.size() == 0) {
                                                            out.println("<h4>No DVD.</h4>");
                                                        } else {
                                                            for (int a = 0; a < dvdlist.size(); a++) {
                                                    %>
                                                    <h4>Title: <%out.println(dvdlist.get(a).getTitle());%>
                                                        <h4>Price: <%out.println(dvdlist.get(a).getPrice());%></h4>
                                                        <%
                                                            for (int b = 0; b < shoppingcartlist.size(); b++) {
                                                                for (int c = 0; c < productorderlist.size(); c++) {
                                                                    if (shoppingcartlist.get(b).getShoppingcartID() == productorderlist.get(b).getProductorder_shoppingcartID()
                                                                            && productorderlist.get(b).getProductorder_productID() == dvdlist.get(a).getProductID()) {
                                                                        sales = sales + (productorderlist.get(b).getPrice() * productorderlist.get(b).getQuantity());
                                                                        sales_ctr++;
                                                                        break;
                                                                    }
                                                                }

                                                            }
                                                            finalsales += sales;
                                                        %>
                                                        <h2>Total sales count: <%out.println(sales_ctr);%></h2>
                                                        <h2>Total sales: Php <%out.println(sales);%></h2>
                                                        <%
                                                            }
                                                        %>
                                                        <h3>Total Sales: <%out.println(finalsales);%> </h3>
                                                        <%}%>
                                                </div>
                                                <div role="tabpanel" class="tab-pane fade in well" id="viewtotal" aria-labelledBy="total-tab" style='height: 500px; width: 500px; overflow-y: scroll;'>
                                                    <%                                                    // for book
                                                        sales = 0;

                                                        for (int a = 0; a < booklist.size(); a++) {
                                                            for (int b = 0; b < shoppingcartlist.size(); b++) {
                                                                for (int c = 0; c < productorderlist.size(); c++) {
                                                                    if (shoppingcartlist.get(b).getShoppingcartID() == productorderlist.get(b).getProductorder_shoppingcartID()
                                                                            && productorderlist.get(b).getProductorder_productID() == booklist.get(a).getProductID()) {
                                                                        sales = sales + (productorderlist.get(b).getPrice() * productorderlist.get(b).getQuantity());
                                                                        break;
                                                                    }
                                                                }

                                                            }
                                                            total += sales;
                                                            finalsales += sales;
                                                        }
                                                        if (booklist.size() == 0) {
                                                            out.println("<h4>No books.</h4>");
                                                        } else {
                                                    %>
                                                    <h3>Total Sales (Book): <%out.println(finalsales);%></h3>

                                                    <%}
                                                        finalsales = 0;
                                                        // for audio cd

                                                        for (int a = 0; a < audiolist.size(); a++) {
                                                            //                out.println("<h4>Title:" + audiolist.get(a).getTitle() + "</h4>");
                                                            for (int b = 0; b < shoppingcartlist.size(); b++) {
                                                                for (int c = 0; c < productorderlist.size(); c++) {
                                                                    if (shoppingcartlist.get(b).getShoppingcartID() == productorderlist.get(b).getProductorder_shoppingcartID()
                                                                            && productorderlist.get(b).getProductorder_productID() == audiolist.get(a).getProductID()) {
                                                                        sales = sales + (productorderlist.get(b).getPrice() * productorderlist.get(b).getQuantity());
                                                                        break;
                                                                    }
                                                                }

                                                            }
                                                            total += sales;
                                                            finalsales += sales;
                                                            out.println(sales);
                                                        }
                                                        if (audiolist.size() == 0) {
                                                            out.println("<h4>No Audio CD.</h4>");
                                                        } else {
                                                            out.println("<h3>Total Sales (Audio CD):" + finalsales);
                                                        }

                                                    %>

                                                    <%                                                    finalsales = 0;
                                                        // for magazine

                                                        sales = 0;
                                                        for (int a = 0; a < magazinelist.size(); a++) {
                                                            //                   out.println("<h4>Title:" + magazinelist.get(a).getTitle() + "</h4>");
                                                            for (int b = 0; b < shoppingcartlist.size(); b++) {
                                                                for (int c = 0; c < productorderlist.size(); c++) {
                                                                    if (shoppingcartlist.get(b).getShoppingcartID() == productorderlist.get(b).getProductorder_shoppingcartID()
                                                                            && productorderlist.get(b).getProductorder_productID() == magazinelist.get(a).getProductID()) {
                                                                        sales = sales + (productorderlist.get(b).getPrice() * productorderlist.get(b).getQuantity());
                                                                        break;
                                                                    }
                                                                }

                                                            }
                                                            total += sales;
                                                            finalsales += sales;
                                                            out.println(sales);
                                                        }
                                                        if (magazinelist.size() == 0) {
                                                            out.println("<h4>No Magazine.</h4>");
                                                        } else {
                                                            out.println("<h3>Total Sales (Magazine):" + finalsales + "</h3>");
                                                        }

                                                    %>

                                                    <%finalsales = 0;

                                                        // for dvd
                                                        sales = 0;

                                                        for (int a = 0; a < dvdlist.size(); a++) {
                                                            for (int b = 0; b < shoppingcartlist.size(); b++) {
                                                                for (int c = 0; c < productorderlist.size(); c++) {
                                                                    if (shoppingcartlist.get(b).getShoppingcartID() == productorderlist.get(b).getProductorder_shoppingcartID()
                                                                            && productorderlist.get(b).getProductorder_productID() == dvdlist.get(a).getProductID()) {
                                                                        sales = sales + (productorderlist.get(b).getPrice() * productorderlist.get(b).getQuantity());
                                                                        break;
                                                                    }
                                                                }

                                                            }
                                                            total += sales;
                                                            finalsales += sales;
                                                            //      out.println(sales);
                                                        }
                                                        if (dvdlist.size() == 0) {
                                                            out.println("<h4>No DVD.</h4>");
                                                        } else {
                                                            out.println("<h3>Total Sales (DVD):" + finalsales);
                                                        }
                                                        finalsales = 0;
                                                    %>
                                                    <h3>Total Sales (All in All): <%out.println(total);%></h3>


                                                </div>
                                                <div role="tabpanel" class="tab-pane fade in well" id="viewspecific" aria-labelledBy="specific-tab" style='height: 500px'>
                                                    <%                                                    int year = new java.util.Date().getYear();
                                                    %>
                                                    <h3> <% out.println(year + 1900); %> </h3>
                                                    <%    sales = 0;
                                                        total = 0;

                                                        for (int i = 0; i < audiolist.size(); i++) {
                                                            for (int j = 0; j < shoppingcartlist.size(); j++) {
                                                                for (int k = 0; k < productorderlist.size(); k++) {
                                                                    if (shoppingcartlist.get(j).getOrderDate().getYear() == year
                                                                            && shoppingcartlist.get(j).getShoppingcartID() == productorderlist.get(k).getProductorder_shoppingcartID()
                                                                            && productorderlist.get(k).getProductorder_productID() == audiolist.get(i).getProductID()) {
                                                                        sales = sales + (productorderlist.get(k).getPrice() * productorderlist.get(k).getQuantity());
                                                                        sales_ctr++;
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            total += sales;
                                                            sales = 0;
                                                        }
                                                    %>
                                                    <h3>Audio CD: <%out.println(total);%></h3>

                                                    <%
                                                        total = 0;
                                                        sales = 0;

                                                        // books
                                                        for (int i = 0; i < booklist.size(); i++) {
                                                            for (int j = 0; j < shoppingcartlist.size(); j++) {
                                                                for (int k = 0; k < productorderlist.size(); k++) {
                                                                    if (shoppingcartlist.get(j).getOrderDate().getYear() == year
                                                                            && shoppingcartlist.get(j).getShoppingcartID() == productorderlist.get(k).getProductorder_shoppingcartID()
                                                                            && productorderlist.get(k).getProductorder_productID() == booklist.get(i).getProductID()) {
                                                                        sales = sales + (productorderlist.get(k).getPrice() * productorderlist.get(k).getQuantity());
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            total += sales;
                                                            sales = 0;
                                                        }
                                                    %>

                                                    <h3>Book: <%out.println(total);%></h3>

                                                    <%
                                                        total = 0;
                                                        sales = 0;

                                                        // dvd
                                                        for (int i = 0; i < dvdlist.size(); i++) {
                                                            for (int j = 0; j < shoppingcartlist.size(); j++) {
                                                                for (int k = 0; k < productorderlist.size(); k++) {
                                                                    if (shoppingcartlist.get(j).getOrderDate().getYear() == year
                                                                            && shoppingcartlist.get(j).getShoppingcartID() == productorderlist.get(k).getProductorder_shoppingcartID()
                                                                            && productorderlist.get(k).getProductorder_productID() == dvdlist.get(i).getProductID()) {
                                                                        sales = sales + (productorderlist.get(k).getPrice() * productorderlist.get(k).getQuantity());
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            total += sales;
                                                            sales = 0;
                                                        }
                                                    %>
                                                    <h3>DVD: <%out.println(total);%></h3>
                                                    <%
                                                        total = 0;
                                                        sales = 0;

                                                        // dvd
                                                        for (int i = 0; i < magazinelist.size(); i++) {
                                                            for (int j = 0; j < shoppingcartlist.size(); j++) {
                                                                for (int k = 0; k < productorderlist.size(); k++) {
                                                                    if (shoppingcartlist.get(j).getOrderDate().getYear() == year
                                                                            && shoppingcartlist.get(j).getShoppingcartID() == productorderlist.get(k).getProductorder_shoppingcartID()
                                                                            && productorderlist.get(k).getProductorder_productID() == magazinelist.get(i).getProductID()) {
                                                                        sales = sales + (productorderlist.get(k).getPrice() * productorderlist.get(k).getQuantity());
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            total += sales;
                                                            sales = 0;
                                                        }
                                                    %>

                                                    <h3>Magazine : <%out.println(total);%></h3>
                                                    <%
                                                        total = 0;
                                                        sales = 0;

                                                    %>
                                                </div>
                                            </div>
                                        </div><!-- /example -->
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- don't-->
                    </div>            
                </div>


                <div class="col-md-6 col-sm-12 col-xs-12">                     
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Total Sales
                        </div>
                        <div class="panel-body">
                            <div>
                                <canvas id="canvas" height="450" width="600"></canvas>
                            </div>
                        </div>
                    </div>            
                </div>
            </div>
        </div>

        <!--<div class="table-responsive">
          <table class="table table-striped">
              <thead>
                  <tr>
                      <th>Title</th>
                      <th>Stocks</th>
                      <th>Summary</th>
                      <th>Price</th>
                      <th>Genre</th>
                      <th>Year</th>
        
                  </tr>
              </thead>
              <tbody>
                  //<%                                                                                    //  int i;
                      //for (i = 0; i < productlist.size(); i++) {
                      //  out.println("<tr>"
                      //          + "<td>"
                      //          + productlist.get(i).getTitle()
                      //          + "</td><td>"
                      //          + productlist.get(i).getNumberStocks()
                      //        + "</td><td>"
                      //        + productlist.get(i).getSummary()
                      //        + "</td><td>"
                      //        + productlist.get(i).getPrice()
                      //        + "</td><td>"
                      //        + productlist.get(i).getGenre()
                      //       + "</td><td>"
                      //     + productlist.get(i).getYear()
                      //     + "</td></tr>");
                      // }
        %>
                                                                                                                                                        </tbody>
                                                                                                                                                        </table>
                                                                                                                                                        </div>
                                                                                                                                                        </div>-->

        <script>
            var randomScalingFactor = function () {
                return Math.round(Math.random() * 100)
            };

            var getJanuary = function () {

            };

            var getFebruary = function () {

            };

            var getMarch = function () {

            };

            var getApril = function () {

            };

            var getMay = function () {

            };

            var getJune = function () {

            };

            var getJuly = function () {

            };

            var getAugust = function () {

            };

            var getSeptember = function () {

            };

            var getOctober = function () {

            };

            var getNovember = function () {

            };

            var getDecember = function () {

            };

            var barChartData = {
                labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
                datasets: [
                    {
                        fillColor: "rgba(220,220,220,0.5)",
                        strokeColor: "rgba(220,220,220,0.8)",
                        highlightFill: "rgba(220,220,220,0.75)",
                        highlightStroke: "rgba(220,220,220,1)",
                        data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
                    }
                ]

            }
            window.onload = function () {
                var ctx = document.getElementById("canvas").getContext("2d");
                window.myBar = new Chart(ctx).Bar(barChartData, {
                    responsive: true
                });
            }

        </script>

        <script src="assets/js/jquery-1.10.2.js"></script>
        <!-- BOOTSTRAP SCRIPTS -->
        <script src="assets/js/bootstrap.min.js"></script>
        <!-- METISMENU SCRIPTS -->
        <script src="assets/js/jquery.metisMenu.js"></script>
        <!-- MORRIS CHART SCRIPTS -->
        <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
        <script src="assets/js/morris/morris.js"></script>
        <!-- CUSTOM SCRIPTS -->
        <script src="assets/js/custom.js"></script>
        <script src="Chart.js"></script>
        <script src="dist/js/jquery-2.1.0.min.js"></script>
        <script src="dist/js/query.js"></script>
        <script src="dist/js/bootstrap.min.js"></script>



    </body>
</html>
<%}%>
