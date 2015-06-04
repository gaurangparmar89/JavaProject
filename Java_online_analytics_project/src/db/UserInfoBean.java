package db;

public class UserInfoBean {

	
		public static String userName;
		public static String password;
		public static String host;
		public static String dbms;
		public static String databaseSchema;
		public static String sessionID;
		public static boolean isLoggedIn;
		
		public boolean getIsLoggedIn() {
			return isLoggedIn;
		}
		public void setIsLoggedIn(boolean isLoggedIn) {
			this.isLoggedIn = isLoggedIn;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public String getDbms() {
			return dbms;
		}
		public void setDbms(String dbms) {
			this.dbms = dbms;
		}
		public String getDatabaseSchema() {
			return databaseSchema;
		}
		public void setDatabaseSchema(String databaseSchema) {
			this.databaseSchema = databaseSchema;
		}
		public String getSessionID() {
			return sessionID;
		}
		public void setSessionID(String sessionID) {
			this.sessionID = sessionID;
		}
	// TODO Auto-generated constructor stub
	

}
