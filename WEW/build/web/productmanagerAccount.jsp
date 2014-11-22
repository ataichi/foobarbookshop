<%@page import="Beans.AccountBean"%>

<%
    AccountBean homeproduct = (AccountBean) session.getAttribute("homeproduct");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script src="jquery-2.1.0.min.js" type="text/javascript"></script>
        <script src="js-general.js" type="text/javascript"></script>
        <script src="js-edit.js" type="text/javascript"></script>
        <script src="js/managercheck.js" type="text/javascript"></script>

        <link rel="stylesheet" type="text/css" href="wadesign.css">
        <link rel="stylesheet" type="text/css" href="category.css">
        <link rel="stylesheet" type="text/css" href="style4.css">
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>

        <title>Edit Account</title>
    </head>
    <body>
        <header>
            <div id="banner"> <a href="login.html"><img src="images/books.jpg"></a> </div>
        </header>
        <nav>
            <ul>
                <li><a href="productmanagerHOME.html">Home</a>    </li>
                <li><a href='#'>Account
                        <ul>
                            <li><a href='productmanagerAccount.jsp'>Edit Account</a></li>
                            <li><a href='#'>Log out</a></li>
                        </ul>
                </li>
            </ul>
        </nav>

        <div id="actions">
            <br/>
            <br/>
            <a href="addproduct.jsp">Add Product</a>
            <br>
            <br>
            <br>
        </div>

        <div id='editAccount'>
            <form id="managercheck" name="managercheck" onsubmit="return managerCheck(this)" action='EditProductManagerAccountServlet' method="post">
                <table>
                    <tr>
                        <td>First Name:</td>
                        <td>
                            <input type='text' id='editfirst' name='editfirst' value='<% out.println(homeproduct.getFirstName()); %>' onblur='fnameManagerCheck();' onfocus='backWhite(this);'/>

                        </td>
                    </tr>
                    <tr>
                        <td>Middle Name:</td>
                        <td>
                            <input type='text' id='editmiddle' name='editmiddle' value='<% out.println(homeproduct.getMiddleInitial()); %>' onblur='mnameManagerCheck();' onfocus='backWhite(this)'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td>
                            <input id='editlast' type='text' name="editlast" value='<% out.println(homeproduct.getLastName()); %>' onblur='lnameManagerCheck();' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Username:</td>
                        <td>
                            <input id='edituser' type='text' name="edituser" value='<% out.println(homeproduct.getUsername()); %>' onblur='unameManagerCheck();' onfocus='backWhite(this);'/>

                        </td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>
                            <input id='editemail' type='email' name="editemail" value='<% out.println(homeproduct.getEmailAdd());%>' onblur='emailManagerCheck();' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                </table>
                <input type='submit' id='save' value='Save Changes'/>
            </form>
            <a href='productmanagerHOME.jsp'><button>Cancel</button></a>
    </body>
</html>
