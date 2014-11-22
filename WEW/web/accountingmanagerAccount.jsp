<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeaccounting = (AccountBean) session.getAttribute("homeaccounting");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="jquery-2.1.0.min.js" type="text/javascript"></script>
        <script src="js-general.js" type="text/javascript"></script>
        <script src="js-edit.js" type="text/javascript"></script>
        <script src="js/editmanager.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="wadesign.css">
        <link rel="stylesheet" type="text/css" href="category.css">
        <link rel="stylesheet" type="text/css" href="style4.css">
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>

        <title>Edit Accounting Manager Account</title>
    </head>
    <body>

        <header>
            <div id="banner"> <a href="accountingmanagerHOME.jsp"><img src="images/books.jpg"></a> </div>
        </header>

        <nav>
            <ul>
                <li><a href="accountingmanagerHOME.jsp">Home</a>    </li>

                <li><a href='#'>Account</a>
                    <ul>
                        <li><a href='accountingmanagerAccount.jsp'>Edit Account</a></li>
                        <li><a href='#'>Log out</a></li>
                    </ul>
                </li>
            </ul>
        </nav>

        <div id='actions'>
            <br>
            <br>
            <a href='#'>Insert actions here</a>
            <br/>

        </div>

        <div id='editAccount'>
            <form id="editmanager" name=editmanager"" onsubmit="return editmanagerCheck()" action='EditAccountingManagerAccountServlet' method="post">
                <table>
                    <tr>
                        <td>First Name:</td>
                        <td>
                            <input type='text' id='editfirst' name='editfirst' value='<% out.println(homeaccounting.getFirstName()); %>' onblur='fnameManagerCheck();' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Middle Name:</td>
                        <td>
                            <input type='text' id='editmiddle' name='editmiddle' value='<% out.println(homeaccounting.getMiddleInitial()); %>' onblur='mnameManagerCheck();' onfocus='backWhite(this)'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td>
                            <input id='editlast' type='text' name="editlast" value='<% out.println(homeaccounting.getLastName()); %>' onblur='lnameManagerCheck();' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>Username:</td>
                        <td>
                            <input id='edituser' type='text' name="edituser" value='<% out.println(homeaccounting.getUsername()); %>' onblur='unameManagerCheck();' onfocus='backWhite(this);'/>

                        </td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>
                            <input id='editemail' type='email' name="editemail" value='<% out.println(homeaccounting.getEmailAdd());%>' onblur='emailCheck();' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                </table>

                <input type='submit' id='save' value='Save Changes'/>
            </form>
            <a href='accountingmanagerHOME.jsp'><button>Cancel</button></a>
        </div>
    </body>
</html>
