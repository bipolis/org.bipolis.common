package org.bipolis.common.runtime.simple;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.bipolis.common.runtime.api.ProcessEventHandler;
import org.bipolis.common.runtime.api.ProcessResult;
import org.bipolis.common.runtime.api.StreamType;
import org.junit.jupiter.api.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class Testa.
 *
 * @author stbischof
 */
public class Testa
{

    /**
     * Testrun.
     *
     * @throws IOException          Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testrun() throws IOException, InterruptedException
    {

        final ProcessResult res = new SimpleProcessBuilderExecutor().execute(
            new ProcessBuilder("ping", "www.google.de"), 5, TimeUnit.SECONDS);

        //        System.out.println("-----");
        //        res.getLines().forEach(System.out::println);
        //        System.out.println("+++++++++++");
        //        res.getError().forEach(System.out::println);
        //        System.out.println("######");
        //        assertTrue(res.getLines().size() > 4);

        assertTrue(res.getError().isEmpty());
        assertTrue(res.isTimedOut());

        assertNull(res.getExitValue());

    }

    @Test
    public void testasync() throws IOException, InterruptedException
    {

        ProcessEventHandler peh = new ProcessEventHandler()
        {

            @Override
            public void timeout()
            {
                assertTrue(true);
            }

            @Override
            public void startException(IOException startException)
            {
                assertTrue(false);
            }

            @Override
            public void readException(IOException ex, StreamType streamType)
            {
                assertTrue(false);

            }

            @Override
            public void processInterrupted(InterruptedException e)
            {
                assertTrue(false);

            }

            @Override
            public void nextLine(String line, StreamType streamType)
            {
                switch (streamType)
                {
                    case ERROR:
                        assertTrue(false);
                        break;
                    case INPUT:
                        assertTrue(false);
                        break;
                }
            }

            @Override
            public void exit(int exitValue)
            {
                assertTrue(false);
            }
        };
        final Process process = new SimpleProcessBuilderExecutor().execute(
            new ProcessBuilder("ping", "www.google.de"), 5, TimeUnit.SECONDS, peh);

    }

}
