package org.bipolis.common.runtime.simple;

import java.util.List;

import org.bipolis.common.runtime.api.ProcessResult;

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleRuntimeProcessResult.
 */
public class SimpleProcessResult implements ProcessResult
{

    /**
     * Checks for.
     *
     * @param data the errors 2
     * @return true, if successful
     */
    private static boolean has(List<String> data)
    {

        return data != null && data.size() != 0;
    }

    /** The outs. */
    private final List<String> lines;

    /** The errors. */
    private final List<String> errorLines;

    /** The exit value. */
    private final Integer exitValue;

    private final boolean timedOut;

    /**
     * @param exitValue
     * @param inputLines
     * @param errorLines
     * @param timedOut
     */
    public SimpleProcessResult(Integer exitValue, List<String> lines, List<String> errorLines, boolean timedOut)
    {
        this.exitValue = exitValue;
        this.lines = lines;
        this.errorLines = errorLines;
        this.timedOut = timedOut;
    }

    /**
     * Gets the errors.
     *
     * @return the errors
     */
    @Override
    public List<String> getError()
    {

        return errorLines;
    }

    /**
     * Gets the exit value.
     *
     * @return the exit value
     */
    @Override
    public Integer getExitValue()
    {

        return exitValue;
    }

    /**
     * Gets the outs.
     *
     * @return the outs
     */
    @Override
    public List<String> getLines()
    {

        return lines;
    }

    /**
     * Checks for errors.
     *
     * @return true, if successful
     */
    @Override
    public boolean hasError()
    {

        return has(errorLines);
    }

    /**
     * Checks for output.
     *
     * @return true, if successful
     */
    @Override
    public boolean hasOutput()
    {

        return has(lines);
    }

    /**
     * Checks if is timed out.
     *
     * @return true, if is timed out
     */
    @Override
    public boolean isTimedOut()
    {

        return exitValue == null;
    }
}
