package com.soebes.performance.commons;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode({Mode.AverageTime})
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 3)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
public class StringReplacementBenchmark {

  private String veryLongString;

  private static final List<String> DIFFERENT_STRINGS = List.of("John", "Richard", "Marcha", "Conny");

  @Param({"50", "100", "500", "1000", "2000"})
  private int size;

  @Setup
  public void setup() {
    var stringBuilder = new StringBuilder();
    for (int i = 0; i < size; i++) {
      stringBuilder.append(DIFFERENT_STRINGS.get(i % (DIFFERENT_STRINGS.size() - 1)));
      stringBuilder.append(" ");
    }
  }

  @Benchmark
  public void stringReplace_0() {
    StringReplacement.stringReplace(veryLongString, DIFFERENT_STRINGS, 0);
  }
  @Benchmark
  public void stringReplace_1() {
    StringReplacement.stringReplace(veryLongString, DIFFERENT_STRINGS, 1);
  }
  @Benchmark
  public void stringReplace_2() {
    StringReplacement.stringReplace(veryLongString, DIFFERENT_STRINGS, 2);
  }
  @Benchmark
  public void stringReplace_3() {
    StringReplacement.stringReplace(veryLongString, DIFFERENT_STRINGS, 3);
  }

  @Benchmark
  public void stringUtilsReplace_0() {
    StringReplacement.stringUtilsReplace(veryLongString, DIFFERENT_STRINGS, 0);
  }
  @Benchmark
  public void stringUtilsReplace_1() {
    StringReplacement.stringUtilsReplace(veryLongString, DIFFERENT_STRINGS, 1);
  }
  @Benchmark
  public void stringUtilsReplace_2() {
    StringReplacement.stringUtilsReplace(veryLongString, DIFFERENT_STRINGS, 2);
  }
  @Benchmark
  public void stringUtilsReplace_3() {
    StringReplacement.stringUtilsReplace(veryLongString, DIFFERENT_STRINGS, 3);
  }

}
