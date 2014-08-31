package org.bytescale.algorithms.counting;


import static java.nio.file.StandardOpenOption.*;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.omg.CORBA.INTERNAL;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.concurrent.*;

public class ThreeSumResultsWriter {
    private final String fileName;
    private final ExecutorService threadPool;
    private final int numThreads;
    private final Semaphore lock;
    private final File results;

    public ThreeSumResultsWriter(String fileName) {
        this.fileName = fileName;
        this.results = new File(fileName);
        this.numThreads = 4;
        this.threadPool = Executors.newFixedThreadPool(numThreads);
        this.lock = new Semaphore(1);
    }

    public Future<Boolean> writeResults(final Collection<Tuple<Integer>> tuples) {
        Future<Boolean> fileWriter = threadPool.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                try {
                    lock.acquire(1);
                    StringBuilder sb = new StringBuilder();
                    for (Tuple<Integer> t : tuples) {
                        sb.append(t.toString());
                        sb.append(System.getProperty("line.separator"));
                    }
                    FileUtils.write(new File(fileName), sb.toString(), true);
                    tuples.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.release(1);
                }
                return true;
            }

        });
        return fileWriter;
    }
}
