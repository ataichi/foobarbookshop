<%-- 
    Document   : customeraccount2
    Created on : 17/11/2014, 7:02:59 PM
    Author     : Evy
--%>
<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jquery-2.1.0.min.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="css/style4.css">
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>

        <title>Edit Account</title>
    </head>
    <body>

        <%@include file="customerHOME.jsp" %>
        <div id='editAccount' class="featuredadmin">
            <form id="editadmin" action='EditCustomerAccountServlet'>
                <br>First Name:<input type='text' id='editfirst' name='editfirst' value=' out.println(homeuser.getFirstName()); ' onblur='fnameCheck();' onfocus='backWhite(this);'/>
                <br>Middle Name:<input type='text' id='editmiddle' name='editmiddle' value=' out.println(homeuser.getMiddleInitial()); ' onblur='fnameCheck();' onfocus='backWhite(this)'/>
                <br>Last Name:<input id='editlast' type='text' name="editlast" value=' out.println(homeuser.getLastName()); ' onblur='lnameCheck();' onfocus='backWhite(this);'/>
                <br>Username:<input id='edituser' type='text' name="edituser" value=' out.println(homeuser.getUsername()); ' onblur='unameCheck();' onfocus='backWhite(this);'/>
                <br>Email:<input id='editemail' type='email' name="editemail" value=' out.println(homeuser.getEmailAdd());' onblur='emailCheck();' onfocus='backWhite(this);'/>
                <br>
                <br>
                <input type='submit' id='save' class="savechanges" value='Save Changes'/>
                <a href='customerHOME.jsp'><button class="canceladmin">Cancel</button></a>
            </form>
        </div>

    </body>
</html>
