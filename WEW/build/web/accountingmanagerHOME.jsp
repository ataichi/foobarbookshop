<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeaccounting = (AccountBean) session.getAttribute("homeaccounting");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="jquery-2.1.0.min.js" type="text/javascript"></script>
        <script src="js-general.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="css/wadesign.css">
        <link rel="stylesheet" type="text/css" href="css/category.css">
        <link rel="stylesheet" type="text/css" href="css/style4.css">
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
        <title>Accounting Manager Home</title>
    </head>
    <body>

        <header>
            <div id="banner"> <a href="accountingmanagerHOME.jsp"><img src="images/books.jpg"></a> </div>
        </header>
        <nav>
            <ul>
                <li><a href="accountingmanagerHOME.jsp">Home</a>    </li>

                <li><a href='#'>Account
                        <ul>
                            <li><a href='accountingmanagerAccount.jsp'>Edit Account</a></li>
                            <li><a href='#'>Log out</a></li>
                        </ul>
                </li>
            </ul>
        </nav>
        <div id='actions'>
            <br>
            <br>
            <a href='#'>Insert actions here</a>
            <br/>

        </div>

    </body>
</html>
