<%@page import="DAO.Implementation.ProductManagerDAOImplementation"%>
<%@page import="DAO.Interface.ProductManagerDAOInterface"%>
<%@page import="Beans.AccountBean"%>
<%
    String accountType = null;
    String productType = null;
    AccountBean homeproduct = (AccountBean) session.getAttribute("homeproduct");
    if (homeproduct == null) {
        response.sendRedirect("login.jsp");
    } else {
        accountType = homeproduct.getAccountType();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            response.addHeader("X-FRAME-OPTIONS", "DENY");
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
        <script src="js/productcheck.js" type="text/javascript"></script>

        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <link href="dist/css/morris.css" rel="stylesheet">
        <link href="dist/css/font-awesome.min.css" rel="stylesheet">

        <title>Add Product</title>
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
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + homeproduct.getUsername());%> <span class="caret"></span></a>
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

        <div class="container-fluid" style="padding-top: 100px;">
            <div class="row">
                <div class="col-sm-9 col-md-offset-2 main">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <% if (accountType.equals("Audio CD Manager")) {
                                    productType = "Audio CD";
                                } else if (accountType.equals("Book Manager")) {
                                    productType = "Book";
                                } else if (accountType.equals("DVD Manager")) {
                                    productType = "DVD";
                                } else if (accountType.equals("Magazine Manager")) {
                                    productType = "Magazine";
                                }

                            %>
                            <h3 class="panel-title">Add <% out.println(productType); %></h3>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" name="productcheck" id="productcheck" action='AddProductServlet' onsubmit="return productcheck(this)"  method="post">
                                <div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="productTitle">Title</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='productTitle' name='productTitle' onblur="productTitleCheck()" onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="productPrice">Price</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='productPrice' name='productPrice' onblur="productPriceCheck()" onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="productSummary">Summary</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='productSummary' name='productSummary' onblur="productSummaryCheck()" onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="productGenre">Genre</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='productGenre' name='productGenre' onblur="productGenreCheck()" onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="productYear">Year</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='productYear' name='productYear' onblur="productYearCheck()" onfocus='backWhite(this);'/>       
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="productStocks">Stocks</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='productStocks' name='productStocks' onblur="productStocksCheck()" onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <% if (productType.equals("Audio CD")) {

                                    %>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="cdArtist">Artist</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type ='text' id ='cdArtist' name ='cdArtist' onfocus ='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="cdRecord">Record Company</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='cdRecord' name='cdRecord' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <%  } else if (productType.equals("Book")) {
                                    %>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="bookAuthor">Author</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='bookAuthor' name='bookAuthor' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="bookPublisher">Publisher</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='bookPublisher' name='bookPublisher' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="bookDatePublished">Date Published(yyyy-mm-dd)</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='date' id='bookDatePublished' name='bookDatePublished' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <%
                                    } else if (productType.equals("DVD")) {
                                    %>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="dvdDirector">Director</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='dvdDirector' name='dvdDirector' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="dvdActor">Actor</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='dvdActor' name='dvdActor' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="dvdProducer">Producer</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='dvdProducer' name='dvdProducer' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>

                                    <%
                                    } else if (productType.equals("Magazine")) {
                                    %>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="magazineVolume">Volume No</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='magazineVolume' name='magazineVolume' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="magazineIssue">Issue No</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='magazineIssue' name='magazineIssue' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="magazinePublisher">Publisher</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='magazinePublisher' name='magazinePublisher' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="magazineDate">Date Published(yyyy-mm-dd)</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='date' id='magazineDate' name='magazineDate' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <%
                                        }
                                    %>
                                    <div class="form-group">
                                        <button type='submit' class="btn btn-primary btn-lg center-block">Add Product</button>
                                    </div>
                                </div>
                            </form>
                            <div class="form-group">
                                <a href='productmanagerHOME.jsp'><button class="btn btn-primary btn-lg center-block">Cancel</button></a>
                            </div>
                        </div>
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
