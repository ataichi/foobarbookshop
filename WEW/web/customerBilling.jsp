<%@page import="Beans.CustomerBean"%>
<%@page import="DAO.Implementation.CustomerDAOImplementation"%>
<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
    CustomerBean cbean = (CustomerBean) session.getAttribute("tempcustomer");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="jquery-2.1.0.min.js" type="text/javascript"></script>
        <script src="js/customercheck.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="css/style4.css">
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>

        <title>Edit Billing Information</title>

    </head>
    <body>
        <header>
            <div id="banner"> <a href="customerBilling.jsp"><img src="images/books.jpg"></a> </div>
        </header>
        <nav> 
            <ul>
                <li><a href="customerHOME.jsp">Home</a>    </li>
                <li><a href="#">Category</a>
                    <ul>
                        <li><a href="#">Books</a></li>
                        <li><a href="#">Magazines</a></li>
                        <li><a href="#">Audio CDs</a></li>
                        <li><a href="#">DVDs</a></li>
                    </ul>
                </li>
                <li><a href='#'><% out.println(homeuser.getUsername()); %></a>
                    <ul>
                        <li><a href='customerAccount.jsp'>Edit Account</a></li>
                        <li><a href='logout.jsp'>Log out</a></li>
                    </ul>
                </li>
            </ul>
        </nav>


        <div id='actions'>
            <input type="text" action="CustomerSearchProductServlet" id="tfq" class="search" name="searchstring" size="21" maxlength="120" placeholder="Search">
            <br>
            <br>
            <ul>
                <a href='customerBilling.jsp'>Manage Billing Information</a>
                <a href='customerPayments.jsp'>Manage Payment Information</a>
                <a href='customerTransactions.jsp'>View Transactions</a>
                <ul/>
        </div>
        <div class="featuredadmin">
            <div id="editBilling">
                <form id="customercheck" class="editcustomerbill" name="customercheck" action="EditBillingInfoServlet" method="post">
                    <table>
                        <tr>
                            <td>Billing Address:</td>
                        </tr>
                        <tr>
                            <td>Apartment No:</td>
                            <td><input type='text' id='apartmentnoBA' name='apartmentnoBA'  onfocus="backWhite(this)" value="<% out.println(cbean.getApartmentNoBA()); %>"></td>
                        </tr>
                        <tr>
                            <td>Street:</td>
                            <td><input type='text' id='streetBA' name='streetBA' onblur="streetBACheck()" onfocus="backWhite(this)" value="<% out.println(cbean.getStreetBA()); %>"></td>
                        </tr>
                        <tr>
                            <td>Subdivision:</td>
                            <td><input type='text' id='subdivisionBA' name='subdivisionBA' onblur="subdivisionBACheck()" onfocus="backWhite(this)" value="<% out.println(cbean.getSubdivisionBA()); %>"></td>
                        </tr>
                        <tr>
                            <td>City:</td>
                            <td><input type='text' id='cityBA' name='cityBA' onblur="cityBACheck()" onfocus="backWhite(this)" value="<% out.println(cbean.getCityBA()); %>"></td>
                        </tr>
                        <tr>      
                            <td>Country:</td> 
                            <td><input type='text' id='countryBA' name='countryBA' onblur="countryBACheck()" onfocus="backWhite(this)" value="<% out.println(cbean.getCountryBA()); %>"></td>
                        </tr>
                        <tr>
                            <td>Postal Code:</td>
                            <td><input type='text' id='postalcodeBA' name='postalcodeBA' onblur="postalcodeBACheck()" onfocus="backWhite(this)" value="<% out.println(cbean.getPostalCodeBA()); %>"></td>
                        </tr>
                        <tr></tr>
                        <tr>
                            <td>Delivery Address:</td>
                        </tr>
                        <tr>
                            <td>Apartment No:</td>
                            <td><input type='text' id='apartmentnoDA' name='apartmentnoDA' onfocus="backWhite(this)" value="<% out.println(cbean.getApartmentNoDA()); %>"></td>
                        </tr>
                        <tr>
                            <td>Street:</td>
                            <td><input type='text' id='streetDA' name='streetDA' onblur="streetDACheck()" onfocus="backWhite(this)" value="<% out.println(cbean.getStreetDA()); %>"></td>
                        </tr>
                        <tr>
                            <td>Subdivision:</td>
                            <td><input type='text' id='subdivisionDA' name='subdivisionDA' onblur="subdivisionDACheck()" onfocus="backWhite(this)" value="<% out.println(cbean.getSubdivisionDA()); %>"></td>
                        </tr>
                        <tr>
                            <td>City:</td>
                            <td><input type='text' id='cityDA' name='cityDA' onblur="cityDACheck()" onfocus="backWhite(this)" value="<% out.println(cbean.getCityDA()); %>"></td>
                        </tr>
                        <tr>      
                            <td>Country:</td> 
                            <td><input type='text' id='countryDA' name='countryDA' onblur="countryDACheck()" onfocus="backWhite(this)" value="<% out.println(cbean.getCountryDA()); %>"></td>
                        </tr>
                        <tr>
                            <td>Postal Code:</td>
                            <td><input type='text' id='postalcodeDA' name='postalcodeDA' onblur="postalcodeDACheck()" onfocus="backWhite(this)" value="<% out.println(cbean.getPostalCodeDA());%>"></td>
                        </tr>
                    </table>
                    <input type="submit" id="save" class="savechangesbill" value="Save Changes"/>
                </form>
                <a href='customerHOME.jsp'><button class="cancelbill">Cancel</button></a>
            </div>
        </div>
    </body>
</html>
