/**
 *
 */
package org.bipolis.common.runtime.simple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bipolis.common.runtime.api.ProcessEventHandler;
import org.bipolis.common.runtime.api.ProcessResult;
import org.bipolis.common.runtime.api.StreamType;

public class BasicProcessEventHandler implements ProcessEventHandler
{
    private final List<String> inputLines = new ArrayList<>();
    private final List<String> errorLines = new ArrayList<>();
    private Integer exitValue;

    boolean stop = false;
    private boolean timedOut;

    @Override
    public void exit(int exitValue)
    {
        this.exitValue = exitValue;
        stop = true;
    }

    public List<String> getLines()
    {
        while (!stop)
        {
            Thread.yield();
        }
        return inputLines;
    }

    public int getExitValue()
    {
        while (!stop)
        {
            Thread.yield();
        }
        return exitValue;
    }

    @Override
    public void nextLine(String line, StreamType streamType)
    {
        //        PushStreamProvider pushStreamProvider = new PushStreamProvider();
        //        SimplePushEventSource eventSource = .createSimpleEventSource(String.class);
        //        eventSource.publish(line);
        //        pushStreamProvider.createStream(eventSource).

        switch (streamType)
        {
            case INPUT:
                inputLines.add(line);
                break;
            case ERROR:
                errorLines.add(line);
                break;
        }
    }

    @Override
    public void readException(IOException ex, StreamType streamType)
    {
        // ignore
    }

    @Override
    public void timeout()
    {
        timedOut = true;
        stop = true;
    }

    @Override
    public void startException(IOException startException)
    {
        stop = true;
    }

    @Override
    public void processInterrupted(InterruptedException e)
    {
        stop = true;
    }

    ProcessResult getProcessResult()
    {
        while (!stop)
        {
            Thread.yield();
        }
        return new SimpleProcessResult(exitValue, inputLines, errorLines, timedOut);
    }

}
