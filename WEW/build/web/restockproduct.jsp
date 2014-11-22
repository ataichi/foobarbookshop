<%-- 
    Document   : restockproduct
    Created on : Nov 23, 2014, 12:40:16 AM
    Author     : Giodee
--%>

<%@page import="Beans.ProductBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ProductBean restockproduct = (ProductBean) session.getAttribute("restockproduct");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form id='restockproduct' action='ConfirmRestockProductServlet' method='post'>
            Title: <% out.println(restockproduct.getTitle()); %>
            Stocks: <input type='text' name='numberstocks' value='<%out.println(restockproduct.getNumberStocks());%>'/>
        </form>
    </body>
</html>
