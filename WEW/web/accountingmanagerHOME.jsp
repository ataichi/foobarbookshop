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
        <title>Accounting Manager</title>
        
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
                
            <div class="main2">
                <br>
                <br>
   
                
                <div class="one">
                <h5>Sales by Day</h5>

                    <br>
                        <center><div style="height: 22px;" class="bar"><center>1</center></div>
                     <div style="height: 200px;" class="bar"><center>2</center></div>
                     <div style="height: 6px;" class="bar"><center>3</center></div>
                     <div style="height: 49px;" class="bar"><center>4</center></div>
                     <div style="height: 28px;" class="bar"><center>5</center></div>
                        <div style="height: 28px;" class="bar"><center>6</center></div>
                        <div style="height: 28px;" class="bar"><center>7</center></div>
                        <div style="height: 22px;" class="bar"><center>8</center></div>
                     <div style="height: 200px;" class="bar"><center>9</center></div>
                     <div style="height: 6px;" class="bar"><center>10</center></div>
                     <div style="height: 49px;" class="bar"><center>11</center></div>
                     <div style="height: 28px;" class="bar"><center>12</center></div>
                        <div style="height: 28px;" class="bar"><center>13</div>
                        <div style="height: 28px;" class="bar"><center>14</center></div>
                        <div style="height: 22px;" class="bar"><center>15</center></div>
                     <div style="height: 200px;" class="bar"><center>16</center></div>
                     <div style="height: 6px;" class="bar"><center>17</center></div>
                     <div style="height: 49px;" class="bar"><center>18</center></div>
                     <div style="height: 28px;" class="bar"><center>19</center></div>
                        <div style="height: 28px;" class="bar"><center>20</div>
                        <div style="height: 28px;" class="bar"><center>21</center></div>
                        <div style="height: 22px;" class="bar"><center>22</center></div>
                     <div style="height: 200px;" class="bar"><center>23</center></div>
                     <div style="height: 6px;" class="bar"><center>24</center></div>
                     <div style="height: 49px;" class="bar"><center>25</center></div>
                     <div style="height: 28px;" class="bar"><center>26</center></div>
                        <div style="height: 28px;" class="bar"><center>27</div>
                        <div style="height: 28px;" class="bar"><center>28</center></div>
                     <div style="height: 49px;" class="bar"><center>29</center></div>
                     <div style="height: 28px;" class="bar"><center>30</center></div>
                        <div style="height: 28px;" class="bar"><center>31</center></div></center>
                </div>
                <div class="two">
                <h5>Sales by Week</h5>
                <br>
                        <center><div style="height: 22px;" class="barweek"><center>Sun</center></div>
                        <div style="height: 200px;" class="barweek"><center>M</center></div>
                        <div style="height: 6px;" class="barweek"><center>T</center></div>
                        <div style="height: 49px;" class="barweek"><center>W</center></div>
                        <div style="height: 28px;" class="barweek"><center>Th</center></div>
                        <div style="height: 28px;" class="barweek"><center>F</div>
                        <div style="height: 28px;" class="barweek"><center>Sat</center></div></center>
                </div>
                <div class="three">
                <h5>Sales by Month</h5>
                <br>
                <center><div style="height: 22px;" class="barmonth"><center>J</center></div>
                        <div style="height: 200px;" class="barmonth"><center>F</center></div>
                        <div style="height: 6px;" class="barmonth"><center>Ma</center></div>
                        <div style="height: 49px;" class="barmonth"><center>Ap</center></div>
                        <div style="height: 28px;" class="barmonth"><center>My</center></div>
                        <div style="height: 28px;" class="barmonth"><center>Jn</center></div>
                        <div style="height: 28px;" class="barmonth"><center>Jl</center></div>
                        <div style="height: 28px;" class="barmonth"><center>A</center></div>
                        <div style="height: 28px;" class="barmonth"><center>Sp</center></div>
                        <div style="height: 28px;" class="barmonth"><center>Oc</center></div>
                        <div style="height: 28px;" class="barmonth"><center>Nv</center></div>
                        <div style="height: 28px;" class="barmonth"><center>Dc</center></div></center>
                </div>
                <div class="four">
                    <h5>Sales by Year</h5>
                    <center>
                    <div style="height: 95px;" class="baryear"><center>2012</center></div>
                    <div style="height: 75px;" class="baryear"><center>2013</center></div>
                    <div style="height: 28px;" class="baryear"><center>2014</center></div>
                    </center>
                </div>
                
            </div>
                 
        
                 
                <script>
                    
                    $('.AddNew').click(function(){
                        var row = $(this).closest('tr').clone();
                        row.find('input').val('');
                        $(this).closest('tr').after(row);
                        $('input[type="button"]', row).removeClass('AddNew').addClass('RemoveRow').val('Remove item');
                    });


                    $('table').on('click', '.RemoveRow', function(){
                         $(this).closest('tr').remove();
                    });
                    
                </script>
    </body>
</html>
