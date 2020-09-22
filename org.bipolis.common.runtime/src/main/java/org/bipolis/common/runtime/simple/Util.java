package org.bipolis.common.runtime.simple;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

import org.bipolis.common.runtime.api.ProcessEventHandler;
import org.bipolis.common.runtime.api.StreamType;

/**
 * The Class Util.
 *
 * @author stbischof
 */
public class Util
{

    /**
     * Run command.
     *
     * @param processBuilder  the process builder
     * @param timeOutTime     the time out time
     * @param timeOutTimeUnit the time out time unit
     * @return
     * @return the simple runtime process result
     * @throws IOException                  Signals that an I/O exception has
     *                                      occurred.
     * @throws InterruptedException         the interrupted exception
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public static Process runCommand(ProcessBuilder processBuilder, int timeOutTime,
        TimeUnit timeOutTimeUnit, ProcessEventHandler processEventHandler)
    {
        try
        {
            processBuilder.redirectInput();
            Process process = processBuilder.start();
            processEventHandler.init(process);
            new Thread(() -> {
                try (
                    final OutputHandler out = new OutputHandler(process,
                        processEventHandler, StreamType.INPUT);
                    final OutputHandler err = new OutputHandler(process,
                        processEventHandler, StreamType.ERROR);)
                {
                    final boolean runInTime = process.waitFor(timeOutTime,
                        timeOutTimeUnit);
                    if (runInTime)
                    {
                        processEventHandler.exit(process.exitValue());
                    }
                    else
                    {
                        processEventHandler.timeout();
                    }
                }
                catch (IOException e)
                {
                    // ignore
                    e.printStackTrace();
                }
                catch (InterruptedException e)
                {
                    processEventHandler.processInterrupted(e);
                }
            }).start();
            return process;
        }
        catch (IOException startException)
        {
            processEventHandler.startException(startException);
        }
        return null;
    }
}
