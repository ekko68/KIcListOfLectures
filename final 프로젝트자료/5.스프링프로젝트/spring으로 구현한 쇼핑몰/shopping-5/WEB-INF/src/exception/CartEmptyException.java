package exception;

public class CartEmptyException extends Exception {

	public CartEmptyException(String errorMsg) {
		super(errorMsg);
	}
}