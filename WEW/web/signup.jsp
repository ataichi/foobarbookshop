<%-- 
    Document   : signup
    Created on : 14/11/2014, 1:31:11 AM
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
        <title>Sign up now!</title>

        <script src="jquery-2.1.0.min.js" type="text/javascript"></script>
        <script src="js-signupcheck.js" type="text/javascript"></script>
        <script src="js-general.js" type="text/javascript"></script>
    </head>
    <body>
        <header>
            <div id="banner"> <a href="login.jsp"><img src="books.jpg"></a> </div>
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
                <li><a href="login.jsp">Login</a>   </li>
            </ul>
        </nav>

        <div id="featured">
            <form id="signform" name="signin" action="SignupServlet" onsubmit="return signcheck(this);" method="post">

                <table>
                    <tr>
                        <td>First Name</td>
                        <td><input type='text' id='fname' name='fname' onblur="fnameCheck();" onfocus="backWhite(this);"></td>
                    </tr>
                    <tr>
                        <td>Middle Initial</td>
                        <td><input type='text' id='mname' name='mname' onblur='mnameCheck()' onfocus='backWhite(this)'></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type='text' id='lname' name='lname' onblur="lnameCheck();" onfocus="backWhite(this);"></td>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td><input type='text' id='user' name='uname' onblur="unameCheck();" onfocus="backWhite(this);"></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type='text' id='email' name='email' onblur="emailCheck();" onfocus="backWhite(this);"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type='password' id='pass1' name='pass1' onblur="passCheck();" onfocus="backWhite(this);"></td>
                    </tr>
                    <tr>
                        <td>Verify Password</td>
                        <td><input type='password' id='pass2' name='pass2' onblur="passCheck();" onfocus="backWhite(this);"></td>
                    </tr>
                </table>
                <div id="address">
                    <table>

                        <tr>
                            <td>Billing Address:</td>
                            <td><input type='text' id='billingAddress' name='billingAddress' onblur="apartmentnoBACheck()" onfocus="backWhite()"></td>
                        </tr>
                        <tr>
                            <td>Shipping Address:</td>
                            <td><input type='text' id='shippingAddress' name='shippingAddress' onblur="streetBACheck()" onfocus="backWhite()"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type='submit' id='sign' value='Signup'></td>
                        </tr>
                    </table>


            </form>

        </div>


    </body>
</html>
