/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-10-12 13:55:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class team_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/views/elements/header.jspf", Long.valueOf(1634041960598L));
    _jspx_dependants.put("/WEB-INF/views/elements/footer.jspf", Long.valueOf(1634032070337L));
    _jspx_dependants.put("/WEB-INF/views/elements/navbar.jspf", Long.valueOf(1634041949715L));
    _jspx_dependants.put("/WEB-INF/views/elements/team/cardcolumns.jspf", Long.valueOf(1634046862826L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>People Management Portal</title>\r\n");
      out.write("\t<link href=\"webjars/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>");
      out.write('\r');
      out.write('\n');
      out.write("<nav class=\"navbar navbar-expand-md navbar-dark\" style=\"background-color: #494b9e;\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <a class=\"navbar-brand\" href=\"home.html\" >People Management Portal</a>\r\n");
      out.write("        <button class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#navbarNav\">\r\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarNav\" >\r\n");
      out.write("            <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("                <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"nav-link\"  href=\"home\">Home</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"nav-link\" href=\"team\">Team</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"nav-link\" href=\"projects\">Projects</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"nav-link\" href=\"login\">Log in</a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"card-columns\">\r\n");
      out.write("\t<div class=\"card p-3\">\r\n");
      out.write("\t  <!-- <img class=\"card-img-top\" src=\"...\" alt=\"Card image cap\"> -->\r\n");
      out.write("\t  <div class=\"card-body\">\r\n");
      out.write("\t\t<h5 class=\"card-title\">Andrzej Nowak</h5>\r\n");
      out.write("\t\t<h6 class=\"card-title\">Java Developer</h6>\r\n");
      out.write("\t\t<p class=\"card-text\">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Placeat, itaque.</p>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<script src=\"webjars/jquery/1.9.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"webjars/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script\tsrc=\"webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}