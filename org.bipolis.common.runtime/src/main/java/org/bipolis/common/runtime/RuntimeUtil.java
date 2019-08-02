package org.bipolis.common.runtime;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// TODO: Auto-generated Javadoc
/**
 * The Class RuntimeUtil.
 */
public abstract class RuntimeUtil {


	/**
	 * Run command.
	 *
	 * @param command         the command
	 * @param execDirectory   the exec directory
	 * @param timeOutTime     the time out time
	 * @param timeOutTimeUnit the time out time unit
	 * @return the command result
	 * @throws IOException          Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public static CommandResult runCommand(final String command, File execDirectory, int timeOutTime,
			TimeUnit timeOutTimeUnit) throws IOException, InterruptedException {

		return runCommand(command, null, execDirectory, timeOutTime, timeOutTimeUnit);
	}


	/**
	 * Run command.
	 *
	 * @param command         the command
	 * @param timeOutTime     the time out time
	 * @param timeOutTimeUnit the time out time unit
	 * @return the command result
	 * @throws IOException          Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public static CommandResult runCommand(final String command, int timeOutTime,

			TimeUnit timeOutTimeUnit) throws IOException, InterruptedException {

		return runCommand(command, null, null, timeOutTime, timeOutTimeUnit);
	}

	/**
	 * Run command.
	 *
	 * @param command         the command
	 * @param envParameter    the env parameter
	 * @param execDirectory   the exec directory
	 * @param timeOutTime     the time out time
	 * @param timeOutTimeUnit the time out time unit
	 * @return the command result
	 * @throws IOException          Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public static CommandResult runCommand(final String command, String[] envParameter,
			File execDirectory, int timeOutTime, TimeUnit timeOutTimeUnit)
					throws IOException, InterruptedException {

		final Runtime runtime = Runtime.getRuntime();
		final Process process = runtime.exec(command, envParameter, execDirectory);
		final boolean runInTime = process.waitFor(timeOutTime, timeOutTimeUnit);
		final CommandResult commandResult = new CommandResult(runInTime,
				process.getInputStream().readAllBytes(), process.getErrorStream().readAllBytes());
		process.destroy();
		return commandResult;
	}
}