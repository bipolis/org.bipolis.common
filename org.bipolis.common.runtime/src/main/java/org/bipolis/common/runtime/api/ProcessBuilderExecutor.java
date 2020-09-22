package org.bipolis.common.runtime.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.osgi.util.promise.Promise;

public interface ProcessBuilderExecutor
{

    ProcessResult execute(ProcessBuilder processBuilder, int timeOutTime,
        TimeUnit timeOutTimeUnit) throws IOException, InterruptedException;

    Promise<ProcessResult> promisExecute(ProcessBuilder processBuilder, int timeOutTime,
        TimeUnit timeOutTimeUnit) throws IOException, InterruptedException;
}
