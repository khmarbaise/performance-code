package com.soebes.performance.primitvevswrapper;

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

}
