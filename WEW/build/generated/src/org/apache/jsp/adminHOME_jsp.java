package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Beans.AccountBean;

public final class adminHOME_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");

    AccountBean homeuser = (AccountBean) session.getAttribute("homeadmin");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <script src=\"jquery-2.1.0.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"js-edit.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"js-general.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"wadesign.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"category.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style4.css\">\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2' rel='stylesheet' type='text/css'>\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Istok+Web|Exo+2|Over+the+Rainbow' rel='stylesheet' type='text/css'>\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <title>Admin Home</title>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <header>\r\n");
      out.write("            <div id=\"banner\"> <a href=\"adminHOME.jsp\"><img src=\"books.jpg\"></a> </div>\r\n");
      out.write("        </header>\r\n");
      out.write("\r\n");
      out.write("<nav>\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"adminHOME.jsp\">Home</a>    </li>\r\n");
      out.write("                <li><a href='#'>Account\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li><a href='adminAccount.jsp'>Edit Account</a></li>\r\n");
      out.write("                            <li><a href='#'>Log out</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"actions\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"signup_productmanager.html\">Add Product Manager</a>\r\n");
      out.write("            <br>\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"signup_accountingmanager.html\">Add Accounting Manager</a>\r\n");
      out.write("            <br>\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"viewlogs.html\">View Activity Log </a>\r\n");
      out.write("            <br>\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"unlock_account.html\">Unlock Account</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
