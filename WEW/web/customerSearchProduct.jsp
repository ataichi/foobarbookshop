<%-- 
    Document   : customerSearchProduct
    Created on : Nov 23, 2014, 7:50:03 PM
    Author     : Giodee
--%>

<%@page import="Beans.AccountBean"%>
<%@page import="Beans.MagazineBean"%>
<%@page import="Beans.DVDBean"%>
<%@page import="Beans.BookBean"%>
<%@page import="Beans.AudioCDBean"%>
<%@page import="Beans.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
    ArrayList<ProductBean> searchproductlist = (ArrayList<ProductBean>) session.getAttribute("searchproductlist");
    ArrayList<AudioCDBean> searchaudiocdlist = (ArrayList<AudioCDBean>) session.getAttribute("searchaudiocdlist");
    ArrayList<BookBean> searchbooklist = (ArrayList<BookBean>) session.getAttribute("searchbooklist");
    ArrayList<DVDBean> searchdvdlist = (ArrayList<DVDBean>) session.getAttribute("searchdvdlist");
    ArrayList<MagazineBean> searchmagazinelist = (ArrayList<MagazineBean>) session.getAttribute("searchmagazinelist");
    ProductBean product = new ProductBean();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            /* out.println("<table><tr><td>Product</td>"
             + "<td>Details</td></tr>"
             + "</table>");
             */
            if (searchproductlist.size() > 0) { //not empty
                for (int i = 0; i < searchproductlist.size(); i++) {
                    out.println("Title:" + searchproductlist.get(i).getTitle()
                            + "<br/>Price:" + searchproductlist.get(i).getPrice()
                            + "<br/>Product Type:" + searchproductlist.get(i).getType()
                            + "<form action='ViewProductServlet' method='post'>"
                            + "<input type='hidden' name='product' value='" + searchproductlist.get(i).getProductID() + "'/>"
                            + "<input type='submit' value='View' name='viewProduct'/></form>"
                            + "<form action='AddToShoppingCartServlet' method='post'>"
                            + "<input type='hidden' name='product' value='" + searchproductlist.get(i).getProductID() + "'/>"
                            + "<input type='number' name='quantity'/>"
                            + "<input type='submit' name='action' value='Add to Cart'/>"
                            + "<input type='submit' name='action' value='Buy'/></form>"
                            + "<br/><br/>"
                    );
                }
            }


        %>

    </body>
</html>
