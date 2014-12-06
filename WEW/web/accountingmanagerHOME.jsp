<%@page import="Beans.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountBean homeaccounting = (AccountBean) session.getAttribute("homeaccounting");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <script src="js/customercheck.js" type="text/javascript"></script>
        <link href="css/wadesign.css" rel="stylesheet">
        <link href="dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="dist/css/dashboard.css" rel="stylesheet">
        <link href="dist/css/morris.css" rel="stylesheet">
        <link href="dist/css/font-awesome.min.css" rel="stylesheet">
        <title>Accounting Manager</title>      
    </head>
    <body>        
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Foobar</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span><% out.println(" " + homeaccounting.getUsername());%> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="accountingmanagerAccount.jsp"><span class="glyphicon glyphicon-edit"></span>Account</a></li>
                                <li><a href="changepassword.jsp"><span class="glyphicon glyphicon-pencil"></span>Change Password</a></li>
                            </ul>
                        </li>
                        <li><a href="homepage.jsp"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                    </ul>
                    <form class="navbar-form navbar-right" action='CustomerSearchProductServlet' method="post">
                        <div class="input-group input-group-sm" style="max-width:360px;">
                            <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
                            <div class="input-group-btn">
                                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </nav>
                            
                            
                            
        <div class="wraper">
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

                $('.AddNew').click(function () {
                    var row = $(this).closest('tr').clone();
                    row.find('input').val('');
                    $(this).closest('tr').after(row);
                    $('input[type="button"]', row).removeClass('AddNew').addClass('RemoveRow').val('Remove item');
                });


                $('table').on('click', '.RemoveRow', function () {
                    $(this).closest('tr').remove();
                });

            </script>

            <script src="dist/js/jquery-2.1.0.min.js"></script>
            <script src="dist/js/query.js"></script>
            <script src="dist/js/bootstrap.min.js"></script>
    </body>
</html>
