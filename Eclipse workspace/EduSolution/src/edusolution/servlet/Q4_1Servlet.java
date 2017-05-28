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
 
@WebServlet(urlPatterns = { "/q4_1" })
public class Q4_1Servlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public Q4_1Servlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	  
	  Connection conn = MyUtils.getStoredConnection(request);
      HttpSession session = request.getSession();
 
      UserAccount loginedUser = MyUtils.getLoginedUser(session);
      int detailed = loginedUser.getDetailedThinking();
 
      String a3 = request.getParameter("a3");
 
      if (a3.equals("a")) {
    	  loginedUser.setDetailedThinking(detailed+10);
      } 
      else if (a3.equals("b")){
    	  loginedUser.setDetailedThinking(detailed+20);
      }
      else if (a3.equals("c")){
    	  loginedUser.setDetailedThinking(detailed+30);
      }
      else if (a3.equals("d")){
    	  loginedUser.setDetailedThinking(detailed+40);
      }

	  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/q4_1.jsp");
	  
      dispatcher.forward(request, response);
      
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}