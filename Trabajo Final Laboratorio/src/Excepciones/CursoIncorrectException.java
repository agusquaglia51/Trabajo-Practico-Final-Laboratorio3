package Excepciones;

public class CursoIncorrectException extends Exception{
	private static final long serialVersionUID = 1L;
	private String curs;
	
	
	public CursoIncorrectException(String msg,String curs) {
		super(msg);
		this.curs = curs;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage()+" "+curs;
	}
}
