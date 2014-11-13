package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Foobar Log In</title>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div id=\"banner\"> <a href=\"login.jsp\"><img src=\"assets/books.jpg\"/></a> </div>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <nav>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"adWall3DSmall.html\">Home</a>    </li>\n");
      out.write("                <li><a href=\"#\">Category</a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\">Books</a></li>\n");
      out.write("                        <li><a href=\"#\">Magazines</a></li>\n");
      out.write("                        <li><a href=\"#\">Audio CDs</a></li>\n");
      out.write("                        <li><a href=\"#\">DVDs</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"signup.html\">Register</a>   </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"loginform\">\n");
      out.write("            <form id=\"logform\" name=\"login\" onsubmit=\"return logcheck();\" method=\"post\" action=\"LoginServlet\">\n");
      out.write("                <div id=\"block2\">\n");
      out.write("                    <div id=\"un\">Username: <input type='text' id='loguser' name='loguser' onblur=\"usernameCheck();\" onfocus=\"backWhite(this);\" required /></div>\n");
      out.write("                    <div id=\"pw\">Password: <input type='password' id='logpass' name='logpass' onblur=\"passwordCheck();\" onfocus=\"backWhite(this);\" required /></div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <center>\n");
      out.write("                    <div id=\"button2\">\n");
      out.write("                        <input type=\"submit\" id=\"log\" class=\"submitstyle2\" value=\"\" />\n");
      out.write("                    </div></center>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
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
