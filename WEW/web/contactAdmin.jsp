<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <title>Contact Admin</title>

    </head>
    <body>
        <!-- Fixed navbar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="homepage.jsp">Foobar</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="homepage.jsp">Home</a></li>    
                        <li><a href="#about">About</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>

        <div class='container-fluid' style="padding-top:100px;">
            <div class="row" style="padding-left: 400px">
                <div class="alert alert-danger col-md-8" role="alert">
                    <strong>Unfortunately, you're account got locked. Contact the Administrator to unlock.</strong>
                </div>
            </div>
            <div class="panel-body"  style="padding-left: 600px">
                <form class="col-md-4" id="login" name="login" onsubmit="return logcheck();" method="post" action="SendReport">
                    <div class="form-group">
                        <label class="control-label col-lg-4" for="email">Email Address</label>
                        <input id="email" name='email' onblur="emailCheck();" onfocus="backWhite(this);" type="text" class="form-control input-lg" placeholder="yourname@foobar.com">
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-4" for="email">Reason</label>
                        <input id="reason" name='reason' onfocus="backWhite(this);" type="text" class="form-control input-lg" placeholder="Enter reason" required>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary btn-lg btn-block">Send Report</button>
                    </div>
                </form>
            </div>

        </div>
        <script src="dist/js/jquery-2.1.0.min.js"></script>
        <script src="dist/js/query.js"></script>
        <script src="dist/js/bootstrap.min.js"></script>
    </body>
</html>
