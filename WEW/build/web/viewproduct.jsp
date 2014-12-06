<%@page import="Beans.ProductBean"%>
<%@page import="Beans.MagazineBean"%>
<%@page import="Beans.DVDBean"%>
<%@page import="Beans.BookBean"%>
<%@page import="Beans.AudioCDBean"%>
<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean account = (AccountBean) session.getAttribute("homeuser");
    ProductBean productBean = (ProductBean) session.getAttribute("viewproduct");

    AudioCDBean audiocdbean = (AudioCDBean) session.getAttribute("viewaudiocd");
    BookBean bookbean = (BookBean) session.getAttribute("viewbook");
    DVDBean dvdbean = (DVDBean) session.getAttribute("viewdvd");
    MagazineBean magbean = (MagazineBean) session.getAttribute("viewmagazine");
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
                                <li><a href="#"><span class="glyphicon glyphicon-pencil"></span>Change Password</a></li>
                            </ul>
                        </li>
                        <li><a href="homepage.jsp"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
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

                                    out.println("<dt>Artist</dt>"
                                            + "<dd>"
                                            + audiocdbean.getArtist()
                                            + "</dd>"
                                            + "<dt> Record Company</dt>"
                                            + "<dd>" + audiocdbean.getRecordCompany() + "</dd>");

                                } else if (productBean.getType().equals("Book")) {
                                    out.println("<dt>Author</dt>"
                                            + "<dd>"
                                            + bookbean.getAuthor()
                                            + "</dd>"
                                            + "<dt> Publisher</dt>"
                                            + "<dd>" + bookbean.getPublisher() + "</dd>"
                                            + "<dt>Date Published</dt>"
                                            + "<dd>" + bookbean.getDatePublished() + "</dd>");

                                } else if (productBean.getType().equals("DVD")) {
                                    out.println("<dt>Director</dt>"
                                            + "<dd>" + dvdbean.getDirector() + "</dd>"
                                            + "<dt> Actor</dt>"
                                            + "<dd>" + dvdbean.getMainActors() + "</dd>"
                                            + "<dt>Prooducer</dt>"
                                            + "<dd>" + dvdbean.getProductionCompany() + "</dd>");
                                } else if (productBean.getType().equals("Magazine")) {
                                    out.println("<dt> Volume No</dt>"
                                            + "<dd>" + magbean.getVolumeNo() + "</dd>"
                                            + "<dt> Issue No </dt>"
                                            + "<dd>" + magbean.getIssueNo() + "</dd>"
                                            + "<dt>Publisher</dt>"
                                            + "<dd>" + magbean.getPublisher() + "</dd>"
                                            + "<dt>Date Published</dt>"
                                            + "<dd>" + magbean.getDatePublished() + "</dd>"
                                    );
                                }
                            %>

                        </dl>
                        <a href="productmanagerHOME.jsp"><button>Back</button></a>
                    </div>
                </div>
            </div>
        </div>   

        <script src="dist/js/jquery-2.1.0.min.js"></script>
        <script src="dist/js/query.js"></script>
        <script src="dist/js/bootstrap.min.js"></script>
    </body>
</html>
