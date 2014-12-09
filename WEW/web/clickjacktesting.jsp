<!-- FOR CLICK JACKING TESTING HEHE LETS GO W3W -->
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
        <title>Clickjack test page</title>
    </head>
    <body>
        <p>If the page below displayed ..you've been clickjacked! HEHE natest na sa jsps natin woo it won't work pero pag tinanggal mu yung sa header it will work!</p>
        <iframe sandbox="allow-scripts allow-forms" src="http://localhost:8080/" style="width:100%;height:90%"></iframe>
    </body>
</html>
