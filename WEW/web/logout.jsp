<%-- 
    Document   : logout
    Created on : 18/11/2014, 3:46:11 AM
    Author     : Evy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <% response.addHeader("X-FRAME-OPTIONS", "DENY");
        %>
        <style id="antiClickjack">body{display:none !important;}</style>
        <script type="text/javascript">
            if (self === top) {
                var antiClickjack = document.getElementById("antiClickjack");
                antiClickjack.parentNode.removeChild(antiClickjack);
            } else {
                top.location = self.location;
            }
        </script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Successful</title>
    </head>
    <body>
        <%@include file="login.jsp" %>
        <h4 style="position: absolute; color: red; top:500px; left:480px;">You have succesfully logged out from foobar!<br></h4>
    </body>
</html>
