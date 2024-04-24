package com.soebes.performance.primitvevswrapper;

import java.util.stream.LongStream;

public final class PrimitveVsWrapper {

  public static Long summarizeWithWrapper(long max) {
    Long sum = 0L;
    for (long i = 0; i < max; i++) {
      sum += i;
    }
    return sum;
  }

  public static long summarizeWithPrimitve(long max) {
    long sum = 0L;
    for (long i = 0; i < max; i++) {
      sum += i;
    }
    return sum;
  }

  public static long summarizeWithStream(long max) {
    return LongStream.range(0, max).sum();
  }

}
