package exception;

public class LoginRequiredException extends Exception {

	public LoginRequiredException(String errorMsg) {
		super(errorMsg);
	}
}
