package org.bipolis.common.runtime.api;

import java.io.IOException;

public interface ProcessEventHandler
{

    void init(Process process);

    void nextLine(String line, StreamType streamType);

    void exit(int exitValue);

    /**
     * @param ex
     * @param streamType
     */
    void readException(IOException ex, StreamType streamType);

    /**
     *
     */
    void timeout();

    /**
     * @param startException
     */
    void startException(IOException startException);

    /**
     * @param e
     */
    void processInterrupted(InterruptedException e);

}
