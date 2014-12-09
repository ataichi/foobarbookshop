<%@page import="DAO.Implementation.ProductManagerDAOImplementation"%>
<%@page import="DAO.Interface.ProductManagerDAOInterface"%>
<%@page import="Beans.AccountBean"%>
<%
    AccountBean homeproduct = (AccountBean) session.getAttribute("homeproduct");
    if (homeproduct == null) {
        response.sendRedirect("login.jsp");
    } else {
        String accountType = homeproduct.getAccountType();
        String productType = null;
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            response.addHeader("X-FRAME-OPTIONS", "DENY");
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
                        <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + homeproduct.getUsername());%> <span class="caret"></span></a>
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
                                        <label class="control-label col-lg-4" for="fname">Title</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='productTitle' name='productTitle' onblur="productTitleCheck()" onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Price</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='productPrice' name='productPrice' onblur="productPriceCheck()" onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Summary</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='productSummary' name='productSummary' onblur="productSummaryCheck()" onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Genre</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='productGenre' name='productGenre' onblur="productGenreCheck()" onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Year</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='productYear' name='productYear' onblur="productYearCheck()" onfocus='backWhite(this);'/>       
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Stocks</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='productStocks' name='productStocks' onblur="productStocksCheck()" onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <%                                if (productType.equals("Audio CD")) {

                                    %>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Artist</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type ='text' id ='cdArtist' name ='cdArtist' onfocus ='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Record Company</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='cdRecord' name='cdRecord' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <%                            } else if (productType.equals("Book")) {
                                    %>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Author</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='bookAuthor' name='bookAuthor' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Publisher</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='bookPublisher' name='bookPublisher' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Date Published</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='date' id='bookDatePublished' name='bookDatePublished' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <%
                                    } else if (productType.equals("DVD")) {
                                    %>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Director</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='dvdDirector' name='dvdDirector' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Actor</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='dvdActor' name='dvdActor' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Producer</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='dvdProducer' name='dvdProducer' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>

                                    <%
                                    } else if (productType.equals("Magazine")) {
                                    %>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Volume No</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='magazineVolume' name='magazineVolume' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Issue No</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='magazineIssue' name='magazineIssue' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Publisher</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='text' id='magazinePublisher' name='magazinePublisher' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-lg-4" for="fname">Date Published</label>
                                        <div class="col-sm-3">
                                            <input class='form-control' type='date' id='magazineDate' name='magazineDate' onfocus='backWhite(this);'/>
                                        </div>
                                    </div>
                                    <%
                                        }
                                    %>
                                    <div class="form-group">
                                        <button class="btn btn-primary btn-lg center-block">Add Product</button>
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
