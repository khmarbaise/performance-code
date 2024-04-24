package com.soebes.performance.primitvevswrapper;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode({Mode.AverageTime})
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 3)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
public class PrimitveVsWrapperBenchmark {

  @Param({"100", "1000", "10000", "100000", "1000000", "10000000", "100000000", "1000000000"})
  private long size;

  @Benchmark
  public void summarizeWithWrapper() {
    PrimitveVsWrapper.summarizeWithWrapper(size);
  }

  @Benchmark
  public void summarizeWithPrimitve() {
    PrimitveVsWrapper.summarizeWithPrimitve(size);
  }

  @Benchmark
  public void summarizeWithStream() {
    PrimitveVsWrapper.summarizeWithStream(size);
  }

}
