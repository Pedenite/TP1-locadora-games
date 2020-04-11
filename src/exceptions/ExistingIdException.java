package exceptions;

public class ExistingIdException extends Exception {
    private static final long serialVersionUID = 4975782228622725150L;

    public ExistingIdException(String msg) {
	    super(msg);
	}

}