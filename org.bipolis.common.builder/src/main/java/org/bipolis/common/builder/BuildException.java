package org.bipolis.common.builder;

public class BuildException extends IllegalArgumentException {

	public static final long serialVersionUID = -3908249697291860942L;

	public BuildException() {
		super();
	}

	public BuildException(String message, Throwable cause) {
		super(message, cause);
	}

	public BuildException(Throwable cause) {
		super(cause);
	}

	public BuildException(String message) {
		super(message);
	}

}
