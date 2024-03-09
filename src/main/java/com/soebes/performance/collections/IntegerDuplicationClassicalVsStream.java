package com.soebes.performance.collections;

import java.util.ArrayList;
import java.util.List;

public final class IntegerDuplicationClassicalVsStream {

  private IntegerDuplicationClassicalVsStream() {
  }

  public static List<Integer> duplicateValuesForLoop(List<Integer> values) {
    var result = new ArrayList<Integer>();
    for (Integer value : values) {
      result.add(value * 2);
    }
    return result;
  }
  public static List<Integer> duplicateValuesStream(List<Integer> values) {
    return values.stream().map(v -> v * 2).toList();
  }
}
