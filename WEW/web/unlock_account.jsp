<%@page import="Beans.AccountBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Implementation.AccountDAOImplementation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeadmin");
    AccountDAOImplementation adao = new AccountDAOImplementation();
    ArrayList<AccountBean> accountlist = adao.getAllLockedAccounts();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="jquery-2.1.0.min.js" type="text/javascript"></script>
        <script src="js-edit.js" type="text/javascript"></script>

        <link rel="stylesheet" type="text/css" href="css/wadesign.css">
        <link rel="stylesheet" type="text/css" href="css/category.css">
        <link rel="stylesheet" type="text/css" href="css/style4.css">
        <link rel="stylesheet" type="text/css" href="js/editadmincheck.js">

        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>

        <title>Unlock Account</title>
    </head>
    <body>

        <header>
            <div id="banner"> <a href="adminHOME.html"><img src="images/books.jpg"></a> </div>
        </header>
        <nav>
            <ul>
                <li><a href="home.html">Home</a>    </li>
                <li><a href='#'>Account
                        <ul>
                            <li><a href='adminAccount.jsp'>Edit Account</a></li>
                            <li><a href='#'>Log out</a></li>
                        </ul>
                </li>
            </ul>
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

        <div id="unlockaccount">

            <table>
                <tr>
                    <td>Account ID</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Account Type</td>
                    <td>Unlock</td>
                </tr> 
                <%
                    int i = 0;
                    for (i = 0; i < accountlist.size(); i++) {
                %>
                <form id="unlock <% accountlist.get(i).getAccountID(); %>" name="unlock<% accountlist.get(i).getAccountID(); %>" action="UnlockAccountServlet" method="post">

                    <tr>
                    <input type="text" id="accountid" name="accountid" value="<% accountlist.get(i).getAccountID(); %>"/>
                    <input type="text" id="fname" name="fname" value="<% accountlist.get(i).getFirstName();%> "></input>
                    <input type="text" id="lname" name="lname" value="<% accountlist.get(i).getLastName();%> "></input>
                    <input type="text" id="type" name="type" value="<% accountlist.get(i).getAccountType();%> "></input>
                    <input type="submit" value="unlock" name="unlock<% accountlist.get(i).getAccountID(); %>"/>
                    </tr>

                </form>
                <%
                    }
                %>

            </table>


        </div>

    </body>
</html>
