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
        <script src="signupcheck.js" type="text/javascript"></script>
        <script src="editadmincheck.js" type="text/javascript"></script>

        <link rel="stylesheet" type="text/css" href="css/wadesign.css">
        <link rel="stylesheet" type="text/css" href="css/category.css">
        <link rel="stylesheet" type="text/css" href="css/style4.css">
        <link rel="stylesheet" type="text/css" href="js/editadmincheck.js">

        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>


        <title>Admin Account</title>

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
            <br/><br/>
            <a href="unlock_account.jsp">Unlock Account</a>
        </div>

        <div id='editAccount'>
            <form id="editadmin" name="editadmin" action='EditAdminAccountServlet' onsubmit="return editadmincheck(this)" method="post">
                First Name:* &nbsp;&nbsp;&nbsp;&nbsp;
                <input type='text' id='editfirst' name='editfirst' value='<% out.println(homeuser.getFirstName()); %>' onblur='fnameAdminCheck();' onfocus='backWhite(this);'/>
                <br/>
                Middle Name* &nbsp;
                <input type='text' id='editmiddle' name='editmiddle' value='<% out.println(homeuser.getMiddleInitial()); %>' onblur='mnameAdminCheck();' onfocus='backWhite(this)'/>
                <br/>
                Last Name:* &nbsp;&nbsp;&nbsp;&nbsp;
                <input id='editlast' type='text' name="editlast" value='<% out.println(homeuser.getLastName()); %>' onblur='lnameAdminCheck();' onfocus='backWhite(this);'/>
                <br/>
                Username:*  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input id='edituser' type='text' name="edituser" value='<% out.println(homeuser.getUsername()); %>' onblur='unameAdminCheck();' onfocus='backWhite(this);'/>
                <br/>
                Email:*    &nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input id='editemail' type='email' name="editemail" value='<% out.println(homeuser.getEmailAdd());%>' onblur='emailAdminCheck();' onfocus='backWhite(this);'/>
                <br/><br/>

                </table>
                <input type='submit' id='save' value='Save Changes'/>
            </form>
            <a href='adminHOME.jsp'><button>Cancel</button></a>
        </div>
    </body>
</html>
