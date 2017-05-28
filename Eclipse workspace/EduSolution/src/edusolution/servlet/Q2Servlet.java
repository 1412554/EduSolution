package edusolution.servlet;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 





import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 





import edusolution.beans.UserAccount;
import edusolution.utils.DBUtils;
import edusolution.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/q2" })
public class Q2Servlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public Q2Servlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	  
	  Connection conn = MyUtils.getStoredConnection(request);
      HttpSession session = request.getSession();
 
      UserAccount loginedUser = MyUtils.getLoginedUser(session);
      int logical = loginedUser.getLogicalThinking();
 
      String a1 = request.getParameter("a1");
 
      if (a1.equals("a")) {
    	  loginedUser.setLogicalThinking(logical+10);
    	  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/q2a.jsp");
 
          dispatcher.forward(request, response);
      } 
      else if (a1.equals("b")){
    	  loginedUser.setLogicalThinking(logical+20);
    	  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/q2b.jsp");
 
          dispatcher.forward(request, response);
      }
      else if (a1.equals("c")){
    	  loginedUser.setLogicalThinking(logical+30);
    	  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/q2c.jsp");
 
          dispatcher.forward(request, response);
      }
      else if (a1.equals("d")){
    	  loginedUser.setLogicalThinking(logical+40);
    	  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/q2d.jsp");
    	  
          dispatcher.forward(request, response);
      }
      
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}