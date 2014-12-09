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
        <title>Failure to sign up.</title>
    </head>
    <body>
        <%@include file="signup.jsp" %>
        <h4 style="position: absolute; color: red; top:500px; left:480px;">Something went wrong. Please try again!<br></h4>
    </body>
</html>
