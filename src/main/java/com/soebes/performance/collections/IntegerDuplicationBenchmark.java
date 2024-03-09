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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode({Mode.AverageTime})
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 3)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
public class IntegerDuplicationBenchmark {

  private List<Integer> array;

  @Param({"50", "100", "500", "1000", "2000", "10000", "100000"})
  private int size;

  @Setup
  public void setup() {
    array = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      array.add(i);
    }
  }

  @Benchmark
  public void classicalForLoop() {
    IntegerDuplication.classicalForLoop(array);
  }

  @Benchmark
  public void streamVariant() {
    IntegerDuplication.stream(array);
  }

}
