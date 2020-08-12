package org.bipolis.common.runtime.simple;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.bipolis.common.runtime.api.ProcessBuilderExecutor;
import org.bipolis.common.runtime.api.ProcessEventHandler;
import org.bipolis.common.runtime.api.ProcessResult;
import org.bipolis.common.runtime.api.StreamType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osgi.test.common.annotation.InjectService;
import org.osgi.test.junit5.service.ServiceExtension;

@ExtendWith(ServiceExtension.class)
public class Testa
{

    /**
     * Testrun.
     *
     * @throws IOException          Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testrun(@InjectService ProcessBuilderExecutor executor)
        throws IOException, InterruptedException
    {
        assertThat(executor).isNotNull();
        final ProcessResult res = executor.execute(
            new ProcessBuilder("ping", "www.google.de"), 5, TimeUnit.SECONDS);

        //        System.out.println("-----");
        //        res.getLines().forEach(System.out::println);
        //        System.out.println("+++++++++++");
        //        res.getError().forEach(System.out::println);
        //        System.out.println("######");
        //        assertTrue(res.getLines().size() > 4);
        assertThat(res.getError()).isEmpty();

        assertThat(res.isTimedOut()).isTrue();

        assertThat(res.getExitValue()).isNull();

    }

    @Test
    public void testasync(@InjectService ProcessBuilderExecutor executor)
        throws IOException, InterruptedException
    {

        ProcessEventHandler peh = new ProcessEventHandler()
        {

            @Override
            public void timeout()
            {
                //ok
            }

            @Override
            public void startException(IOException startException)
            {
                fail("shoult not startException", startException);
            }

            @Override
            public void readException(IOException ex, StreamType streamType)
            {
                fail("shoult not readException", ex);
            }

            @Override
            public void processInterrupted(InterruptedException e)
            {
                fail("shoult not processInterrupted", e);

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
                fail("shoult not exit");
            }
        };
        executor.execute(new ProcessBuilder("ping", "www.google.de"), 5, TimeUnit.SECONDS,
            peh);

    }

}
