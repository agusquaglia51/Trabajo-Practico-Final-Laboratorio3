package Excepciones;

public class PasswordIncorrectException extends Exception{
	private static final long serialVersionUID = 1L;
	private String password;
	
	
	public PasswordIncorrectException(String msg,String pass) {
		super(msg);
		this.password = pass;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage()+" "+password;
	}
}
