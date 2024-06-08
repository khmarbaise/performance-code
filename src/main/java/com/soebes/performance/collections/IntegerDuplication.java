package com.soebes.performance.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class IntegerDuplication {

  private IntegerDuplication() {
  }

  public static List<Integer> classicalForLoop(List<Integer> values) {
    var result = new ArrayList<Integer>();
    for (Integer value : values) {
      result.add(value * 2);
    }
    return result;
  }

  public static List<Integer> classicalForLoopWithOptimizations(List<Integer> values) {
    Integer[] array = values.toArray(Integer[]::new);
    for (int i = 0; i < array.length; i++) {
      array[i] = array[i] * 2;
    }
    return new ArrayList<>(Arrays.asList(array));
  }

  public static List<Integer> stream(List<Integer> values) {
    return values.stream().map(v -> v * 2).toList();
  }

  public static List<Integer> streamParallel(List<Integer> values) {
    return values.parallelStream().map(v -> v * 2).toList();
  }

  public static List<Integer> streamWithMapToInt(List<Integer> values) {
    return values.stream().mapToInt(Integer::intValue).map(v -> v * 2).boxed().toList();
  }
}
