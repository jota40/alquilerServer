package jota.server.exceptions;

public class ServiceException extends ServerException {

	private static final long serialVersionUID = -9133609298388318024L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super( cause );
	}
}