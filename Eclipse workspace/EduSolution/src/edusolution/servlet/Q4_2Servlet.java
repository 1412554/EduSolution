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
 
@WebServlet(urlPatterns = { "/q4_2" })
public class Q4_2Servlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public Q4_2Servlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
	  
	  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/q4_2.jsp");
	  
      dispatcher.forward(request, response);
      
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}