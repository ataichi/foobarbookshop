<%@page import="Beans.ReviewBean"%>
<%@page import="Beans.CustomerBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.MagazineBean"%>
%@page import="Beans.MagazineBean"%>
<%@page import="DAO.Implementation.MagazineManagerDAOImplementation"%>
<%@page import="Beans.DVDBean"%>
<%@page import="DAO.Implementation.DVDManagerDAOImplementation"%>
<%@page import="Beans.BookBean"%>
<%@page import="DAO.Implementation.BookManagerDAOImplementation"%>
<%@page import="Beans.AudioCDBean"%>
<%@page import="DAO.Implementation.AudioCDManagerDAOImplementation"%>
<%@page import="DAO.Implementation.ProductDAOImplementation"%>
<%@page import="Beans.ProductBean"%>
<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
    if (homeuser == null) {
        response.sendRedirect("login.jsp");
    } else {
        ProductBean productBean = (ProductBean) session.getAttribute("viewproduct");
        String prodType = (String) session.getAttribute("prodType");
        ArrayList<AccountBean> accountlist = (ArrayList<AccountBean>) session.getAttribute("accountlist");
        ArrayList<ReviewBean> reviews = (ArrayList<ReviewBean>) session.getAttribute("reviews");
        ArrayList<CustomerBean> customerlist = (ArrayList<CustomerBean>) session.getAttribute("customerlist");
        AudioCDBean viewaudiocd = (AudioCDBean) session.getAttribute("viewaudiocd");
        BookBean viewbook = (BookBean) session.getAttribute("viewbook");
        DVDBean viewdvd = (DVDBean) session.getAttribute("viewdvd");
        MagazineBean viewmagazine = (MagazineBean) session.getAttribute("viewmagazine");


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
        <title>View Customer Product</title>
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
                                <li><span class="glyphicon glyphicon-edit"></span><form action='ViewCustomerReview'><input type='submit' value='View Review' style='background-color: transparent; border:none'/></form></li>
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

        <div class="container"  style="padding-top: 100px;">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Product Information</h3>
                    </div>
                    <div class="panel-body">
                        <dl class="dl-horizontal">
                            <dt>Title</dt>
                            <dd><% out.println(productBean.getTitle()); %></dd>
                            <dt>Price</dt>
                            <dd><% out.println(productBean.getPrice()); %></dd>
                            <dt>Summary</dt>
                            <dd><% out.println(productBean.getSummary()); %></dd>
                            <dt>Genre</dt>
                            <dd><% out.println(productBean.getGenre()); %></dd>
                            <dt>Year</dt>
                            <dd><% out.println(productBean.getYear()); %></dd>
                            <dt>Stocks</dt>
                            <dd><% out.println(productBean.getNumberStocks()); %></dd>
                            <% if (productBean.getType().equals("Audio CD")) {

                            %>

                            <dt>Artist</dt>
                            <dd><% out.println(viewaudiocd.getArtist()); %></dd>
                            <dt>Record Company</dt>
                            <dd><% out.println(viewaudiocd.getRecordCompany()); %></dd>
                            <% } else if (productBean.getType().equals("Book")) {
                            %>
                            <dt>Author</dt>
                            <dd><% out.println(viewbook.getAuthor()); %></dd>
                            <dt>Publisher</dt>
                            <dd><% out.println(viewbook.getPublisher()); %></dd>
                            <dt>Date Published</dt>
                            <dd><% out.println(viewbook.getDatePublished()); %></dd>
                            <%
                            } else if (productBean.getType().equals("DVD")) {
                            %>
                            <dt>Director</dt>
                            <dd><% out.println(viewdvd.getDirector()); %></dd>
                            <dt>Actor</dt>
                            <dd><% out.println(viewdvd.getMainActors()); %></dd>
                            <dt>Producer</dt>
                            <dd><% out.println(viewdvd.getProductionCompany()); %></dd>
                            <%
                            } else if (productBean.getType().equals("Magazine")) {
                            %>
                            <dt>Volume No</dt>
                            <dd><% out.println(viewmagazine.getVolumeNo()); %></dd>
                            <dt>Issue No</dt>
                            <dd><% out.println(viewmagazine.getIssueNo()); %></dd>
                            <dt>Publisher</dt>
                            <dd><% out.println(viewmagazine.getPublisher()); %></dd>
                            <dt>Date Published</dt>
                            <dd><% out.println(viewmagazine.getDatePublished()); %></dd>
                            <%
                                }
                            %>
                        </dl>

                        <dl class="dl-horizontal">
                            <dt>Reviews</dt>
                            <dd>

                                <%                            for (int i = 0; i < reviews.size(); i++) {
                                        for (int j = 0; j < customerlist.size(); j++) {
                                            if (reviews.get(i).getReview_customerID() == customerlist.get(j).getCustomerID()) {
                                                for (int k = 0; k < accountlist.size(); k++) {
                                                    if (accountlist.get(k).getAccountID() == customerlist.get(j).getCustomer_accountID()) {
                                                        out.println("<div><p>" + accountlist.get(k).getFirstName() + " " + accountlist.get(k).getLastName()
                                                                + ": " + reviews.get(i).getReview() + "</p></div>");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                    }
                                %>
                            </dd>
                        </dl>
                        <dl class="horizontal">
                            <dt><a href="customerHOME.jsp"><button class="btn center-block">Back</button></a></dt>
                            <dd></dd>
                        </dl>
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