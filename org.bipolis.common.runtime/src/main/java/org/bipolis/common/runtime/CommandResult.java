package org.bipolis.common.runtime;

public class CommandResult {

	private static boolean has(byte[] errors2) {

		return errors2 != null && errors2.length != 0;
	}

	private final byte[] outs;

	private final byte[] errors;

	private final boolean runInTime;

	public CommandResult(boolean runInTime, byte[] outs, byte[] errors) {

		this.runInTime = runInTime;
		this.outs = outs;
		this.errors = errors;
	}

	public byte[] getErrors() {

		return errors;
	}

	public String getErrorsAsString() {

		return new String(getErrors());
	}

	public byte[] getOuts() {

		return outs;
	}

	public String getOutsAsString() {

		return new String(getOuts());
	}

	public boolean hasErrors() {

		return has(errors);
	}

	public boolean hasOuts() {

		return has(outs);
	}

	public boolean isRunInTime() {

		return runInTime;
	}

	public boolean isTimedOut() {

		return !runInTime;
	}
}
