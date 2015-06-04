package db;

public class MessageBean{


	 	private String result;
		private String errorMessage = "";
	
		public String getResult() {
			System.out.println("Getter"+result);
			return result;
		}
		public void setResult(String result) {
			this.result = result;
			System.out.println(result);
		}
		public String getErrorMessage() {
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}


	 



}