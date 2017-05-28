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
 
@WebServlet(urlPatterns = { "/userInfo" })
public class UserInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public UserInfoServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	  Connection conn = MyUtils.getStoredConnection(request);
      HttpSession session = request.getSession();
 
      UserAccount loginedUser = MyUtils.getLoginedUser(session);
      String userName = loginedUser.getUserName();
      UserAccount user = null;
      String errorString = null;
      
      try {
          user = DBUtils.findUser(conn, userName);
      } catch (SQLException e) {
          e.printStackTrace();
          errorString = e.getMessage();
      }
      request.setAttribute("errorString", errorString);
      request.setAttribute("user", user);
 
      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userView.jsp");
      dispatcher.forward(request, response);
 
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}