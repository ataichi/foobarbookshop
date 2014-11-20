<%-- 
    Document   : productmanagerHOME
    Created on : Nov 9, 2014, 10:11:04 PM
    Author     : Giodee
--%>
<%@page import="DAO.Implementation.AudioCDManagerDAOImplementation"%>
<%@page import="DAO.Interface.DVDManagerDAOInterface"%>
<%@page import="DAO.Implementation.DVDManagerDAOImplementation"%>
<%@page import="DAO.Implementation.MagazineManagerDAOImplementation"%>
<%@page import="DAO.Interface.MagazineManagerDAOInterface"%>
<%@page import="DAO.Interface.AudioCDManagerDAOInterface"%>
<%@page import="DAO.Implementation.BookManagerDAOImplementation"%>
<%@page import="Beans.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Interface.BookManagerDAOInterface"%>
<%@page import="Beans.DVDBean"%>
<%@page import="Beans.AudioCDBean"%>
<%@page import="Beans.MagazineBean"%>
<%@page import="Beans.BookBean"%>
<%@page import="DAO.Implementation.ProductManagerDAOImplementation"%>
<%@page import="DAO.Interface.ProductManagerDAOInterface"%>
<%@page import="Beans.ProductManagerBean"%>
<%@page import="Beans.AccountBean"%>

<%
    AccountBean homeproduct = (AccountBean) session.getAttribute("homeproduct");
    ProductManagerDAOInterface pdao = new ProductManagerDAOImplementation();
    ProductManagerBean managerBean = pdao.getProductManagerBeanById(homeproduct.getAccountID());
    ArrayList<ProductBean> productlist = (ArrayList<ProductBean>) session.getAttribute("productlist");
    BookManagerDAOInterface bookdao = new BookManagerDAOImplementation();
    AudioCDManagerDAOInterface audiodao = new AudioCDManagerDAOImplementation();
    MagazineManagerDAOInterface magazinedao = new MagazineManagerDAOImplementation();
    DVDManagerDAOInterface dvddao = new DVDManagerDAOImplementation();
    ArrayList<BookBean> booklist = bookdao.getAllBooks();
    ArrayList<AudioCDBean> audiocdlist = audiodao.getAllAudioCD();
    ArrayList<MagazineBean> magazinelist = magazinedao.getAllMagazine();
    ArrayList<DVDBean> dvdlist = dvddao.viewAllDVD();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


        <title>JSP Page</title>
    </head>
    <body>

        <header>
            <div id="banner"> <a href="productmanagerHOME.html"><img src="books.jpg"></a> </div>
        </header>
        <nav>
            <ul>
                <li><a href="productmanagerHOME.html">Home</a>    </li>
                <li><a href='#'>Account
                        <ul>
                            <li><a href='productmanagerAccount.jsp'>Edit Account</a></li>
                            <li><a href='#'>Log out</a></li>
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
                <input type="text" id="tfq" class="tftextinput2" name="q" size="21" maxlength="120" value="Search our website">
                <input type="submit" value=">" class="tfbutton2">
            </form>
        </div>
        <div id="viewProducts">
            <table>
                <tr>
                    <td><center>Title</center>
                </td>
                <td><center>Stocks</center>
                </td>
                <td><center>Actions</center>
                </td>
                </tr>
                <%
                    int i;
                    for (i = 0; i < productlist.size(); i++) {
                        out.println("<tr>"
                                + "<td><center>"
                                + productlist.get(i).getTitle()
                                + "</center></td><td><center>"
                                + productlist.get(i).getNumberStocks()
                                + "</center></td><td><center>"
                                + "<form id='" + productlist.get(i).getProductID() + "' method='post' action='EditProductServlet'>"
                                + "<input type='hidden' id='product' name='product' value='" + productlist.get(i).getProductID() + "'/>"
                                + "<input type='submit' id='submit' value='Edit' name='" + productlist.get(i).getProductID() + "' style='border-color: transparent; background-color: transparent'/>"
                                + "</form>"
                                + "<form id='" + productlist.get(i).getProductID() + "' method='post' action='RemoveProductServlet'>"
                                + "<input type='hidden' id='product' name='product' value='" + productlist.get(i).getProductID() + "'/>"
                                + "<input type='submit' value='Remove' name='" + productlist.get(i).getProductID() + "' style='border-color:transparent; background-color: transparent'/>"
                                + "</form>"
                                + "<form id='" + productlist.get(i).getProductID() + "' method='post' action='RestockProductServlet'>"
                                + "<input type='hidden' id='product' name='product' value='" + productlist.get(i).getProductID() +"'/>"
                                + "<input type='submit' value='Restock' name='" + productlist.get(i).getProductID() + "' style='border-color:transparent; background-color: transparent'/>"
                                + "</form>"
                                + "</center></td></tr>");
                    }
                %>
            </table>
        </div>

    </body>
</html>
