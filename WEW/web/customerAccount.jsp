<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeuser = (AccountBean) session.getAttribute("homeuser");
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
        <script src="js/customercheck.js" type="text/javascript"></script>
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
            <div id="banner"> <a href="customerHOME.jsp"><img src="images/books.jpg"></a> </div>
        </header>

        <nav>
            <ul>
                <li><a href="customerHOME.jsp">Home</a>    </li>
                <li><a href="#">Category</a>
                    <ul>
                        <li><a href="#">Books</a></li>
                        <li><a href="#">Magazines</a></li>
                        <li><a href="#">Audio CDs</a></li>
                        <li><a href="#">DVDs</a></li>
                    </ul>
                </li>
                <li><a href='#'>Account</a>
                    <ul>
                        <li><a href='customerAccount.jsp'>Edit Account</a></li>
                        <li><a href='#'>Log out</a></li>
                    </ul>
                </li>
            </ul>
        </nav>

        <div id='actions'>
            <br>
            <br>
            <a href='customerBilling.jsp'>Manage Billing Information</a>
            <br/>
            <br>

            <a href='customerPayments.jsp'>Manage Payment Information</a>
            <br/>
            <br>
            <a href='customerTransactions.jsp'>View Transactions</a>
            <br/>
        </div>

        <div id='editAccount'>
            <form name="customercheck" id="customercheck" onsubmit="return customerCheck(this)" action='EditCustomerAccountServlet' method="post">
                <table>
                    <tr>
                        <td>First Name:
                        </td>
                        <td>
                            <input type='text' id='fname' name='fname' value='<% out.println(homeuser.getFirstName()); %>' onblur='fnameCheck();' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Middle Name:
                        </td>
                        <td>
                            <input type='text' id='mname' name='fname' value='<% out.println(homeuser.getMiddleInitial()); %>' onblur='fnameCheck();' onfocus='backWhite(this)'/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Last Name:
                        </td>
                        <td>
                            <input id='lname' type='text' name="fname" value='<% out.println(homeuser.getLastName()); %>' onblur='lnameCheck();' onfocus='backWhite(this);'/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Username:
                        </td>
                        <td>
                            <input id='uname' type='text' name="uname" value='<% out.println(homeuser.getUsername()); %>' onblur='unameCheck();' onfocus='backWhite(this);'/>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email:
                        </td>
                        <td>
                            <input id='email' type='email' name="email" value='<% out.println(homeuser.getEmailAdd());%>' onblur='emailCheck();' onfocus='backWhite(this);'/>

                        </td>
                    </tr>
                </table>
                <input type='submit' id='save' value='Save Changes'/>
            </form>
            <a href='customerHOME.jsp'><button>Cancel</button></a>

        </div>

    </body>
</html>
