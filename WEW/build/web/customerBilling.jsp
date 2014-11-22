<%@page import="Beans.CustomerBean"%>
<%@page import="DAO.Implementation.CustomerDAOImplementation"%>
<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
    CustomerDAOImplementation customerdao = new CustomerDAOImplementation();
    CustomerBean cbean = customerdao.getCustomerByAccountID(homeuser.getAccountID());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="jquery-2.1.0.min.js" type="text/javascript"></script>
        <script src="js-general.js" type="text/javascript"></script>
        <script src="js-edit.js" type="text/javascript"></script>
        <script src="js/customercheck.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="wadesign.css">
        <link rel="stylesheet" type="text/css" href="category.css">
        <link rel="stylesheet" type="text/css" href="style4.css">
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>

        <title>Edit Billing Information</title>

    </head>
    <body>

        <header>
            <div id="banner"> <a href="home.html"><img src="images/books.jpg"></a> </div>
        </header>
        <nav>
            <ul>
                <li><a href="home.html">Home</a>    </li>
                <li><a href="#">Category</a>
                    <ul>
                        <li><a href="#">Books</a></li>
                        <li><a href="#">Magazines</a></li>
                        <li><a href="#">Audio CDs</a></li>
                        <li><a href="#">DVDs</a></li>
                    </ul>
                </li>
                <li><a href="#">Register</a>   </li>
                <li><a href='#'>Account
                        <ul>
                            <li><a href='customerAccount.jsp'>Edit Account</a></li>
                            <li><a href='#'>Log out</a></li>
                        </ul>
                </li>
            </ul>
        </nav>

        <div id="tfheader">
            <form id="tfnewsearch" method="get" action="CustomerSearchProductServlet">
                <input type="text" id="tfq" class="tftextinput2" name="searchstring" size="21" maxlength="120" value="Search our website">
                <input type="submit" value=">" class="tfbutton2">
            </form>
        </div>

        <div id='actions'>
            <br>
            <br>
            <a href='customerBilling.jsp'>Manage Billing Information</a>
            <br/>
            <br>

            <a href='customerPayments.jsp'>Manage Payment Information</a>
            <br/>
            <br>
            <a href='customerTransactions.jsp'>View Transactions</a>
            <br/>
        </div>

        <div id="editBilling">
            <form id="customercheck" name="customercheck" onsubmit="return billingCheck(this)" action="EditBillingInfoServlet" method="post">
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
                    <tr>
                        <td><input type="submit" id="save" value="Save Changes"/></td>
                    </tr>
                </table>
            </form>
                    <a href='customerHOME.jsp'><button>Cancel</button></a>
        </div>
    </body>
</html>
