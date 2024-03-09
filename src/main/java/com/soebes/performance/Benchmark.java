package com.soebes.performance;

import com.soebes.performance.collections.IntegerDuplicationClassicalVsStream;
import com.soebes.performance.collections.RemoveDuplicationStreamVsClassic;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;

public class Benchmark {

  public static void main(String[] args) throws RunnerException, IOException {
    switch (args[0]) {
      case "integerduplication" : BenchmarkUtils.runBenchmark(IntegerDuplicationClassicalVsStream.class);
      case "removeduplication" :    BenchmarkUtils.runBenchmark(RemoveDuplicationStreamVsClassic.class);
      default:
        System.err.println("Unknown benchmark selected.");
    }


  }
}
