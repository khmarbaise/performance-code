package com.soebes.performance.collections;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode({Mode.AverageTime})
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 3)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
public class RemoveDuplicationBenchmark {

  private int[] array;

  @Param({"50", "100", "500", "1000", "2000"})
  private int size;

  @Setup
  public void setup() {
    array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = i;
    }
  }

  @Benchmark
  public void streamVariant() {
    RemoveDuplication.streamBased(array);
  }

  @Benchmark
  public void forLoop() {
    RemoveDuplication.classicalForLoop(array);
  }

}
