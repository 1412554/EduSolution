package edusolution.utils;
 
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 











import javax.servlet.jsp.jstl.sql.Result;

import edusolution.beans.UserAccount;
 
public class DBUtils {
 
	// Find user to login
	public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
	    String sql = "select a.user_name, a.password, a.logical_thinking, a.detailed_thinking, a.speed_of_learning, a.communication "
	    				+ "from user_account a "
	    				+ " where a.user_name = ? and a.password= ?";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, userName);
	    pstm.setString(2, password);
	    ResultSet rs = pstm.executeQuery();
	 
	    while (rs.next()) {
	        int	logicalThinking		=	rs.getInt("logical_thinking");
	        int	detailedThinking	=	rs.getInt("detailed_thinking");
	        int	speedOfLearning		=	rs.getInt("speed_of_learning");
	        int	communication		=	rs.getInt("communication");
	        UserAccount user = new UserAccount(userName, password, logicalThinking, detailedThinking, speedOfLearning, communication);
	        return user;
	    }
	    return null;
	}
	
	
	public static UserAccount findUser(Connection conn, String userName) throws SQLException {
	    String sql = "select a.user_name, a.password, a.logical_thinking, a.detailed_thinking, a.speed_of_learning, a.communication "
	    				+ "from user_account a "
	    				+ " where a.user_name = ?";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, userName);
	    ResultSet rs = pstm.executeQuery();
	 
	    while (rs.next()) {
	    	String password			=	rs.getString("password");
	        int	logicalThinking		=	rs.getInt("logical_thinking");
	        int	detailedThinking	=	rs.getInt("detailed_thinking");
	        int	speedOfLearning		=	rs.getInt("speed_of_learning");
	        int	communication		=	rs.getInt("communication");
	        UserAccount user = new UserAccount(userName, password, logicalThinking, detailedThinking, speedOfLearning, communication);
	        return user;
	    }
	    return null;
	}
  
	// Find if userName already existed
	public static UserAccount findUserName(Connection conn, String userName) throws SQLException {
	  
		String sql = "select a.user_name from user_account a where a.user_name = ? ";
 
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
 
		ResultSet rs = pstm.executeQuery();
 
		while (rs.next()) {
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			return user;
		}
		return null;
	}
  
	// Register new user
	public static void insertUser(Connection conn, UserAccount user) throws SQLException {
		String sql = "insert into user_account(user_name, password, logical_thinking, detailed_thinking, speed_of_learning, communication) "
						+ "values (?,?,?,?,?,?)";
 
		PreparedStatement pstm = conn.prepareStatement(sql);
 
		pstm.setString(1, user.getUserName());
		pstm.setString(2, user.getPassword());
		pstm.setInt(3, user.getLogicalThinking());
		pstm.setInt(4, user.getDetailedThinking());
		pstm.setInt(5, user.getSpeedOfLearning());
		pstm.setInt(6, user.getCommunication());
 
		pstm.executeUpdate();
	}
  
	// Update point
	public static void updatePoint(Connection conn, UserAccount user) throws SQLException{
		String sql = "update user_account set logical_thinking=?, detailed_thinking=?, "
				+ "speed_of_thinking=?, communication=? where user_name=?";
	  
		PreparedStatement pstm = conn.prepareStatement(sql);
	  
		pstm.setInt(1, user.getLogicalThinking());
		pstm.setInt(2, user.getDetailedThinking());
		pstm.setInt(3, user.getSpeedOfLearning());
		pstm.setInt(4, user.getCommunication());
		pstm.setString(5, user.getUserName());
	  
		pstm.executeUpdate();
	}
}