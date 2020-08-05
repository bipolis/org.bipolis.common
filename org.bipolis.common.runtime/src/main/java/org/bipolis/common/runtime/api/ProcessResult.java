package org.bipolis.common.runtime.api;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface RuntimeProcessResult.
 *
 * @author stbischof
 */
public interface ProcessResult {

    /**
     * Gets the error.
     *
     * @return the error
     */
    List<String> getError();

    /**
     * Gets the exit value.
     *
     * @return the exit value
     */
    Integer getExitValue();

    /**
     * Gets the output.
     *
     * @return the output
     */
    List<String> getLines();

    /**
     * Checks for error.
     *
     * @return true, if successful
     */
    boolean hasError();

    /**
     * Checks for output.
     *
     * @return true, if successful
     */
    boolean hasOutput();

    /**
     * Checks if is timed out.
     *
     * @return true, if is timed out
     */
    boolean isTimedOut();
}
