package jota.server.exceptions;

public class ServerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3161250173288793559L;

	public ServerException() {
		super();
	}

	public ServerException(String message) {
		super(message);
	}

	public ServerException(Throwable cause) {
		super( getLastCause(cause));
	}

	protected static Throwable getLastCause(Throwable cause) {
		while ( cause.getCause() != null ){
			cause = cause.getCause();
		}
		return cause;
	}

	public String getUsrMessage() {
		Throwable e = getLastCause( this );
		return e.getLocalizedMessage() != null ? e.getLocalizedMessage() : e.toString();
	}
	
}
