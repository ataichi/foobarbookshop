<%-- 
    Document   : adminAccount2
    Created on : 15/11/2014, 8:16:45 PM
    Author     : Evy
--%>
<%@page import="Beans.AccountBean"%>
<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeadmin");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jquery-2.1.0.min.js" type="text/javascript"></script>
        <script src="signupcheck.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="css/style4.css">
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
        <title>Admin Account</title>
    </head>
    <body>
        <%@include file="adminHOME.jsp" %>
        <div id='editAccount' class="featuredadmin">
            <form id="editadmin" name="editadmin" action="EditAdminAccountServlet" onsubmit="return editadmincheck(this)" method="post">
                <br>First Name:* <input type='text' id='editfirst' name='editfirst' value='out.println(homeuser.getFirstName());' onblur='fnameAdminCheck();' onfocus='backWhite(this);'/>
                <br>Middle Name:*<input type='text' id='editmiddle' name='editmiddle' value='out.println(homeuser.getMiddleInitial());' onblur='mnameAdminCheck();' onfocus='backWhite(this)'/>
                <br>Last Name:*  <input type='text' id='editlast' name='editlast' value='out.println(homeuser.getLastName());' onblur='lnameAdminCheck();' onfocus='backWhite(this);'/>
                <br>Username:*   <input id='edituser' type='text' name="edituser" value="homeuser.getUsername();" onblur='unameAdminCheck();' onfocus='backWhite(this);'/>
                <br>Email:*      <input id='editemail' type='email' name="editemail" value="homeuser.getEmailAdd();" onblur='emailAdminCheck();' onfocus='backWhite(this);'/>
                <br>
                <br>
                <input type='submit' class="savechanges" id='save' value='Save Changes'/>
                <a href='adminHOME.jsp'><button class="canceladmin">Cancel</button></a>          
            </form> 

        </div>
    </body>
</html>
