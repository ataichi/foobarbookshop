<%-- 
    Document   : login
    Created on : 14/11/2014, 12:16:10 AM
    Author     : Evy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/wadesign.css">
        <link rel="stylesheet" type="text/css" href="css/category.css">
        <link rel="stylesheet" type="text/css" href="css/style4.css">
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
        <title>Foobar Log In</title>

    </head>
    <body>
        <header>
            <div id="banner"> <a href="login.jsp"><img src="images/books.jpg"/></a> </div>
        </header>

        <nav>
            <ul>
                <li><a href="adWall3DFull.html">Home</a>    </li>
                <li><a href="#">Category</a>
                    <ul>
                        <li><a href="#">Books</a></li>
                        <li><a href="#">Magazines</a></li>
                        <li><a href="#">Audio CDs</a></li>
                        <li><a href="#">DVDs</a></li>
                    </ul>
                </li>
                <li><a href="signup.jsp">Register</a>   </li>
            </ul>
        </nav>


        <div id="loginform">
            <form id="logform" name="login" onsubmit="return logcheck();" method="post" action="LoginServlet">
                <div id="block2">
                    <div id="un">Username: <input type='text' id='loguser' name='loguser' onblur="usernameCheck();" onfocus="backWhite(this);" required /></div>
                    <div id="pw">Password: <input type='password' id='logpass' name='logpass' onblur="passwordCheck();" onfocus="backWhite(this);" required /></div>
                </div>

                <center>
                    <div id="button2">
                        <input type="submit" id="log" class="images/submitstyle2" value="" />
                    </div></center>
            </form>
        </div>
    </body>
</html>
