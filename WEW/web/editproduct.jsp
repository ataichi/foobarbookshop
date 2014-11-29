<%@page import="DAO.Interface.ProductManagerDAOInterface"%>
<%@page import="Beans.MagazineBean"%>
<%@page import="Beans.DVDBean"%>
<%@page import="Beans.BookBean"%>
<%@page import="Beans.AudioCDBean"%>
<%@page import="Beans.ProductBean"%>
<%@page import="DAO.Implementation.ProductManagerDAOImplementation"%>
<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeproduct = (AccountBean) session.getAttribute("homeproduct");
    ProductManagerDAOInterface pdao = new ProductManagerDAOImplementation();

    ProductBean editproduct = (ProductBean) session.getAttribute("editproduct");
    AudioCDBean audiocd = (AudioCDBean) session.getAttribute("editaudio");
    BookBean book = (BookBean) session.getAttribute("editbook");
    DVDBean dvd = (DVDBean) session.getAttribute("editdvd");
    MagazineBean magazine = (MagazineBean) session.getAttribute("editmagazine");

    String prodType = null;
    if (homeproduct.getAccountType().equals("Audio CD Manager")) {
        prodType = "Audio CD";
    } else if (homeproduct.getAccountType().equals("Book Manager")) {
        prodType = "Book";
    } else if (homeproduct.getAccountType().equals("DVD Manager")) {
        prodType = "DVD";
    } else if (homeproduct.getAccountType().equals("Magazine Manager")) {
        prodType = "Magazine";
    }
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

        <title>Edit Account</title>
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
                        <li><a href="customerHOME.jsp"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + homeproduct.getUsername());%> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#"><span class="glyphicon glyphicon-edit"></span>Account</a></li>
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
                        <h3 class="panel-title">Account Information</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" id="productcheck" name="productcheck" action="FinalEditProductServlet" onsubmit="return productCheck(this)" method="post">
                            <div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Title</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='productTitle' name='productTitle' onblur="productTitleCheck()" onfocus='backWhite(this);' value='<% out.println(editproduct.getTitle()); %>'/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Price</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='productPrice' name='productPrice' onblur="productPriceCheck()" onfocus='backWhite(this);' value='<% out.println(editproduct.getPrice()); %>'/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Summary</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='productSummary' name='productSummary' onblur="productSummaryCheck()" onfocus='backWhite(this);' value='<% out.println(editproduct.getSummary()); %>'/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Genre</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='productGenre' name='productGenre' onblur="productGenreCheck()" onfocus='backWhite(this);' value='<% out.println(editproduct.getGenre()); %>'/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Year</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='productYear' name='productYear' onblur="productYearCheck()" onfocus='backWhite(this);' value='<% out.println(editproduct.getYear()); %>'/>       
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Stocks</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='productStocks' name='productStocks' onblur="productStocksCheck()" onfocus='backWhite(this);' value='<% out.println(editproduct.getNumberStocks()); %>'/>
                                    </div>
                                </div>
                                <% if (prodType.equals("Audio CD")) {

                                %>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Artist</label>
                                    <div class="col-sm-3">
                                        <input type ='text' class="form-control" id ='cdArtist' name ='cdArtist' onfocus ='backWhite(this);' value='<% out.println(audiocd.getArtist()); %>'/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Record Company</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='cdRecord' name='cdRecord' onfocus='backWhite(this);' value='<% out.println(audiocd.getRecordCompany()); %>'/>
                                    </div>
                                </div>
                                <% } else if (prodType.equals("Book")) {
                                %>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Author</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='bookAuthor' name='bookAuthor' onfocus='backWhite(this);' value='<% out.println(book.getAuthor()); %>'/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Publisher</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='bookPublisher' name='bookPublisher' onfocus='backWhite(this);' value='<% out.println(book.getPublisher()); %>'/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Date Published</label>
                                    <div class="col-sm-3">
                                        <input type='date' class="form-control" id='bookDatePublished' name='bookDatePublished' onfocus='backWhite(this);' value='<% out.println(1900 + book.getDatePublished().getYear() + "-" + (1 + book.getDatePublished().getMonth()) + "-" + (7 + book.getDatePublished().getDay()));%>'/>
                                    </div>
                                </div>
                                <%
                                } else if (prodType.equals("DVD")) {
                                %>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Director</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='dvdDirector' name='dvdDirector' onfocus='backWhite(this);' value='<% out.println(dvd.getDirector()); %>'/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Actor</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='dvdActor' name='dvdActor' onfocus='backWhite(this);' value='<% out.println(dvd.getMainActors()); %>'/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Producer</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='dvdProducer' name='dvdProducer' onfocus='backWhite(this);' value='<% out.println(dvd.getProductionCompany()); %>'/>
                                    </div>
                                </div>

                                <%
                                } else if (prodType.equals("Magazine")) {
                                %>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Volume No</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='magazineVolume' name='magazineVolume' onfocus='backWhite(this);' value='<% out.println(magazine.getVolumeNo()); %>'/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Issue No</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='magazineIssue' name='magazineIssue' onfocus='backWhite(this);' value='<% out.println(magazine.getIssueNo()); %>'/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Publisher</label>
                                    <div class="col-sm-3">
                                        <input type='text' class="form-control" id='magazinePublisher' name='magazinePublisher' onfocus='backWhite(this);' value='<% out.println(magazine.getPublisher()); %>'/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-lg-4" for="fname">Date Published</label>
                                    <div class="col-sm-3">
                                        <input type='date' class="form-control" id='magazineDate' name='magazineDate' onfocus='backWhite(this);' value='<% out.println(magazine.getDatePublished().getYear() + "-" + magazine.getDatePublished().getMonth() + "-" + magazine.getDatePublished().getDate()); %>'/>
                                    </div>
                                </div>
                                <%
                                    }
                                %>
                                <div class="form-group">
                                    <button class="btn btn-primary btn-lg center-block">Edit Product</button>
                                </div>
                                <div class="form-group">
                                    <a href='productmanagerHOME.jsp'><button class="btn btn-primary btn-lg center-block">Cancel</button></a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="dist/js/jquery-2.1.0.min.js"></script>
        <script src="dist/js/query.js"></script>
        <script src="dist/js/bootstrap.min.js"></script>

    </body>
</html>
