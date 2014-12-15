<%@page import="Beans.CustomerBean"%>
<%@page import="Beans.ReviewBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.ProductBean"%>
<%@page import="Beans.MagazineBean"%>
<%@page import="Beans.DVDBean"%>
<%@page import="Beans.BookBean"%>
<%@page import="Beans.AudioCDBean"%>
<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean account = (AccountBean) session.getAttribute("homeproduct");
    if (account == null) {
        response.sendRedirect("login.jsp");

    } else {
        /*
         ArrayList<ProductBean> productlist = (ArrayList<ProductBean>) session.getAttribute("searchproductlist");
         String prodType = (String) session.getAttribute("prodType");

         ArrayList<AudioCDBean> audiolist = (ArrayList<AudioCDBean>) session.getAttribute("audiolist");
         ArrayList<BookBean> booklist = (ArrayList<BookBean>) session.getAttribute("booklist");
         ArrayList<DVDBean> dvdlist = (ArrayList<DVDBean>) session.getAttribute("dvdlist");
         ArrayList<MagazineBean> magazinelist = (ArrayList<MagazineBean>) session.getAttribute("magazinelist");

         ArrayList<ReviewBean> reviews = (ArrayList<ReviewBean>) session.getAttribute("reviews");

         ArrayList<AccountBean> accountlist = (ArrayList<AccountBean>) session.getAttribute("accountlist");
         ArrayList<CustomerBean> customerlist = (ArrayList<CustomerBean>) session.getAttribute("customerlist");

         String prodType = (String) session.getAttribute("prodType");
         out.println(prodType);

         ProductBean viewproduct = (ProductBean) session.getAttribute("viewproduct");
         out.println(viewproduct.getTitle());

         ArrayList<AccountBean> accountlist = (ArrayList<AccountBean>) session.getAttribute("accountlist");
         out.println(accountlist.size());

         ArrayList<ReviewBean> reviews = (ArrayList<ReviewBean>) session.getAttribute("reviews");
         out.println(reviews.size());

         ArrayList<CustomerBean> customerlist = (ArrayList<CustomerBean>) session.getAttribute("customerlist");
         out.println(customerlist.size());

         AudioCDBean viewaudiocd = (AudioCDBean) session.getAttribute("viewaudiocd");
         out.println(viewaudiocd.getArtist());

         BookBean viewbook = (BookBean) session.getAttribute("viewbook");
         out.println(viewbook.getAuthor());

         DVDBean viewdvd = (DVDBean) session.getAttribute("viewdvd");
         out.println(viewdvd.getDirector());

         MagazineBean viewmagazine = (MagazineBean) session.getAttribute("viewmagazine");
         out.println(viewmagazine.getPublisher());
         */
        String prodType = (String) session.getAttribute("prodType");
//        out.println(prodType);

        ProductBean viewproduct = (ProductBean) session.getAttribute("viewproduct");
//        out.println(viewproduct.getTitle());

        ArrayList<AccountBean> accountlist = (ArrayList<AccountBean>) session.getAttribute("accountlist");
//        out.println(accountlist.size());

        ArrayList<ReviewBean> reviews = (ArrayList<ReviewBean>) session.getAttribute("reviews");
//        out.println(reviews.size());

        ArrayList<CustomerBean> customerlist = (ArrayList<CustomerBean>) session.getAttribute("customerlist");
//        out.println(customerlist.size());

        AudioCDBean viewaudiocd = (AudioCDBean) session.getAttribute("viewaudiocd");
//        out.println(viewaudiocd.getArtist());

        BookBean viewbook = (BookBean) session.getAttribute("viewbook");
//        out.println(viewbook.getAuthor());

        DVDBean viewdvd = (DVDBean) session.getAttribute("viewdvd");
//        out.println(viewdvd.getDirector());

        MagazineBean viewmagazine = (MagazineBean) session.getAttribute("viewmagazine");
//        out.println(viewmagazine.getPublisher());


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

        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <link href="dist/css/morris.css" rel="stylesheet">
        <link href="dist/css/font-awesome.min.css" rel="stylesheet">

        <title>View Product</title>
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
                        <li class="active"><a href="productmanagerHOME.jsp"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + account.getUsername());%> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="productmanagerAccount.jsp"><span class="glyphicon glyphicon-edit"></span> Account</a></li>
                                <li><a href="productmanagerChangePassword.jsp"><span class="glyphicon glyphicon-pencil"></span>Change Password</a></li>
                            </ul>
                        </li>
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

        <div class="container"  style="padding-top: 100px;">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Product Information</h3>
                    </div>
                    <div class="panel-body">
                        <dl class="dl-horizontal">

                            <%

                                out.println("<dt>Title</dt>"
                                        + "<dd>"
                                        + viewproduct.getTitle()
                                        + "</dd>"
                                        + "<dt> Price </dt>"
                                        + "<dd>"
                                        + viewproduct.getPrice()
                                        + "</dd>"
                                        + "<dt> Summary </dt>"
                                        + "<dd>"
                                        + viewproduct.getSummary()
                                        + "</dd>"
                                        + "<dt> Genre </dt>"
                                        + "<dd>"
                                        + viewproduct.getGenre()
                                        + "</dd>"
                                        + "<dt> Year </dt>"
                                        + "<dd>"
                                        + viewproduct.getYear()
                                        + "</dd>"
                                );
                                if (prodType.equals("Audio CD")) {

                                    out.println("<dt>Artist</dt>"
                                            + "<dd>"
                                            + viewaudiocd.getArtist()
                                            + "</dd>"
                                            + "<dt> Record Company</dt>"
                                            + "<dd>" + viewaudiocd.getRecordCompany());
                                    /*
                                     for (int j = 0; j < productlist.size(); j++) {
                                     for (int i = 0; i < audiolist.size(); i++) {
                                     if (productlist.get(j).getProductID() == audiolist.get(i).getAudiocd_productID()) {
                                     out.println("<dt> Title </dt>"
                                     + "<dt> Summary </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getSummary()
                                     + "</dd>"
                                     + "<dt> Genre </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getGenre()
                                     + "</dd>"
                                     + "<dt> Year </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getYear()
                                     + "</dd>"
                                     + "<dt> Stocks </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getNumberStocks()
                                     + "</dd>");
                                     */
                                    /*
                                     out.println("<dt>Artist</dt>"
                                     + "<dd>"
                                     + audiolist.get(i).getArtist()
                                     + "</dd>"
                                     + "<dt> Record Company</dt>"
                                     + "<dd>" + audiolist.get(i).getRecordCompany());
                                     */
                                    /*   }
                                     }
                                     }
                                     */
                                } else if (prodType.equals("Book")) {
                                    out.println("<dt> Author </dt>"
                                            + "<dd>"
                                            + viewbook.getAuthor()
                                            + "</dd>"
                                            + "<dt> Publisher </dt>"
                                            + "<dd>"
                                            + viewbook.getPublisher()
                                            + "</dd>"
                                            + "<dt> Date Published </dt>"
                                            + "<dd>"
                                            + viewbook.getDatePublished()
                                            + "</dd>"
                                    );
                                    /*
                                     for (int j = 0; j < productlist.size(); j++) {
                                     for (int i = 0; i < booklist.size(); i++) {
                                     if (productlist.get(j).getProductID() == booklist.get(i).getBook_productID()) {
                                     out.println("<dt> Title </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getTitle()
                                     + "</dd>"
                                     + "<dt> Price </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getPrice()
                                     + "</dd>"
                                     + "<dt> Summary </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getSummary()
                                     + "</dd>"
                                     + "<dt> Genre </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getGenre()
                                     + "</dd>"
                                     + "<dt> Year </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getYear()
                                     + "</dd>"
                                     + "<dt> Stocks </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getNumberStocks()
                                     + "</dd>");
                                            
                                     out
                                     .println("<dt>Author</dt>"
                                     + "<dd >"
                                     + booklist.get(i).getAuthor()
                                     + "</dd>"
                                     + "<dt> Date Published</dt>"
                                     + "<dd>" + booklist.get(i).getDatePublished()
                                     + "<dt> Publisher </dt>"
                                     + "<dd>"
                                     + booklist.get(i).getPublisher()
                                     + "</dd>"
                                     + "<dt> Date Published </dt>"
                                     + "<dd>"
                                     + booklist.get(i).getDatePublished()
                                     + "</dd>"
                                     );
                                            
                                     }
                                     }
                                     }

                                     */

                                } else if (prodType.equals("DVD")) {
                                    out.println("<dt>Actor: </dt>"
                                            + "<dd>"
                                            + viewdvd.getMainActors()
                                            + "</dd>"
                                            + "<dt> Director</dt>"
                                            + "<dd>" + viewdvd.getDirector()
                                            + "</dd>"
                                            + "<dt> Production Company: </dt>"
                                            + "<dd>"
                                            + viewdvd.getProductionCompany()
                                            + "</dd>"
                                    );
                                    /*
                                     for (int j = 0; j < productlist.size(); j++) {
                                     for (int i = 0; i < dvdlist.size(); i++) {
                                     if (productlist.get(j).getProductID() == dvdlist.get(i).getDvd_productID()) {
                                     out.println("<dt> Title </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getTitle()
                                     + "</dd>"
                                     + "<dt> Price </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getPrice()
                                     + "</dd>"
                                     + "<dt> Summary </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getSummary()
                                     + "</dd>"
                                     + "<dt> Genre </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getGenre()
                                     + "</dd>"
                                     + "<dt> Year </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getYear()
                                     + "</dd>"
                                     + "<dt> Stocks </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getNumberStocks()
                                     + "</dd>");
                                     out.println("<dt>Actor: </dt>"
                                     + "<dd>"
                                     + dvdlist.get(i).getMainActors()
                                     + "</dd>"
                                     + "<dt> Director</dt>"
                                     + "<dd>" + dvdlist.get(i).getDirector()
                                     + "</dd>"
                                     + "<dt> Production Company: </dt>"
                                     + "<dd>"
                                     + dvdlist.get(i).getProductionCompany()
                                     + "</dd>"
                                     );

                                     }
                                     }
                                     }
                                     */
                                } else if (prodType.equals("Magazine")) {
                                    out.println("<dt>Issue No </dt>"
                                            + "<dd>"
                                            + viewmagazine.getIssueNo()
                                            + "</dd>"
                                            + "<dt> Volume No </dt>"
                                            + "<dd>" + viewmagazine.getVolumeNo()
                                            + "</dd>"
                                            + "<dt> Date Pubslihed </dt>"
                                            + "<dd>"
                                            + viewmagazine.getDatePublished()
                                            + "</dd>"
                                            + "<dt> Publisher </dt>"
                                            + "<dd>"
                                            + viewmagazine.getPublisher()
                                            + "</dd>"
                                    );
                                    /*
                                     for (int j = 0; j < productlist.size(); j++) {
                                     for (int i = 0; i < magazinelist.size(); i++) {
                                     if (productlist.get(j).getProductID() == magazinelist.get(i).getMagazine_productID()) {
                                     out.println("<dt> Title </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getTitle()
                                     + "</dd>"
                                     + "<dt> Price </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getPrice()
                                     + "</dd>"
                                     + "<dt> Summary </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getSummary()
                                     + "</dd>"
                                     + "<dt> Genre </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getGenre()
                                     + "</dd>"
                                     + "<dt> Year </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getYear()
                                     + "</dd>"
                                     + "<dt> Stocks </dt>"
                                     + "<dd>"
                                     + productlist.get(j).getNumberStocks()
                                     + "</dd>");

                                     out.println("<dt>Issue No </dt>"
                                     + "<dd>"
                                     + magazinelist.get(i).getIssueNo()
                                     + "</dd>"
                                     + "<dt> Volume No </dt>"
                                     + "<dd>" + magazinelist.get(i).getVolumeNo()
                                     + "</dd>"
                                     + "<dt> Date Pubslihed </dt>"
                                     + "<dd>"
                                     + magazinelist.get(i).getDatePublished()
                                     + "</dd>"
                                     + "<dt> Publisher </dt>"
                                     + "<dd>"
                                     + magazinelist.get(i).getPublisher()
                                     + "</dd>"
                                     );
                                     }
                                     }
                                     }
                                     */
                                }

                            %>

                        </dl>
                        <a href="customerHOME.jsp"><button class="btn btn-primary btn-lg center-block">Back</button></a>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Reviews</h3>
                    </div>
                    <div class="panel-body">
                        <%                            for (int i = 0; i < reviews.size(); i++) {
                                for (int j = 0; j < customerlist.size(); j++) {
                                    if (reviews.get(i).getReview_customerID() == customerlist.get(j).getCustomerID()) {
                                        for (int k = 0; k < accountlist.size(); k++) {
                                            if (accountlist.get(k).getAccountID() == customerlist.get(j).getCustomer_accountID() &&
                                                   reviews.get(i).getReview_customerID() == customerlist.get(j).getCustomerID() ) {
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