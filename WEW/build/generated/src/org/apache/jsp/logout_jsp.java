package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class logout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/login.jsp");
  }

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
      out.write("        <title>Logout Successful</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/wadesign.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/category.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style4.css\">\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>\r\n");
      out.write("        <title>Foobar Log In</title>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("            <div id=\"banner\"> <a href=\"login.jsp\"><img src=\"books.jpg\"/></a> </div>\r\n");
      out.write("        </header>\r\n");
      out.write("\r\n");
      out.write("        <nav>\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"home.html\">Home</a>    </li>\r\n");
      out.write("                <li><a href=\"#\">Category</a>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"#\">Books</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Magazines</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Audio CDs</a></li>\r\n");
      out.write("                        <li><a href=\"#\">DVDs</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"signup.jsp\">Register</a>   </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"loginform\">\r\n");
      out.write("            <form id=\"logform\" name=\"login\" onsubmit=\"return logcheck();\" method=\"post\" action=\"LoginServlet\">\r\n");
      out.write("                <div id=\"block2\">\r\n");
      out.write("                    <div id=\"un\">Username: <input type='text' id='loguser' name='loguser' onblur=\"usernameCheck();\" onfocus=\"backWhite(this);\" required /></div>\r\n");
      out.write("                    <div id=\"pw\">Password: <input type='password' id='logpass' name='logpass' onblur=\"passwordCheck();\" onfocus=\"backWhite(this);\" required /></div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <center>\r\n");
      out.write("                    <div id=\"button2\">\r\n");
      out.write("                        <input type=\"submit\" id=\"log\" class=\"submitstyle2\" value=\"\" />\r\n");
      out.write("                    </div></center>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\n");
      out.write("        <h4 style=\"position: absolute; color: red; top:500px; left:480px;\">You have succesfully logged out from foobar!<br></h4>\n");
      out.write("    </body>\n");
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
