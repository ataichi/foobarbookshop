<%-- 
    Document   : editproduct
    Created on : Nov 16, 2014, 6:08:38 PM
    Author     : Giodee
--%>


<%@page import="Beans.MagazineBean"%>
<%@page import="Beans.DVDBean"%>
<%@page import="Beans.BookBean"%>
<%@page import="Beans.AudioCDBean"%>
<%@page import="DAO.Implementation.ProductManagerDAOImplementation"%>
<%@page import="DAO.Interface.ProductManagerDAOInterface"%>
<%@page import="Beans.ProductManagerBean"%>
<%@page import="Beans.ProductBean"%>
<%@page import="Beans.AccountBean"%>
<%
    AccountBean homeproduct = (AccountBean) session.getAttribute("homeproduct");
    ProductManagerBean productManager = new ProductManagerBean();
    ProductManagerDAOInterface pdao = new ProductManagerDAOImplementation();
    productManager = pdao.getProductManagerBeanById(homeproduct.getAccountID());

    ProductBean editproduct = (ProductBean) session.getAttribute("editproduct");
    AudioCDBean audiocd = (AudioCDBean) session.getAttribute("editaudio");
    BookBean book = (BookBean) session.getAttribute("editbook");
    DVDBean dvd = (DVDBean) session.getAttribute("editdvd");
    MagazineBean magazine = (MagazineBean) session.getAttribute("editmagazine");
    if (productManager.getProdType().equals("Audio CD")) {
    } else if (productManager.getProdType().equals("Books")) {
    } else if (productManager.getProdType().equals("DVD")) {
    } else if (productManager.getProdType().equals("Magazine")) {
    }
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

        <title> Edit Product</title>

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

        <div id="product">
            Edit <%out.println(editproduct.getTitle());%>:
            <br/><br/>
            <form action="AddProductServlet">
                <table>
                    <tr>
                        <td>Title:*</td>
                        <td><input type='text' id='productTitle' name='productTitle' value='<% out.println(editproduct.getTitle()); %>' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Price:* </td>
                        <td>
                            <input type='text' id='productPrice' name='productPrice'  value='<% out.println(editproduct.getPrice()); %>' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Summary:
                        </td>
                        <td>
                            <input type='text' id='productSummary' name='productSummary'  value='<% out.println(editproduct.getSummary()); %>' onfocus='backWhite(this);'/>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            Genre:
                        </td>
                        <td>
                            <input type='text' id='productGenre' name='productGenre'  value='<% out.println(editproduct.getGenre()); %>'onfocus='backWhite(this);'/>

                        </td>
                    </tr>
                    <tr>
                        <td>Year:
                        </td>
                        <td>
                            <input type='text' id='productYear' name='productYear'  value='<% out.println(editproduct.getYear()); %>'onfocus='backWhite(this);'/>       

                        </td>
                    </tr>
                    <tr>
                        <td>
                            Stocks:
                        </td>
                        <td>
                            <input type='text' id='productStocks' name='productStocks'  value='<% out.println(editproduct.getNumberStocks()); %>' onfocus='backWhite(this);'/>

                        </td>
                    </tr>

                    <%if (productManager.getProdType().equals("Audio CD")) {  %>
                    <br/>
                    <tr>
                        <td>Artist</td>
                        <td>
                            <input type='text' id='cdArtist' name='cdArtist' value='<% out.println(audiocd.getArtist()); %>' onfocus='backWhite(this);'/>    
                        </td>
                    <tr>
                        <td>
                            Record Company:
                        </td>
                        <td>
                            <input type='text' id='cdRecord' name ='cdRecord' value='<% out.println(audiocd.getRecordCompany()); %>'  onfocus='backWhite(this);'/>

                        </td>
                    </tr>

                    <%}%>
                    <%if (productManager.getProdType().equals("Books")) { %>
                    <br/>
                    <tr>
                        <td>Author</td>
                        <td>
                            <input type='text' id='bookAuthor' name='bookAuthor' value='<% out.println(book.getAuthor()); %>' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Publisher:</td>
                        <td>
                            <input type='text' id='bookPublisher' name='bookPublisher' value='<% out.println(book.getPublisher()); %>'onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Date Published:
                        </td>
                        <td>
                            <input type='date' id='bookDatePublished' name='bookDatePublished' value='<% out.println(book.getDatePublished()); %>' onfocus='backWhite(this);'/>
                        </td>
                    </tr>

                    <%}%>
                    <% if (productManager.getProdType().equals("DVD")) { %>
                    <br/>
                    <tr>
                        <td>Director:</td>
                        <td>
                            <input type='text' id='dvdDirector' name='dvdDirector' value='<% out.println(dvd.getDirector()); %>' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Actor:</td>
                        <td><input type='text' id='dvdActor' name='dvdActor' value='<% out.println(dvd.getMainActors()); %>' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Producer:</td>
                        <td>
                            <input type='text' id='dvdProducer' name='dvdProducer' value='<% out.println(dvd.getProductionCompany()); %>' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <% } %>
                    <% if (productManager.getProdType().equals("Magazine")) { %>
                    <br/>
                    <tr>
                        <td>Volume No:</td>
                        <td>
                            <input type='text' id='magazineVolume' name='magazineVolume' value='<% out.println(magazine.getVolumeNo()); %>' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Issue No:</td>
                        <td><input type='text' id='magazineIssue' name='magazineIssue' value='<% out.println(magazine.getIssueNo()); %>' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Publisher:</td>
                        <td>
                            <input type='text' id='magazinePublisher' name='magazinePublisher'value='<% out.println(magazine.getPublisher()); %>' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Date Published</td>
                        <td>
                            <input type='date' id='magazineDate' name='magazineDate' value='<% out.println(magazine.getDatePublished()); %>' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <% }%>

                </table>

                <input type='submit' value='Submit'/>
            </form>

            <a href='productmanagerHOME.jsp'><button>Cancel</button></a>

        </form>

    </div>

</body>
</html>
