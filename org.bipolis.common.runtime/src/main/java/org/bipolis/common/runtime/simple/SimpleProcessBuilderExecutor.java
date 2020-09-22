/**
 *
 */

package org.bipolis.common.runtime.simple;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.bipolis.common.runtime.api.ProcessBuilderExecutor;
import org.bipolis.common.runtime.api.ProcessResult;
import org.osgi.service.component.annotations.Component;
import org.osgi.util.promise.Promise;
import org.osgi.util.promise.PromiseFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleRuntimeCommandExecutor.
 *
 * @author stbischof
 */
@Component(service = ProcessBuilderExecutor.class)
public class SimpleProcessBuilderExecutor implements ProcessBuilderExecutor
{

    /**
     * Execute.
     *
     * @param processBuilder the process builder
     * @param timeOutTime the time out time
     * @param timeOutTimeUnit the time out time unit
     * @return the simple process result
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws InterruptedException the interrupted exception
     */
    @Override
    public ProcessResult execute(final ProcessBuilder processBuilder,
        final int timeOutTime, final TimeUnit timeOutTimeUnit)
            throws IOException, InterruptedException
    {

        BasicProcessEventHandler basicProcessEventHandler = new BasicProcessEventHandler();
        Util.runCommand(processBuilder, timeOutTime, timeOutTimeUnit,
            basicProcessEventHandler);

        return basicProcessEventHandler.getProcessResult();
    }

    /**
     * Promis execute.
     *
     * @param processBuilder the process builder
     * @param timeOutTime the time out time
     * @param timeOutTimeUnit the time out time unit
     * @return the promise
     */
    @Override
    public Promise<ProcessResult> promisExecute(final ProcessBuilder processBuilder,
        final int timeOutTime, final TimeUnit timeOutTimeUnit)
    {

        final var pf = new PromiseFactory(Executors.newSingleThreadExecutor());
        final var promise = pf.submit(
            () -> execute(processBuilder, timeOutTime, timeOutTimeUnit));
        return promise;
    }

}
