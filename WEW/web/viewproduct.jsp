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
                    <td><input type="text" id="productTitle" name="productTitle" value="<% out.println(productBean.getTitle()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" id="productPrice" name="productPrice" value="<% out.println(productBean.getPrice()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Summary</td>
                    <td><input type="text" id="productSummary" name="productSummary" value="<% out.println(productBean.getSummary()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Genre</td>
                    <td><input type="text" id="productGenre" name="productGenre" value="<% out.println(productBean.getGenre()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Year</td>
                    <td><input type="text" id="productYear" name="productYear" value="<% out.println(productBean.getYear()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Stocks</td>
                    <td><input type="text" id="productStocks" name="productStocks" value="<% out.println(productBean.getNumberStocks()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Artist</td>
                    <td><input type="text" id="productArtist" name="productArtist" value="<% out.println(audiocdbean.getArtist()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Record Company</td>
                    <td><input type="text" id="productRecordCompany" name="productRecordCompany" value="<% out.println(audiocdbean.getRecordCompany()); %>" readonly/></td>
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
                    <td><input type="text" id="productTitle" name="productTitle" value="<% out.println(productBean.getTitle()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" id="productPrice" name="productPrice" value="<% out.println(productBean.getPrice()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Summary</td>
                    <td><input type="text" id="productSummary" name="productSummary" value="<% out.println(productBean.getSummary()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Genre</td>
                    <td><input type="text" id="productGenre" name="productGenre" value="<% out.println(productBean.getGenre()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Year</td>
                    <td><input type="text" id="productYear" name="productYear" value="<% out.println(productBean.getYear()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Stocks</td>
                    <td><input type="text" id="productStocks" name="productStocks" value="<% out.println(productBean.getNumberStocks()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Author</td>
                    <td><input type="text" id="productAuthor" name="productAuthor" value="<% out.println(bookbean.getAuthor()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Publisher</td>
                    <td><input type="text" id="productPublisher" name="productPublisher" value="<% out.println(bookbean.getPublisher()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Date Published</td>
                    <td><input type="text" id="productDate" name="productDate" value="<% out.println(bookbean.getDatePublished()); %>" readonly/></td>
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
                    <td><input type="text" id="productTitle" name="productTitle" value="<% out.println(productBean.getTitle()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" id="productPrice" name="productPrice" value="<% out.println(productBean.getPrice()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Summary</td>
                    <td><input type="text" id="productSummary" name="productSummary" value="<% out.println(productBean.getSummary()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Genre</td>
                    <td><input type="text" id="productGenre" name="productGenre" value="<% out.println(productBean.getGenre()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Year</td>
                    <td><input type="text" id="productYear" name="productYear" value="<% out.println(productBean.getYear()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Stocks</td>
                    <td><input type="text" id="productStocks" name="productStocks" value="<% out.println(productBean.getNumberStocks()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Director</td>
                    <td><input type="text" id="productDirector" name="productDirector" value="<% out.println(dvdbean.getDirector()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Actor</td>
                    <td><input type="text" id="productActor" name="productActor" value="<% out.println(dvdbean.getMainActors()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Product Company</td>
                    <td><input type="text" id="productCompany" name="productCompany" value="<% out.println(dvdbean.getProductionCompany()); %>" readonly/></td>
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
                    <td><input type="text" id="productTitle" name="productTitle" value="<% out.println(productBean.getTitle()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" id="productPrice" name="productPrice" value="<% out.println(productBean.getPrice()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Summary</td>
                    <td><input type="text" id="productSummary" name="productSummary" value="<% out.println(productBean.getSummary()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Genre</td>
                    <td><input type="text" id="productGenre" name="productGenre" value="<% out.println(productBean.getGenre()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Year</td>
                    <td><input type="text" id="productYear" name="productYear" value="<% out.println(productBean.getYear()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Stocks</td>
                    <td><input type="text" id="productStocks" name="productStocks" value="<% out.println(productBean.getNumberStocks()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Volume No</td>
                    <td><input type="text" id="productVolume" name="productVolume" value="<% out.println(magbean.getVolumeNo()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Issue No</td>
                    <td><input type="text" id="productIssue" name="productIssue" value="<% out.println(magbean.getIssueNo()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Publisher</td>
                    <td><input type="text" id="productPublisher" name="productPublisher" value="<% out.println(magbean.getPublisher()); %>" readonly/></td>
                </tr>
                <tr>
                    <td>Date Published</td>
                    <td><input type="text" id="productDate" name="productDate" value="<% out.println(magbean.getDatePublished()); %>" readonly/></td>
                </tr>
            </table>
            <%                    
                }
            %>
        </div>
    </body>
</html>
