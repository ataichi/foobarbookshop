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
        <script src="js/customercheck.js" type="text/javascript"></script>

    </head>
    <body>
        <header>
            <div id="banner"> <a href="login.jsp"><img src="images/books.jpg"></a> </div>
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
            <form id="customercheck" name="customercheck" action="SignupServlet" onsubmit="return customerCheck(this);" method="post">
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
                        <td><input type='text' id='uname' name='uname' onblur="unameCheck();" onfocus="backWhite(this);"></td>
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
                <div id="billingadd">
                    <table>
                        <tr>
                            <td>Billing Address:</td>
                        </tr>
                        <tr>
                            <td>Apartment No:</td>
                            <td><input type='text' id='apartmentnoBA' name='apartmentnoBA' onblur="apartmentnoBACheck()" onfocus="backWhite()"></td>
                        </tr>
                        <tr>
                            <td>Street:</td>
                            <td><input type='text' id='streetBA' name='streetBA' onblur="streetBACheck()" onfocus="backWhite()"></td>
                        </tr>
                        <tr>
                            <td>Subdivision:</td>
                            <td><input type='text' id='subdivisionBA' name='subdivisionBA' onblur="subdivisionBACheck()" onfocus="backWhite()"></td>
                        </tr>
                        <tr>
                            <td>City:</td>
                            <td><input type='text' id='cityBA' name='cityBA' onblur="cityBACheck()" onfocus="backWhite()"></td>
                        </tr>
                        <tr>      
                            <td>Country:</td> 
                            <td><input type='text' id='countryBA' name='countryBA' onblur="countryBACheck()" onfocus="backWhite()"></td>
                        </tr>
                        <tr>
                            <td>Postal Code:</td>
                            <td><input type='text' id='postalcodeBA' name='postalcodeBA' onblur="postalcodeBACheck()" onfocus="backWhite()"></td>
                        </tr>
                        <div/>
                        <tr>
                            <td>Delivery Address:</td>
                        </tr>
                        <tr>
                            <td>Apartment No:</td>
                            <td><input type='text' id='apartmentnoDA' name='apartmentnoDA' onblur="apartmentnoDACheck()" onfocus="backWhite()"></td>
                        </tr>
                        <tr>
                            <td>Street:</td>
                            <td><input type='text' id='streetDA' name='streetDA' onblur="streetDACheck()" onfocus="backWhite()"></td>
                        </tr>
                        <tr>
                            <td>Subdivision:</td>
                            <td><input type='text' id='subdivisionDA' name='subdivisionDA' onblur="subdivisionDACheck()" onfocus="backWhite()"></td>
                        </tr>
                        <tr>
                            <td>City:</td>
                            <td><input type='text' id='cityDA' name='cityDA' onblur="cityDACheck()" onfocus="backWhite()"></td>
                        </tr>
                        <tr>      
                            <td>Country:</td> 
                            <td><input type='text' id='countryDA' name='countryDA' onblur="countryDACheck()" onfocus="backWhite()"></td>
                        </tr>
                        <tr>
                            <td>Postal Code:</td>
                            <td><input type='text' id='postalcodeDA' name='postalcodeDA' onblur="postalcodeDACheck()" onfocus="backWhite()"></td>
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
