<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" type="text/css" href="css/style4.css">
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
        <script src="jquery-2.1.0.min.js" type="text/javascript"></script>

        <title>Admin Home</title>
    </head>
    <body>
        <%
            AccountBean homeuser = (AccountBean) session.getAttribute("homeadmin");
        %>

        <header>
            <div id="banner"> <a href="adminHOME.jsp"><img src="images/books.jpg"/></a> </div>
        </header>

        <nav>
            <ul>
                <li><a href="adminHOME.jsp">Home</a>    </li>
                <li><a href="#">Account</a>
                    <ul>
                        <li><a href="adminAccount.jsp">Edit Account</a></li>
                    </ul>
                </li>
                <li><a href="logout.jsp">Log Out</a>
            </ul>
        </nav>
        <div id="actions">           
            <input class="search" placeholder="Search" />
            <br>
            <br>
            <ul>
                <a href="signup_productmanager.html">Add Product Manager</a>
                <a href="signup_accountingmanager.html">Add Accounting Manager</a>
                <a href="viewlogs.html">View Activity Log </a>
                <a href="unlock_account.html">Unlock Account</a>
            </ul>
        </div>
    </body>
</html>
