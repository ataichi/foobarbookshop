<%-- 
    Document   : viewproduct
    Created on : Nov 23, 2014, 12:31:39 AM
    Author     : Danica
--%>

<%@page import="Beans.ProductBean"%>
<%@page import="Beans.MagazineBean"%>
<%@page import="DAO.Implementation.MagazineDAOImplementation"%>
<%@page import="Beans.DVDBean"%>
<%@page import="DAO.Implementation.DVDDAOImplementation"%>
<%@page import="Beans.BookBean"%>
<%@page import="DAO.Implementation.BookDAOImplementation"%>
<%@page import="Beans.AudioCDBean"%>
<%@page import="DAO.Implementation.AudioCDDAOImplementation"%>
<%@page import="DAO.Implementation.ProductDAOImplementation"%>
<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean account = (AccountBean) session.getAttribute("homeproduct");
    ProductBean productBean = (ProductBean) session.getAttribute("viewproduct");

    ProductDAOImplementation pdao = new ProductDAOImplementation();
    AudioCDDAOImplementation audiocddao = new AudioCDDAOImplementation();
    AudioCDBean audiocdbean = new AudioCDBean();
    BookDAOImplementation bookdao = new BookDAOImplementation();
    BookBean bookbean = new BookBean();
    DVDDAOImplementation dvddao = new DVDDAOImplementation();
    DVDBean dvdbean = new DVDBean();
    MagazineDAOImplementation magdao = new MagazineDAOImplementation();
    MagazineBean magbean = new MagazineBean();
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script src="jquery-2.1.0.min.js" type="text/javascript"></script>
        <script src="js-general.js" type="text/javascript"></script>
        <script src="js-productmanager.js" type="text/javascript"></script>

        <link rel="stylesheet" type="text/css" href="wadesign.css">
        <link rel="stylesheet" type="text/css" href="category.css">
        <link rel="stylesheet" type="text/css" href="style4.css">
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>

        <title>View Product</title>
    </head>
    <body>
        <header>
            <div id="banner"> <a href="productmanagerHOME.html"><img src="images/books.jpg"></a> </div>
        </header>

        <nav>
            <ul>
                <li><a href="productmanagerHOME.html">Home</a>    </li>
                <li><a href='#'>Account
                        <ul>
                            <li><a href='productmanagerAccount.jsp'>Edit Account</a></li>
                            <li><a href='login.jsp'>Log out</a></li>
                        </ul>
                </li>
            </ul>
        </nav>

        <div id="actions">
            <br/>
            <br/>

            <a href="addproduct.jsp">Add Product</a>
            <br>
            <br>
            <br>
            <br>
        </div>

        <div id="tfheader">
            <form id="tfnewsearch" method="get" action="SearchProductServlet">
                <input type="text" id="tfq" class="tftextinput2" name="searchstring" size="21" maxlength="120" value="Search our website">
                <input type="submit" value=">" class="tfbutton2">
            </form>
        </div>

        <div id="viewProducts">
            <% if (productBean.getType().matches("Audio CD")) {
                    audiocdbean = (AudioCDBean) session.getAttribute("viewaudiocd");
                    //out.println("audiocd");
            %>
            <table>
                <tr>
                    <td>Title</td>
                    <td><input type="text" id="productTitle" name="productTitle" value="<% productBean.getTitle(); %>"/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="hidden" id="productPrice" name="productPrice" value="<% productBean.getPrice(); %>"/></td>
                </tr>
                <tr>
                    <td>Summary</td>
                    <td><input type="hidden" id="productSummary" name="productSummary" value="<% productBean.getSummary(); %>"/></td>
                </tr>
                <tr>
                    <td>Genre</td>
                    <td><input type="hidden" id="productGenre" name="productGenre" value="<% productBean.getGenre(); %>"/></td>
                </tr>
                <tr>
                    <td>Year</td>
                    <td><input type="hidden" id="productYear" name="productYear" value="<% productBean.getYear(); %>"/></td>
                </tr>
                <tr>
                    <td>Stocks</td>
                    <td><input type="hidden" id="productStocks" name="productStocks" value="<% productBean.getNumberStocks(); %>"/></td>
                </tr>
                <tr>
                    <td>Artist</td>
                    <td><input type="hidden" id="productArtist" name="productArtist" value="<% audiocdbean.getArtist(); %>"/></td>
                </tr>
                <tr>
                    <td>Record Company</td>
                    <td><input type="hidden" id="productRecordCompany" name="productRecordCompany" value="<% audiocdbean.getRecordCompany(); %>"/></td>
                </tr>
            </table>


            <%
                } else if (productBean.getType().matches("Books")) {
                    bookbean = (BookBean) session.getAttribute("viewbook");
                    //out.println("book");
            %>
            <table>
                <tr>
                    <td>Title</td>
                    <td><input type="text" id="productTitle" name="productTitle" value="<% productBean.getTitle(); %>"/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="hidden" id="productPrice" name="productPrice" value="<% productBean.getPrice(); %>"/></td>
                </tr>
                <tr>
                    <td>Summary</td>
                    <td><input type="hidden" id="productSummary" name="productSummary" value="<% productBean.getSummary(); %>"/></td>
                </tr>
                <tr>
                    <td>Genre</td>
                    <td><input type="hidden" id="productGenre" name="productGenre" value="<% productBean.getGenre(); %>"/></td>
                </tr>
                <tr>
                    <td>Year</td>
                    <td><input type="hidden" id="productYear" name="productYear" value="<% productBean.getYear(); %>"/></td>
                </tr>
                <tr>
                    <td>Stocks</td>
                    <td><input type="hidden" id="productStocks" name="productStocks" value="<% productBean.getNumberStocks(); %>"/></td>
                </tr>
                <tr>
                    <td>Author</td>
                    <td><input type="hidden" id="productAuthor" name="productAuthor" value="<% bookbean.getAuthor(); %>"/></td>
                </tr>
                <tr>
                    <td>Publisher</td>
                    <td><input type="hidden" id="productPublisher" name="productPublisher" value="<% bookbean.getPublisher(); %>"/></td>
                </tr>
                <tr>
                    <td>Date Published</td>
                    <td><input type="hidden" id="productDate" name="productDate" value="<% bookbean.getDatePublished(); %>"></td>
                </tr>
            </table>
            <%
                } else if (productBean.getType().matches("DVD")) {
                    dvdbean = (DVDBean) session.getAttribute("viewdvd");
                    //out.println("dvd");
            %>
            <table>
                <tr>
                    <td>Title</td>
                    <td><input type="text" id="productTitle" name="productTitle" value="<% productBean.getTitle(); %>"/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="hidden" id="productPrice" name="productPrice" value="<% productBean.getPrice(); %>"/></td>
                </tr>
                <tr>
                    <td>Summary</td>
                    <td><input type="hidden" id="productSummary" name="productSummary" value="<% productBean.getSummary(); %>"/></td>
                </tr>
                <tr>
                    <td>Genre</td>
                    <td><input type="hidden" id="productGenre" name="productGenre" value="<% productBean.getGenre(); %>"/></td>
                </tr>
                <tr>
                    <td>Year</td>
                    <td><input type="hidden" id="productYear" name="productYear" value="<% productBean.getYear(); %>"/></td>
                </tr>
                <tr>
                    <td>Stocks</td>
                    <td><input type="hidden" id="productStocks" name="productStocks" value="<% productBean.getNumberStocks(); %>"/></td>
                </tr>
                <tr>
                    <td>Director</td>
                    <td><input type="hidden" id="productDirector" name="productDirector" value="<% dvdbean.getDirector(); %>"/></td>
                </tr>
                <tr>
                    <td>Actor</td>
                    <td><input type="hidden" id="productActor" name="productActor" value="<% dvdbean.getMainActors(); %>"/></td>
                </tr>
                <tr>
                    <td>Product Company</td>
                    <td><input type="hidden" id="productCompany" name="productCompany" value="<% dvdbean.getProductionCompany(); %>"></td>
                </tr>
            </table>
            
            
            <%
                    
                } else if (productBean.getType().matches("Magazine")) {
                    magbean = (MagazineBean) session.getAttribute("viewmagazine");
                    //out.println("magazine");
            %>
            <table>
                <tr>
                    <td>Title</td>
                    <td><input type="text" id="productTitle" name="productTitle" value="<% productBean.getTitle(); %>"/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="hidden" id="productPrice" name="productPrice" value="<% productBean.getPrice(); %>"/></td>
                </tr>
                <tr>
                    <td>Summary</td>
                    <td><input type="hidden" id="productSummary" name="productSummary" value="<% productBean.getSummary(); %>"/></td>
                </tr>
                <tr>
                    <td>Genre</td>
                    <td><input type="hidden" id="productGenre" name="productGenre" value="<% productBean.getGenre(); %>"/></td>
                </tr>
                <tr>
                    <td>Year</td>
                    <td><input type="hidden" id="productYear" name="productYear" value="<% productBean.getYear(); %>"/></td>
                </tr>
                <tr>
                    <td>Stocks</td>
                    <td><input type="hidden" id="productStocks" name="productStocks" value="<% productBean.getNumberStocks(); %>"/></td>
                </tr>
                <tr>
                    <td>Volume No</td>
                    <td><input type="hidden" id="productVolume" name="productVolume" value="<% magbean.getVolumeNo(); %>"/></td>
                </tr>
                <tr>
                    <td>Issue No</td>
                    <td><input type="hidden" id="productIssue" name="productIssue" value="<% magbean.getIssueNo(); %>"/></td>
                </tr>
                <tr>
                    <td>Publisher</td>
                    <td><input type="hidden" id="productPublisher" name="productPublisher" value="<% magbean.getPublisher(); %>"/></td>
                </tr>
                <tr>
                    <td>Date Published</td>
                    <td><input type="hidden" id="productDate" name="productDate" value="<% magbean.getDatePublished(); %>"></td>
                </tr>
            </table>
            <%                    
                }
            %>
        </div>
    </body>
</html>
