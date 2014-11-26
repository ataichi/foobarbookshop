<%-- 
    Document   : viewproduct
    Created on : Nov 23, 2014, 12:31:39 AM
    Author     : Danica
--%>

<%@page import="Beans.ProductBean"%>
<%@page import="Beans.MagazineBean"%>
<%@page import="DAO.Implementation.MagazineManagerDAOImplementation"%>
<%@page import="Beans.DVDBean"%>
<%@page import="DAO.Implementation.DVDManagerDAOImplementation"%>
<%@page import="Beans.BookBean"%>
<%@page import="DAO.Implementation.BookManagerDAOImplementation"%>
<%@page import="Beans.AudioCDBean"%>
<%@page import="DAO.Implementation.AudioCDManagerDAOImplementation"%>
<%@page import="DAO.Implementation.ProductDAOImplementation"%>
<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean account = (AccountBean) session.getAttribute("homeproduct");
    ProductBean productBean = (ProductBean) session.getAttribute("viewproduct");

    ProductDAOImplementation pdao = new ProductDAOImplementation();
    AudioCDManagerDAOImplementation audiocddao = new AudioCDManagerDAOImplementation();
    AudioCDBean audiocdbean = new AudioCDBean();
    BookManagerDAOImplementation bookdao = new BookManagerDAOImplementation();
    BookBean bookbean = new BookBean();
    DVDManagerDAOImplementation dvddao = new DVDManagerDAOImplementation();
    DVDBean dvdbean = new DVDBean();
    MagazineManagerDAOImplementation magdao = new MagazineManagerDAOImplementation();
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
            <%
                out.println("<table><tr>"
                        + "<td>Title</td>"
                        + "<td><input type='text' name='productTitle=' value='" + productBean.getTitle() + "' readonly/></td></tr>"
                        + "<tr><td>Summary</td>"
                        + "<td><input type='text' name='productSummary' value ='" + productBean.getSummary() + "' readonly/></td></tr>"
                        + "<tr><td>Genre</td>"
                        + "<td><input type='text' name='productGenre' value ='" + productBean.getGenre() + "' readonly/></td></tr>"
                        + "<tr><td>Year</td>"
                        + "<td><input type='text' name='productYear' value='" + productBean.getYear() + "' readonly/></td></tr>"
                        + "<td>Stocks</td>"
                        + "<td><input type='text' name='productStocks' value='" + productBean.getNumberStocks() + "' readonly/></td></tr>");

                if (productBean.getType().equals("Audio CD")) {
                    audiocdbean = (AudioCDBean) session.getAttribute("viewaudiocd");
                    //out.println("audiocd");
                    out.println("<tr><td>Artist</td>"
                            + "<td><input type='text' name='productArtist' value='" + audiocdbean.getArtist() + "' readonly/></td></tr>"
                            + "<tr><td>Record Company</td>"
                            + "<td><input type='text' name='productRecordCompany' value='" + audiocdbean.getArtist() + "'readonly/></td></tr>"
                            + "<form action='AddToShoppingCartServlet' method='post'>"
                            + "<tr><td><input type='number' name='quantity'/></td>"
                            + "<td><input type='submit' value='Add to Cart'/></td>"
                            + "<td><input type='hidden' name='product' value='" + audiocdbean.getAudiocd_productID() + "'/></td></tr></form>"
                            + "</table>");

                } else if (productBean.getType().equals("Books")) {
                    bookbean = (BookBean) session.getAttribute("viewbook");
                    out.println("<tr><td>Author</td>"
                            + "<td><input type='text' name='productAuthor' value='" + bookbean.getAuthor() + "' readonly /></td></tr>"
                            + "<tr><td>Publisher</td>"
                            + "<td><input type='text' name='productPublisher' value='" + bookbean.getPublisher() + "' readonly /></td></tr>"
                            + "<tr><td>Date Published</td>"
                            + "<td><input type='text' name='productDate' value'" + bookbean.getDatePublished() + "' readonly/></td></tr>"
                            + "<form action='AddToShoppingCartServlet' method='post'>"
                            + "<tr><td><input type='number' name='quantity'/></td>"
                            + "<td><input type='submit' value='Add to Cart'/></td>"
                            + "<td><input type='hidden' name='product' value='" + bookbean.getBook_productID() + "'/></td></tr></form>"
                    );

                } else if (productBean.getType().equals("DVD")) {
                    dvdbean = (DVDBean) session.getAttribute("viewdvd");
                    out.println("<tr><td>Director</td>"
                            + "<td><input type='text' name='productDirector' value='" + dvdbean.getDirector() + "' readonly/></td></tr>"
                            + "<tr><td>Actor</td>"
                            + "<td><input type='text' name='productActor' value='" + dvdbean.getMainActors() + "' readonly/></td></tr>"
                            + "<tr><td>Production Company</td>"
                            + "<td><input type='text' name-'productCompany' value='" + dvdbean.getProductionCompany() + "' readonly/></td></tr>"
                            + "<form action='AddToShoppingCartServlet' method='post'>"
                            + "<tr><td><input type='number' name='quantity'/></td>"
                            + "<td><input type='submit' value='Add to Cart'/></td>"
                            + "<td><input type='hidden' name='product' value='" + dvdbean.getDvd_productID() + "'/></td></tr></form>"
                    );
                } else if (productBean.getType().equals("Magazine")) {
                    magbean = (MagazineBean) session.getAttribute("viewmagazine");
                    //out.println("magazine"); 
                    out.println("<tr><td>Volume No</td>"
                            + "<td><input type='text' name='productVolume' value='" + magbean.getVolumeNo() + "' readonly/></td></tr>"
                            + "<tr><td>Issue No</td>"
                            + "<td><input type='text' name='productIssue' value='" + magbean.getIssueNo() + "' readonly/></td></tr>"
                            + "<tr><td>Publisher</td>"
                            + "<td><input type='text' name='productPublisher' value='" + magbean.getPublisher() + "'readonly/></td></tr>"
                            + "<tr><td>Date Published</td>"
                            + "<td><input type='text' name='productDate' value='" + magbean.getDatePublished() + "' readonly/> </td></tr>"
                            + "<form action='AddToShoppingCartServlet' method='post'>"
                            + "<tr><td><input type='number' name='quantity'/></td>"
                            + "<td><input type='submit' value='Add to Cart'/></td>"
                            + "<td><input type='hidden' name='product' value='" + magbean.getMagazine_productID() + "'/></td></tr></form>"
                    );
                }
                out.println("</table>");

                out.println("<form method='post' action='ShoppingServlet'>"
                        + "<input type='submit' value='Buy'/></form>");
            %>         
        </div>
    </body>
</html>
