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
 
@WebServlet(urlPatterns = { "/finish" })
public class LastQuestionServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public LastQuestionServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	  
	  Connection conn = MyUtils.getStoredConnection(request);
      HttpSession session = request.getSession();
 
      UserAccount loginedUser = MyUtils.getLoginedUser(session);
      int speed = loginedUser.getSpeedOfLearning();
 
      String a4 = request.getParameter("a4");
 
      if (a4.equals("a")) {
    	  loginedUser.setSpeedOfLearning(speed+10);
      } 
      else if (a4.equals("b")){
    	  loginedUser.setSpeedOfLearning(speed+20);
      }
      else if (a4.equals("c")){
    	  loginedUser.setSpeedOfLearning(speed+30);
      }
      else if (a4.equals("d")){
    	  loginedUser.setSpeedOfLearning(speed+40);
      }
      
      UserAccount user = new UserAccount(loginedUser.getUserName(),loginedUser.getPassword(),loginedUser.getLogicalThinking(),loginedUser.getDetailedThinking(),loginedUser.getSpeedOfLearning(),loginedUser.getCommunication());
      
      try {
    	  DBUtils.updatePoint(conn, user);
      } catch (SQLException e) {
    	  // TODO Auto-generated catch block
    	  e.printStackTrace();
      }
      
	  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userView.jsp");
	  
      dispatcher.forward(request, response);
      
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}