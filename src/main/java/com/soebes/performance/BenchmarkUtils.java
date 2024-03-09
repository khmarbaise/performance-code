package com.soebes.performance;

import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class BenchmarkUtils {

  private BenchmarkUtils() {
  }

  public static void runBenchmark(Class<?> clazz) throws IOException, RunnerException {
    var reportsDirectory = Path.of("reports");
    Files.createDirectories(reportsDirectory);
    Options opt = new OptionsBuilder()
        .include(clazz.getSimpleName())
        .resultFormat(ResultFormatType.JSON)
        .shouldDoGC(true)
        .result(reportsDirectory.resolve(String.format("%s.json", clazz.getSimpleName())).toString())
        .jvmArgsAppend("-Djmh.stack.period=1")
        //.warmupIterations(2)
        //.measurementIterations(10)
        .forks(1)
        .build();

    new Runner(opt).run();
  }
}