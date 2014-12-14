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

        ArrayList<ProductBean> productsbought = (ArrayList<ProductBean>) session.getAttribute("productsbought");
        ArrayList<ReviewBean> reviewlist = (ArrayList<ReviewBean>) session.getAttribute("reviewlist");

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

        <title>Customer Review Page</title>
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
                                <li><a href='customerviewreviews.jsp'><span class="glyphicon glyphicon-edit"></span> Reviews</a></li>
                                <li><a href="customerChangePassword.jsp"><span class="glyphicon glyphicon-pencil"></span> Change Password</a></li>
                                <li><span class="glyphicon glyphicon-usd"></span><form action='ViewCustomerTransactions'><input type='submit' value=' Transactions' style='background-color: transparent; border: none'/></form></li>
                            </ul>
                        </li>
                        <li><form action="LogoutServlet"><span class="glyphicon glyphicon-log-out"></span><input type="submit" value="Log out" style='background-color: transparent; border:none'/></form></li>
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
        <div class="container-fluid" style="padding-top: 100px;">
            <div class="row">
                <div class="col-sm-9 col-sm-offset-2 col-md-10 col-md-offset-1 main">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Review</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    int i;
                                    for (i = 0; i < productsbought.size(); i++) {
                                        for (int j = 0; j < reviewlist.size(); j++) {
                                            if (reviewlist.get(j).getReview_productID() == productsbought.get(i).getProductID()) {
                                %>
                                <tr>
                                    <td>
                                        <%out.println(productsbought.get(i).getTitle());%>
                                    </td>
                                    <td>
                                        <%out.println(reviewlist.get(j).getReview());%>
                                    </td>
                                    <td>

                                        <form method='post'  action='DeleteReviewServlet'>
                                            <input type='submit' id='submit' value='Delete' name='action' style='border-color: transparent; background-color: transparent'/>
                                            <input type='hidden' name='reviewid' value=<%out.println(reviewlist.get(j).getReviewID());%>>
                                        </form>
                                    </td>
                                    <td>
                                        <form action='EditReviewServlet'>
                                            <input type='submit' id='submit' value='Edit' name='action' style='border-color: transparent; background-color: transparent'/>
                                            <input type='hidden' name='reviewid' value=<%out.println(reviewlist.get(j).getReviewID());%>>
                                        </form>
                                    </td>
                                </tr>



                                <%
                                } else { // wala [a review for this product
                                %>
                                <tr>
                                    <td>
                                        <strong>No review for this product yet.</strong>
                                        <form action='WriteReviewServlet'>
                                            <input type='text' name='review'/>
                                            <input type='hidden' name='id' value='<%out.println(productsbought.get(i).getProductID());%>'/>
                                            <input type='submit' value='Write Review'/>
                                        </form>
                                    </td>
                                </tr>
                                <%
                                            }
                                        }
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
        <script>
            $(document).ready(function() {
                $("#qty").click(function() {
                    var $n = $("#final");
                    $n.val(Number($n.val()) + 1); // Have to type the .val() response to a number instead of a string.
                });
            });
        </script>
    </body>

</html>
<%}%>
