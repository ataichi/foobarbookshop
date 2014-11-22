<%-- 
    Document   : addproduct
    Created on : Nov 16, 2014, 5:42:24 AM
    Author     : Giodee
--%>

<%@page import="DAO.Implementation.ProductManagerDAOImplementation"%>
<%@page import="DAO.Interface.ProductManagerDAOInterface"%>
<%@page import="Beans.ProductManagerBean"%>
<%@page import="Beans.AccountBean"%>
<%
    AccountBean homeproduct = (AccountBean) session.getAttribute("homeproduct");
    ProductManagerBean productManager = new ProductManagerBean();
    ProductManagerDAOInterface pdao = new ProductManagerDAOImplementation();
    productManager = pdao.getProductManagerBeanById(homeproduct.getAccountID());
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
        <script src="js-edit.js" type="text/javascript"></script>
        <script src="js-productmanager.js" type="text/javascript"></script>

        <link rel="stylesheet" type="text/css" href="wadesign.css">
        <link rel="stylesheet" type="text/css" href="category.css">
        <link rel="stylesheet" type="text/css" href="style4.css">
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>

        <title>Add Product</title>
    </head>
    <body>
        <header>
            <div id="banner"> <a href="login.html"><img src="images/books.jpg"></a> </div>
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
        </div>

        <div id="product">
            Add <%out.println(productManager.getProdType());%>:
            <br/><br/>
            <form action="AddProductServlet">
                <table>
                    <tr>
                        <td>Title:*</td>
                        <td><input type='text' id='productTitle' name='productTitle' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Price:* </td>
                        <td>
                            <input type='text' id='productPrice' name='productPrice' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Summary:
                        </td>
                        <td>
                            <input type='text' id='productSummary' name='productSummary' onfocus='backWhite(this);'/>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            Genre:
                        </td>
                        <td>
                            <input type='text' id='productGenre' name='productGenre' onfocus='backWhite(this);'/>

                        </td>
                    </tr>
                    <tr>
                        <td>Year:
                        </td>
                        <td>
                            <input type='text' id='productYear' name='productYear' onfocus='backWhite(this);'/>       

                        </td>
                    </tr>
                    <tr>
                        <td>
                            Stocks:
                        </td>
                        <td>
                            <input type='text' id='productStocks' name='productStocks' onfocus='backWhite(this);'/>

                        </td>
                    </tr>

                    <%if (productManager.getProdType().equals("Audio CD")) {
                            out.println("<tr><td>Artist</td>"
                                    + "<td> <input type ='text' id ='cdArtist' name ='cdArtist' onfocus ='backWhite(this);'/></td ></tr>"
                                    + "<tr><td>Record Company:</td>"
                                    + "<td><input type='text' id='cdRecord' name='cdRecord' onfocus='backWhite(this);'/></td></tr>"
                            );

                        } else if (productManager.getProdType().equals("Books")) {
                            out.println("<tr><td>Author</td>"
                                    + "<td><input type='text' id='bookAuthor' name='bookAuthor' onfocus='backWhite(this);'/></td></tr>"
                                    + "<tr><td>Publisher</td>"
                                    + "<td><input type='text' id='bookPublisher' name='bookPublisher' onfocus='backWhite(this);'/></td></tr>"
                                    + "<tr><td>Date Published:</td>"
                                    + "<td><input type='date' id='bookDatePublished' name='bookDatePublished' onfocus='backWhite(this);'/></td></tr>"
                            );

                        } else if (productManager.getProdType().equals("DVD")) {
                            out.println("<tr><td>Director:</td>"
                                    + "<td><input type='text' id='dvdDirector' name='dvdDirector' onfocus='backWhite(this);'/></td></tr>"
                                    + "<tr><td>Actor:</td>"
                                    + "<td><input type='text' id='dvdActor' name='dvdActor' onfocus='backWhite(this);'/></td></tr>"
                                    + "<tr><td>Producer:</td>"
                                    + "<td><input type='text' id='dvdProducer' name='dvdProducer' onfocus='backWhite(this);'/></td></tr>"
                            );

                        } else if (productManager.getProdType().equals("Magazine")) {
                           out.println("<tr><td>Volume No:</td>"
                                   + "<td><input type='text' id='magazineVolume' name='magazineVolume' onfocus='backWhite(this);'/></td></tr>"
                                   + "<tr><td>Issue No:</td>"
                                   + "<td><input type='text' id='magazineIssue' name='magazineIssue' onfocus='backWhite(this);'/></td></tr>"
                                   + "<tr><td>Publisher</td>"
                                   + "<td><input type='text' id='magazinePublisher' name='magazinePublisher' onfocus='backWhite(this);'/></td></tr>"
                                   + "<tr><td>Date Published</td>"
                                   + "<td><input type='date' id='magazineDate' name='magazineDate' onfocus='backWhite(this);'/></td></tr>");
                        }
                    %>


                </table>

                <input type='submit' value='Submit'/>
            </form>

            <a href='productmanagerHOME.jsp'><button>Cancel</button></a>

        </form>

    </div>
</body>
</html>
