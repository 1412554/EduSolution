package edusolution.servlet;
 
import java.io.IOException;
 
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edusolution.beans.UserAccount;
import edusolution.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/q1"})
public class Q1Servlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public Q1Servlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
 
	  Connection conn = MyUtils.getStoredConnection(request);
      HttpSession session = request.getSession();
 
      UserAccount loginedUser = MyUtils.getLoginedUser(session);
      
      if (loginedUser == null) {
    	  RequestDispatcher dispatcher = request.getServletContext()
	              .getRequestDispatcher("/WEB-INF/views/loginView.jsp");
	      dispatcher.forward(request, response);
      }
      
      loginedUser.setLogicalThinking(0);
      loginedUser.setDetailedThinking(0);
      loginedUser.setSpeedOfLearning(0);
      loginedUser.setCommunication(0);
      
      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/q1.jsp");
      
      dispatcher.forward(request, response);
      
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}