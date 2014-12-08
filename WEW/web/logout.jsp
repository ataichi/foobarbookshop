<% 
    session.invalidate();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Successful</title>
    </head>
    <body>
        <%@include file="login.jsp" %>
        <h4 style="position: absolute; color: red; top:500px; left:480px;">You have succesfully logged out from foobar!<br></h4>
    </body>
</html>
