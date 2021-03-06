
<%@page import="DAO.Implementation.ProductDAOImplementation"%>
<%@page import="Beans.ProductBean"%>
<%@page import="Beans.ProductOrderBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.ShoppingCartBean"%>
<%@page import="Beans.*"%>
<%@page import="Beans.CustomerBean"%>
<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
    if (homeuser == null) {
        response.sendRedirect("login.jsp");
    } else {
        CustomerBean tempcustomer = (CustomerBean) session.getAttribute("tempcustomer");
        ShoppingCartBean shoppingcart = (ShoppingCartBean) session.getAttribute("shoppingcart");
        ArrayList<ProductOrderBean> temporder = (ArrayList<ProductOrderBean>) session.getAttribute("temporder");
        ArrayList<ProductBean> tempproductlist = (ArrayList<ProductBean>) session.getAttribute("tempproductlist");

        ArrayList<ProductBean> productaudiolist = (ArrayList<ProductBean>) session.getAttribute("productaudiolist");
        ArrayList<ProductBean> productbooklist = (ArrayList<ProductBean>) session.getAttribute("productbooklist");
        ArrayList<ProductBean> productdvdlist = (ArrayList<ProductBean>) session.getAttribute("productdvdlist");
        ArrayList<ProductBean> productmagazinelist = (ArrayList<ProductBean>) session.getAttribute("productmagazinelist");


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

        <title>Customer Home Page</title>
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
                        <li><a href="customerHOME.jsp"><span class="glyphicon glyphicon-home active"></span> Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + homeuser.getUsername());%> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="customerAccount.jsp"><span class="glyphicon glyphicon-edit"></span> Account</a></li>
                                <li><a href="customerBilling.jsp"><span class="glyphicon glyphicon-edit"></span> Address</a></li>
                                <li><a href='customerviewreviews.jsp'><span class="glyphicon glyphicon-edit"></span> Reviews</a></li>
                                <li><a href="customerChangePassword.jsp"><span class="glyphicon glyphicon-pencil"></span> Change Password</a></li>
                                <li><span class="glyphicon glyphicon-usd"></span><form action='ViewCustomerTransactions'><input type='submit' value=' Transactions' style='background-color: transparent; border: none'/></form></li>
                            </ul>
                        </li>
                        <!--<li><span class="glyphicon glyphicon-log-out"></span><form action="LogoutServlet"><input type="submit" value="Log out" style='border: none'/></form></li>-->
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
                    <div class="bs-docs-section">
                        <div class="bs-example bs-example-tabs" role="tabpanel">
                            <ul id="myTab" class="nav nav-tabs" role="tablist">
                                <li role="presentation" class="active"><a href="#viewbook" id="book-tab" role="tab" data-toggle="tab" aria-controls="viewbook" aria-expanded="true"><img src="./images/book-small-icon.png" style="width: 50px; length:50px;" class="img-responsive"/></a></li>
                                <li role="presentation"><a href="#viewmag" role="tab" id="mag-tab" data-toggle="tab" aria-controls="viewmag"><img src="./images/magazine-small-icon.png" style="width: 50px; length:50px;" class="img-responsive"/></a></li>
                                <li role="presentation"><a href="#viewcd" role="tab" id="cd-tab" data-toggle="tab" aria-controls="viewcd"><img src="./images/cd-small-icon.png" style="width: 50px; length:50px;" class="img-responsive"/></a></li>
                                <li role="presentation"><a href="#viewdvd" role="tab" id="dvd-tab" data-toggle="tab" aria-controls="viewdvd"><img src="./images/dvd-small-icon.png" style="width: 50px; length:50px;" class="img-responsive"/></a></li>
                            </ul>
                            <div id="myTabContent" class="tab-content">
                                <div role="tabpanel" class="tab-pane fade in well active" id="viewbook" aria-labelledBy="book-tab" style='height: 500px;'>
                                    <% int a;
                                        for (a = 0; a < productbooklist.size(); a++) {
                                    %>
                                    <div class="col-md-3">
                                        <center>
                                            <div>
                                                <strong> 
                                                    Title: <%out.println(productbooklist.get(a).getTitle());%>
                                                </strong>
                                            </div>
                                            <div>
                                                Summary: <%out.println(productbooklist.get(a).getSummary());%>
                                            </div>
                                            <div>
                                                Price: <%out.println(productbooklist.get(a).getPrice()); %>
                                            </div>
                                            <form action="ShoppingCart" id="<%out.println(productbooklist.get(a).getProductID());%>" method="post">
                                                <input type="hidden" id="product" name="product" value=<%out.println(productbooklist.get(a).getProductID());%>/>
                                                <input type="submit" value="View Details" name="action" style="border-color: transparent; background-color:transparent"/>                                          
                                                <%
                                                    if (productbooklist.get(a).getNumberStocks() > 0) {
                                                %>
                                                <input type="number" name="qty" id="qty" min=1 max=<%out.println(productbooklist.get(a).getNumberStocks());%> value=1/>
                                                <input type="submit" value="Add to Cart" nam="action" style="border-color: transparent; background-color:transparent"/>
                                            </form>
                                        </center>
                                    </div>
                                    <%
                                    } else {
                                    %>

                                    <tr>
                                        <td>
                                            <strong>
                                                This product is unavailable.
                                            </strong>
                                        </td>
                                    </tr>
                                </div>
                                <%
                                        }
                                    }
                                %>
                            </div>
                            <div role="tabpanel" class="tab-pane fade in well " id="viewmag" aria-labelledBy="mag-tab" style='height: 500px;'>
                                <% int b;
                                    for (b = 0; b < productmagazinelist.size(); b++) {
                                %>
                                <div class="col-md-3">
                                    <center>
                                        <div>
                                            <strong>
                                                Title: <%out.println(productmagazinelist.get(b).getTitle());%>
                                            </strong>
                                        </div>
                                        <div>
                                            Summary: <%out.println(productmagazinelist.get(b).getSummary());%>
                                        </div>
                                        <div>
                                            Price: <%out.println(productmagazinelist.get(b).getPrice());%>
                                        </div>
                                        <form action="ShoppingCart" id="<%out.println(productmagazinelist.get(b).getProductID());%>" method="post"
                                              <input type="hidden" id="product" name="product" value=<%out.println(productmagazinelist.get(b).getProductID());%>/>
                                            <input type="submit" value="View Details" name="action" style="border-color: transparent; background-color: transparent" />
                                            <%
                                                if (productmagazinelist.get(b).getNumberStocks() > 0) {
                                            %>
                                            <input type="number" name="qty" id="qty" min=1 max=<%out.println(productmagazinelist.get(b).getNumberStocks());%> value=1/>
                                            <input type="submit" value="Add to Cart" name="action" style="border-color: transparent; background-color:transparent"/
                                                   </center>
                                            </div>
                                        </form>
                                        <%
                                        } else {
                                        %>
                                        <tr>
                                            <td>
                                                <strong>
                                                    This product is unavailable.
                                                </strong>
                                            </td>
                                        </tr>
                                        <%
                                                }
                                            }
                                        %>

                                </div>
                                <div role="tabpanel" class="tab-pane fade in well " id="viewcd" aria-labelledBy="cd-tab" style='height: 500px;'>
                                    <% int c;
                                        for (c = 0; c < productaudiolist.size(); c++) {
                                    %>
                                    <div class='col-md-3'>
                                        <center>
                                            <div>
                                                <strong>
                                                    Title: <%out.println(productaudiolist.get(c).getTitle());%>
                                                </strong>
                                            </div>
                                            <div>
                                                <%out.println(productaudiolist.get(c).getSummary());%>
                                            </div>
                                            <div>
                                                Price: <%out.println(productaudiolist.get(c).getPrice());%> 
                                            </div>
                                            <form action="ShoppingCart" id="<%out.println(productaudiolist.get(c).getProductID());%>" method="post">
                                                <input type="hidden" id="product" name="product" value=<%out.println(productaudiolist.get(c).getProductID());%>/>
                                                <input type="submit" value="View Details" name="action" style="border-color: transparent; background-color: transparent" />


                                                <%
                                                    if (productaudiolist.get(c).getNumberStocks() > 0) {
                                                %>
                                                <input type="number" name="qty" id="qty" min=1 max=<%out.println(productaudiolist.get(c).getNumberStocks());%> value=1/>
                                                <input type="submit" value="Add to Cart" name="action" style="border-color: transparent; background-color: transparent"/>
                                            </form>
                                        </center>
                                    </div>
                                    <%
                                    } else {
                                    %>
                                    <tr>
                                        <td>
                                            <strong>
                                                This product is unavailable.
                                            </strong>
                                        </td>
                                    </tr>
                                    <%
                                            }
                                        }
                                    %>

                                </div>
                                <div role="tabpanel" class="tab-pane fade in well " id="viewdvd" aria-labelledBy="dvd-tab" style='height: 500px;'>
                                    <% int d;
                                        for (d = 0; d < productdvdlist.size(); d++) {
                                    %>
                                    <div class="col-md-3">
                                        <center>
                                            <div>
                                                <strong>
                                                    Title: <%out.println(productdvdlist.get(d).getTitle());%>
                                                </strong>
                                            </div>
                                            <div>
                                                Summary: <% out.println(productdvdlist.get(d).getSummary()); %>
                                            </div>
                                            <div>
                                                Price: <%out.println(productdvdlist.get(d).getPrice());%>
                                            </div>
                                            <form action="ShoppingCart" id="<%out.println(productdvdlist.get(d).getProductID());%>" method="post">
                                                <input type="hidden" id="product" name="product" value=<%out.println(productdvdlist.get(d).getProductID());%> />
                                                <input type="submit" value="View Details" name="action" style="border-color: transparent; background-color: transparent" />

                                                <%
                                                    if (productdvdlist.get(d).getNumberStocks() > 0) {
                                                %>
                                                <input type="number" name="qty" id="qty" min=1 max=<%out.println(productdvdlist.get(d).getNumberStocks());%> value=1 />
                                                <input type="submit" value="Add to Cart" name="action" style="border-color: transparent; background-color: transparent"/>
                                            </form>
                                        </center>
                                    </div>
                                    <%
                                    } else {
                                    %>
                                    <tr>
                                        <td>
                                            <strong>
                                                This product is unavailable.
                                            </strong>
                                        </td>
                                    </tr>
                                </div><%
                                        }
                                    }
                                %>
                            </div>
                        </div>
                    </div><!-- /example -->
                </div>
            </div>              


            <div class="col-md-4" style="padding-left: 20px; padding-top: 20px;">
                <div class="pull-right affix">
                    <div class="panel panel-default" style='height: 550px; width: 500px; max-height: 10;overflow-y: scroll;'>
                        <div class="panel-heading">
                            <h3 class="panel-title">Shopping Cart</h3>
                        </div>
                        <div class="panel-body"> 
                            <%
                                // insert shopping cart here!
                                if (temporder.size() == 0) {
                            %>
                            <p> Shopping cart empty.</p>
                            <%
                            } else {
                            %>
                            <form action="ShoppingCart" method="post">

                                <input type="submit" value="Buy" name="action">

                                <%
                                    for (int i = 0; i < temporder.size(); i++) { //gets total order
                                        for (int j = 0; j < tempproductlist.size(); j++) {
                                            if (temporder.get(i).getProductorder_productID() == tempproductlist.get(j).getProductID()) {
                                %>

                                <table>

                                    <tr>
                                        <td>
                                            Title: <%out.println(tempproductlist.get(j).getTitle());%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Price: <%out.println(tempproductlist.get(j).getPrice());%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Qty: <input type="number" name="qty" id="qty" min=1 max=<%out.println(tempproductlist.get(j).getNumberStocks());%> value=<%out.println(temporder.get(i).getQuantity());%>/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Total: <%out.println(temporder.get(i).getPrice());%>
                                        </td>
                                    </tr>
                                    <tr>
                                    <input type="hidden" value=<%out.println(tempproductlist.get(j).getProductID());%> name="product"/>
                                    </tr>
                                    <tr>
                                    <input type="submit" value="Save" name="action"/>
                                    </tr>
                                    <tr>
                                    <input type="submit" value="Remove" name="action" />
                                    </tr>
                                </table>
                            </form>
                            <%
                                            }
                                        }
                                    }
                                }
                            %>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="dist/js/jquery-2.1.0.min.js"></script>
    <script src="dist/js/query.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
    <script>
            $(document).ready(function () {
                $("#qty").click(function () {
                    var $n = $("#final");
                    $n.val(Number($n.val()) + 1); // Have to type the .val() response to a number instead of a string.
                });
            });


    </script>
</body>

</html>
<%}%>