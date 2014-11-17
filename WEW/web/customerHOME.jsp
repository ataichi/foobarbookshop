
<%@page import="Beans.AccountBean"%>
<%@page import="Beans.CustomerBean"%>
<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
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
        <link rel="stylesheet" type="text/css" href="css/style4.css">
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>

        <title>Customer Home Page</title>
    </head>
    <body>
        
        <header>
            <div id="banner"> <a href="customerHOME.jsp"><img src="books.jpg"></a> </div>
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
                            <li><a href='#'>Log out</a></li>
                        </ul>
                </li>
            </ul>
        </nav>
        
        <div id='actions'>
            <input class="search" placeholder="Search" />
            <br>
            <br>
            <ul>
            <a href='customerBilling.jsp'>Manage Billing Information</a>
            <a href='customerPayments.jsp'>Manage Payment Information</a>
            <a href='customerTransactions.jsp'>View Transactions</a>
            <ul/>
        </div>
    </body>
</html>
