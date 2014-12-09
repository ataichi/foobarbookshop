<%@page import="Beans.AccountBean"%>
<!DOCTYPE html>
<%
    AccountBean homeaccounting = (AccountBean) session.getAttribute("homeaccounting");
    if (homeaccounting == null) {
        response.sendRedirect("login.jsp");
    } else {
%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <%
            response.addHeader("X-FRAME-OPTIONS", "DENY");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
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
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Accounting Manager</title>
        <!-- BOOTSTRAP STYLES-->
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->
        <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
        <link href="assets/css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
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
                    <a class="navbar-brand">  Foobar</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle media-heading" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span>Jao<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="productmanagerAccount.jsp"><span class="glyphicon glyphicon-edit"></span>Account</a></li>
                                <li><a href="productManagerChangePassword.jsp"><span class="glyphicon glyphicon-pencil"></span>Change Password</a></li>
                            </ul>
                        </li>
                        <li><a href="homepage.jsp"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <br>
            <br>
                <br>
                    <div class="row">            
                        <div class="col-md-6 col-sm-12 col-xs-12">                     
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Sales by Product Type
                                </div>
                                <div class="panel-body">
                                    <div id="morris-bar-chart"></div>
                                </div>
                            </div>            
                        </div>

                        <div class="col-md-6 col-sm-12 col-xs-12">                     
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Total Sales
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="canvas" height="450" width="600"></canvas>
                                    </div>
                                </div>
                            </div>            
                        </div>
                    </div>
                    <div class="row">

                        <div class="col-md-12">

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Sales by Product
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>Username</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Mark</td>
                                                    <td>Otto</td>
                                                    <td>@mdo</td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Jacob</td>
                                                    <td>Thornton</td>
                                                    <td>@fat</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Larry</td>
                                                    <td>the Bird</td>
                                                    <td>@twitter</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--<div class="table-responsive">
                          <table class="table table-striped">
                              <thead>
                                  <tr>
                                      <th>Title</th>
                                      <th>Stocks</th>
                                      <th>Summary</th>
                                      <th>Price</th>
                                      <th>Genre</th>
                                      <th>Year</th>
                        
                                  </tr>
                              </thead>
                              <tbody>
                                  //<%
                                    //  int i;
                                      //for (i = 0; i < productlist.size(); i++) {
                                      //  out.println("<tr>"
                                      //          + "<td>"
                                      //          + productlist.get(i).getTitle()
                                      //          + "</td><td>"
                                      //          + productlist.get(i).getNumberStocks()
                                      //        + "</td><td>"
                                      //        + productlist.get(i).getSummary()
                                      //        + "</td><td>"
                                      //        + productlist.get(i).getPrice()
                                      //        + "</td><td>"
                                      //        + productlist.get(i).getGenre()
                                      //       + "</td><td>"
                                      //     + productlist.get(i).getYear()
                                      //     + "</td></tr>");
                                      // }
                        %>
                                                      </tbody>
                                                  </table>
                                              </div>
                                  </div>-->

                        <script>
                            var randomScalingFactor = function () {
                                return Math.round(Math.random() * 100)
                            };

                            var barChartData = {
                                labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
                                datasets: [
                                    {
                                        fillColor: "rgba(220,220,220,0.5)",
                                        strokeColor: "rgba(220,220,220,0.8)",
                                        highlightFill: "rgba(220,220,220,0.75)",
                                        highlightStroke: "rgba(220,220,220,1)",
                                        data: [randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor(), randomScalingFactor()]
                                    }
                                ]

                            }
                            window.onload = function () {
                                var ctx = document.getElementById("canvas").getContext("2d");
                                window.myBar = new Chart(ctx).Bar(barChartData, {
                                    responsive: true
                                });
                            }

                        </script>

                        <script src="assets/js/jquery-1.10.2.js"></script>
                        <!-- BOOTSTRAP SCRIPTS -->
                        <script src="assets/js/bootstrap.min.js"></script>
                        <!-- METISMENU SCRIPTS -->
                        <script src="assets/js/jquery.metisMenu.js"></script>
                        <!-- MORRIS CHART SCRIPTS -->
                        <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
                        <script src="assets/js/morris/morris.js"></script>
                        <!-- CUSTOM SCRIPTS -->
                        <script src="assets/js/custom.js"></script>
                        <script src="Chart.js"></script>



                        </body>
                        </html>
                        <%}%>