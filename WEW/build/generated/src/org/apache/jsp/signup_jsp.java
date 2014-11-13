package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/wadesign.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/category.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style4.css\">\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>\n");
      out.write("        <title>Sign up now!</title>\n");
      out.write("\n");
      out.write("        <script src=\"jquery-2.1.0.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js-signupcheck.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js-general.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div id=\"banner\"> <a href=\"login.jsp\"><img src=\"books.jpg\"></a> </div>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <nav>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"adWall3DFull.html\">Home</a>    </li>\n");
      out.write("                <li><a href=\"#\">Category</a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\">Books</a></li>\n");
      out.write("                        <li><a href=\"#\">Magazines</a></li>\n");
      out.write("                        <li><a href=\"#\">Audio CDs</a></li>\n");
      out.write("                        <li><a href=\"#\">DVDs</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"login.jsp\">Login</a>   </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("    <div id= \"signupcontainer\">\n");
      out.write("        <form id=\"signform\" name=\"signin\" action=\"SignupServlet\" onsubmit=\"return signcheck(this);\" method=\"post\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>First Name</td>\n");
      out.write("                    <td><input type='text' id='fname' name='fname' onblur=\"fnameCheck();\" onfocus=\"backWhite(this);\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Middle Initial</td>\n");
      out.write("                    <td><input type='text' id='mname' name='mname' onblur='mnameCheck()' onfocus='backWhite(this)'></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Last Name</td>\n");
      out.write("                    <td><input type='text' id='lname' name='lname' onblur=\"lnameCheck();\" onfocus=\"backWhite(this);\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Username</td>\n");
      out.write("                    <td><input type='text' id='user' name='uname' onblur=\"unameCheck();\" onfocus=\"backWhite(this);\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Email</td>\n");
      out.write("                    <td><input type='text' id='email' name='email' onblur=\"emailCheck();\" onfocus=\"backWhite(this);\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Password</td>\n");
      out.write("                    <td><input type='password' id='pass1' name='pass1' onblur=\"passCheck();\" onfocus=\"backWhite(this);\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Verify Password</td>\n");
      out.write("                    <td><input type='password' id='pass2' name='pass2' onblur=\"passCheck();\" onfocus=\"backWhite(this);\"></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Billing Address:</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Apartment No:</td>\n");
      out.write("                    <td><input type='text' id='apartmentnoBA' name='apartmentnoBA' onblur=\"apartmentnoBACheck()\" onfocus=\"backWhite()\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Street:</td>\n");
      out.write("                    <td><input type='text' id='streetBA' name='streetBA' onblur=\"streetBACheck()\" onfocus=\"backWhite()\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Subdivision:</td>\n");
      out.write("                    <td><input type='text' id='subdivisionBA' name='subdivisionBA' onblur=\"subdivisionBACheck()\" onfocus=\"backWhite()\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>City:</td>\n");
      out.write("                    <td><input type='text' id='cityBA' name='cityBA' onblur=\"cityBACheck()\" onfocus=\"backWhite()\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>      \n");
      out.write("                    <td>Country:</td> \n");
      out.write("                    <td><input type='text' id='countryBA' name='countryBA' onblur=\"countryBACheck()\" onfocus=\"backWhite()\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Postal Code:</td>\n");
      out.write("                    <td><input type='text' id='postalcodeBA' name='postalcodeBA' onblur=\"postalcodeBACheck()\" onfocus=\"backWhite()\"></td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>Delivery Address:</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Apartment No:</td>\n");
      out.write("                    <td><input type='text' id='apartmentnoDA' name='apartmentnoDA' onblur=\"apartmentnoDACheck()\" onfocus=\"backWhite()\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Street:</td>\n");
      out.write("                    <td><input type='text' id='streetDA' name='streetDA' onblur=\"streetDACheck()\" onfocus=\"backWhite()\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Subdivision:</td>\n");
      out.write("                    <td><input type='text' id='subdivisionDA' name='subdivisionDA' onblur=\"subdivisionDACheck()\" onfocus=\"backWhite()\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>City:</td>\n");
      out.write("                    <td><input type='text' id='cityDA' name='cityDA' onblur=\"cityDACheck()\" onfocus=\"backWhite()\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>      \n");
      out.write("                    <td>Country:</td> \n");
      out.write("                    <td><input type='text' id='countryDA' name='countryDA' onblur=\"countryDACheck()\" onfocus=\"backWhite()\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Postal Code:</td>\n");
      out.write("                    <td><input type='text' id='postalcodeDA' name='postalcodeDA' onblur=\"postalcodeDACheck()\" onfocus=\"backWhite()\"></td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td><input type='submit' id='sign' value='Signup'></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    <div/>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
