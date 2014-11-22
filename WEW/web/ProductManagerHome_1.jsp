   <%-- 
    Document   : ProductManagerHome
    Created on : Nov 18, 2014, 5:35:50 PM
    Author     : jao
--%>

<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeaccounting = (AccountBean) session.getAttribute("homeaccounting");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/wadesign.css">
        <link rel="stylesheet" type="text/css" href="css/category.css">
        <link rel="stylesheet" type="text/css" href="css/style4.css">
        <link rel="stylesheet" type="text/css" href="css/CSS1.css">
        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>
        <title>Account Manager</title>
        
    </head>
    
    
    <body        
             <div class="wraper">
            <div class="top">
                <header>
            <div id="banner"> <a href="login.jsp"><img src="books.jpg"/></a> </div>
        </header>

        <nav2>
            <ul>
                <li><a href="#">Hello, User!</a> </li>
                <li><a href="login.jsp">Logout</a>   </li>
            </ul>
        </nav2>

            </div>
                
            <div class="main">
                <br>
                <br>
                <br>
                <br>
                <br>
                
                 <table border="2" align="center" width="100%" border-collapse="collapse">
            <tr>
                <th>Title</th>
                <th>Stock</th>
                <th>Option</th>
            </tr>
            <tr>
                <td>The Fault In ours Stars</td>
                <td><center>8</center></td>
                <td><center><input type='button' class='AddNew' value='Add'>   |   <input type='button' class='AddNew' value='Edit'>   |   <input type='button' class='AddNew' value='Delete'></center></td>
            </tr>
            <tr>
                <td>To Kill a Mockingbird</td>
                <td><center>3</center></td>
                <td><center><input type='button' class='AddNew' value='Add'>   |   <input type='button' class='AddNew' value='Edit'>   |   <input type='button' class='AddNew' value='Delete'></center></td>
            </tr>
            <tr>
                <td>Inferno</td>
                <td><center>2</center></td>
                <td><center><input type='button' class='AddNew' value='Add'>   |   <input type='button' class='AddNew' value='Edit'>   |   <input type='button' class='AddNew' value='Delete'></center></td>
            </tr>
            <tr>
                <td>Harry Potter: Prisoner of Azkaban</td>
                <td><center>15</center></td>
                <td><center><input type='button' class='AddNew' value='Add'>   |   <input type='button' class='AddNew' value='Edit'>   |   <input type='button' class='AddNew' value='Delete'></center></td>
            </tr>
            </table>

            </div>
                 
                 <div class="left">
                <br>
                <br>
                
                
             
                
                <div id="Search" align="center">    
                    Search: <input type="text" name="search" align="right">
                </div>
                
                <br>
                <br>
                
                <nav3>
                    <ul>
                        <li><center><a href="addproduct.jsp">Add Product</a></center></li>
                    </ul>
                </nav3>
            
                <br>
                <br>
                
                <div id="Arrange">
                    <h4>  Arrange by:</h4>
                    <form>
                        <input type="radio" name="option" value="Title" checked>Title
                        <br>
                        <input type="radio" name="option" value="Amount of Stock">Amount of Stock
                    </form> 


                </div>
    </body>
</html>
