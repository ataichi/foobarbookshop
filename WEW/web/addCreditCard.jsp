<%-- 
    Document   : addCreditCard
    Created on : Nov 22, 2014, 11:26:03 PM
    Author     : Giodee
--%>
<%@page import="Beans.CreditCardBean"%>
<%@page import="Beans.CustomerBean"%>
<%@page import="Beans.AccountBean"%>
<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
    CustomerBean tempcustomer = (CustomerBean) session.getAttribute("tempcustomer");
    CreditCardBean creditcard = (CreditCardBean) session.getAttribute("creditcard");
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
            Card Name:<input type='text' name='cardName' value='<%out.println(creditcard.getCardname());%> '/>
            <br/>
            Card Number:<input type='text' name='cardNo' value='<%out.println(creditcard.getCardno());%>'/>
            <br/>
            Card Type:<input type='text' name='cardType' value='<%out.println(creditcard.getCardtype());%>'/>
            <br/>
            Expiration Date:<input type='date' name='cardExpDate'/>
            <br/>
            <input type='submit' value='Submit'>
        </form>
    </body>
</html>
