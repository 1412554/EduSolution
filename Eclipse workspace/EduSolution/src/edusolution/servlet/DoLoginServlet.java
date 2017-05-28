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
 
@WebServlet(urlPatterns = { "/doLogin" })
public class DoLoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public DoLoginServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
 
      String userName = request.getParameter("userName");
      String password = request.getParameter("password");
 
      
      UserAccount user = null;
      boolean hasError = false;
      String errorString = null;
 
      if (userName == null || password == null
               || userName.length() == 0 || password.length() == 0) {
          hasError = true;
          errorString = "Please check User name and Pasword again!";
      } else {
          Connection conn = MyUtils.getStoredConnection(request);
          try {
              // Find user in DB.
              user = DBUtils.findUser(conn, userName, password);
              
              if (user == null) {
                  hasError = true;
                  errorString = "Wrong User name or Password!";
              }
          } catch (SQLException e) {
              e.printStackTrace();
              hasError = true;
              errorString = e.getMessage();
          }
      }
      // Has Error
      if (hasError) {
          user = new UserAccount();
          
          // Save info to Request
          request.setAttribute("errorString", errorString);
          request.setAttribute("user", user);
 
          // Redir to Login View
          RequestDispatcher dispatcher //
          = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
 
          dispatcher.forward(request, response);
      }
      // No Error
      // Save to session
      // Redir to Home
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