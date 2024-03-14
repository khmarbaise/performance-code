package com.soebes.performance.strings;

public final class StringAppender {

  private StringAppender() {
  }

  public static String appender(int size) {
    String result = "";
    for (int i = 0; i < size; i++) {
      result += "example";
    }
    return result;
  }

  public static String appenderStringBuilder(int size) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      sb.append("example");
    }
    return sb.toString();
  }
}
