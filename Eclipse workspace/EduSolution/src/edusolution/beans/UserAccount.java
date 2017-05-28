package edusolution.beans;
 
public class UserAccount {
    
   private String userName;
   private String password;
   private int logicalThinking;
   private int detailedThinking;
   private int speedOfLearning;
   private int communication;
    
   public UserAccount(){
   }
   
   public UserAccount(String userName, String password, int logicalThinking, 
		   				int detailedThinking, int speedOfLearning, int communication) {
	   this.userName 			= 	userName;
	   this.password 			= 	password;
	   this.logicalThinking		=	logicalThinking;
	   this.detailedThinking	=	detailedThinking;
	   this.speedOfLearning		=	speedOfLearning;
	   this.communication		= 	communication;
   }
    
   public String getUserName() {return userName;}
   public void setUserName(String userName) {this.userName = userName;}
 
   public String getPassword() {return password;}
   public void setPassword(String password) {this.password = password;}
   
   public int getLogicalThinking() {return logicalThinking;}
   public void setLogicalThinking(int logicalThinking) {this.logicalThinking = logicalThinking;}
   
   public int getDetailedThinking() {return detailedThinking;}
   public void setDetailedThinking(int detailedThinking) {this.detailedThinking = detailedThinking;}
   
   public int getSpeedOfLearning() {return speedOfLearning;}
   public void setSpeedOfLearning(int speedOfLearning) {this.speedOfLearning = speedOfLearning;}
   
   public int getCommunication() {return communication;}
   public void setCommunication(int communication) {this.communication = communication;}
 
}