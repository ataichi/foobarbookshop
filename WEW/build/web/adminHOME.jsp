<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeadmin");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <script src="jquery-2.1.0.min.js" type="text/javascript"></script>
        <script src="js-edit.js" type="text/javascript"></script>
        <script src="js-general.js" type="text/javascript"></script>
        
        <link rel="stylesheet" type="text/css" href="css/wadesign.css">
        <link rel="stylesheet" type="text/css" href="css/category.css">
        <link rel="stylesheet" type="text/css" href="css/style4.css">
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>


        <title>Admin Home</title>

    </head>
    <body>


        <header>
            <div id="banner"> <a href="adminHOME.jsp"><img src="images/books.jpg"></a> </div>
        </header>

<nav>
            <ul>
                <li><a href="adminHOME.jsp">Home</a>    </li>
                <li><a href='#'>Account
                        <ul>
                            <li><a href='adminAccount.jsp'>Edit Account</a></li>
                            <li><a href='#'>Log out</a></li>
                        </ul>
                </li>
        </nav>

        <div id="actions">
            <br>
            <br>
            <a href="signup_productmanager.html">Add Product Manager</a>
            <br>
            <br>
            <a href="signup_accountingmanager.html">Add Accounting Manager</a>
            <br>
            <br>
            <a href="viewlogs.html">View Activity Log </a>
            <br>
            <br>
            <a href="unlock_account.jsp">Unlock Account</a>
        </div>
    </body>
</html>
