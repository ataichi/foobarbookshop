<%-- 
    Document   : addCreditCard
    Created on : Nov 22, 2014, 11:26:03 PM
    Author     : Giodee
--%>
<%@page import="Beans.AccountBean"%>
<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form id='addcreditcard' action='AddCreditCardServlet' method='post'>
            Card Name:<input type='text' name='cardName'/>
            Card Number:<input type='text' name='cardNo'/>
            Card Type:<input type='text' name='cardType'/>
            Expiration Date:<input type='date' name='cardExpDate'/>
            <input type='submit' value='Submit'>
        </form>
    </body>
</html>
