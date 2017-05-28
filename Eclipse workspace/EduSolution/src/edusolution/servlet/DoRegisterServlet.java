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
 
@WebServlet(urlPatterns = { "/doRegister" })
public class DoRegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public DoRegisterServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
 
      String userName 	= 	(String) 	request.getParameter("userName");
      String password 	= 	(String) 	request.getParameter("password");
 
      UserAccount user = null;
      boolean hasError = false;
      String errorString = null;
 
      try {
    	  Connection conn = MyUtils.getStoredConnection(request);
	      if (DBUtils.findUserName(conn, userName) != null) {
	    	  hasError = true;
	    	  errorString = "User name already existed!";
	      } else {									
    		  if (userName == null || password == null || userName.length() == 0 || password.length() == 0){
    			  hasError = true;
		          errorString = "Please check User name and Password again!";
    		  } else {
    			  int logicalThinking = 0;
    			  int detailedThinking = 0;
    			  int speedOfLearning = 0;
    			  int communication = 0;
    			  user = new UserAccount(userName, password, logicalThinking, detailedThinking, speedOfLearning, communication);
    			  DBUtils.insertUser(conn, user);
    		  }
	      }
	  } catch (SQLException e) {
		  e.printStackTrace();
		  hasError = true;
		  errorString = e.getMessage();
	  }
    	
      if (hasError) {
          user = new UserAccount();
          
          request.setAttribute("errorString", errorString);
          request.setAttribute("user", user);
 
          RequestDispatcher dispatcher //
          = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerView.jsp");
 
          dispatcher.forward(request, response);
      }
      else {
          request.setAttribute("user", user);
          
          HttpSession session = request.getSession();
          MyUtils.storeLoginedUser(session, user);
          
          response.sendRedirect(request.getContextPath() + "/");
      }
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}