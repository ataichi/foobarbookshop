<%-- 
    Document   : adminAccount
    Created on : Nov 15, 2014, 10:20:56 AM
    Author     : Giodee
--%>

<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeadmin = (AccountBean) session.getAttribute("homeadmin");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="jquery-2.1.0.min.js" type="text/javascript"></script>
        <script src="js-edit.js" type="text/javascript"></script>

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
            <div id="banner"> <a href="adminHOME.html"><img src="books.jpg"></a> </div>
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
            <br/><br/>
            <a href="unlock_account.html">Unlock Account</a>
        </div>
        
                <div id='editAccount'>
            <form action='EditAdminAccountServlet'>
                          <table>
                    <tr>
                        <td>First Name:
                        </td>
                        <td>
                            <input type='text' id='editfirst' name='editfirst' value='<% out.println(homeadmin.getFirstName()); %>' onblur='fnameCheck();' onfocus='backWhite(this);'/>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            Middle Name:
                        </td>
                        <td>
                            <input type='text' id='editmiddle' name='editmiddle' value='<% out.println(homeadmin.getMiddleInitial()); %>' onblur='fnameCheck();' onfocus='backWhite(this)'/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Last Name:
                        </td>
                        <td>
                            <input id='editlast' type='text' name="editlast" value='<% out.println(homeadmin.getLastName()); %>' onblur='lnameCheck();' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Username:
                        </td>
                        <td>
                            <input id='edituser' type='text' name="edituser" value='<% out.println(homeadmin.getUsername()); %>' onblur='unameCheck();' onfocus='backWhite(this);'/>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email:
                        </td>
                        <td>
                            <input id='editemail' type='email' name="editemail" value='<% out.println(homeadmin.getEmailAdd());%>' onblur='emailCheck();' onfocus='backWhite(this);'/>

                        </td>
                    </tr>
                </table>
                <input type='submit' id='save' value='Save Changes'/>
            </form>
            <a href='adminHOME.jsp'><button>Cancel</button></a>

        </div>
        

    </body>
</html>
