package com.soebes.performance;

import com.soebes.performance.collections.IntegerDuplicationBenchmark;
import com.soebes.performance.collections.RemoveDuplicationBenchmark;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;

public class Benchmark {

  public static void main(String[] args) throws RunnerException, IOException {
    if (args.length != 1) {
      System.err.println("you have to give a name like: integerduplication or removeduplication to start a benchmark.");
      System.exit(1);
    }
    switch (args[0]) {
      case "integerduplication":
        BenchmarkUtils.runBenchmark(IntegerDuplicationBenchmark.class);
        break;
      case "removeduplication":
        BenchmarkUtils.runBenchmark(RemoveDuplicationBenchmark.class);
        break;
      default:
        System.err.println("Unknown benchmark selected.");
    }


  }
}
