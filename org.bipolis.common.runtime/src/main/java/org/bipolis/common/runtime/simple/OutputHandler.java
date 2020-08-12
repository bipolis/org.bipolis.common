package org.bipolis.common.runtime.simple;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.bipolis.common.runtime.api.ProcessEventHandler;
import org.bipolis.common.runtime.api.StreamType;
import org.slf4j.Logger;

class OutputHandler extends Thread implements Closeable
{

    public static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(OutputHandler.class);

    private final BufferedReader bufferedReader;
    private final ProcessEventHandler processEventHandler;

    private final StreamType streamType;

    public OutputHandler(Process process, ProcessEventHandler processEventHandler, StreamType streamType)
    {
        InputStream in = streamType == StreamType.ERROR ? process.getErrorStream()
            : process.getInputStream();

        bufferedReader = new BufferedReader(new InputStreamReader(in));

        this.processEventHandler = processEventHandler;
        this.streamType = streamType;
        setDaemon(true);
        start();
    }

    @Override
    public void close() throws IOException
    {

        bufferedReader.close();

    }



    @Override
    public void run()
    {
        try
        {
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                synchronized (processEventHandler)
                {
                    processEventHandler.nextLine(line, streamType);
                }
            }
        }
        catch (final IOException ex)
        {
            processEventHandler.readException(ex, streamType);
            LOGGER.debug(ex.getMessage(), ex);
        }
        finally
        {
            try
            {
                bufferedReader.close();
            }
            catch (final IOException ex)
            {
                LOGGER.debug(ex.getMessage(), ex);
            }
        }

    }
}