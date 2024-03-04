package com.soebes.performance.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamVsClassic {
  public static int[] removeDuplicates(int[] arr) {
    if (arr == null || arr.length == 0) {
      return arr;
    }

    Set<Integer> set = new HashSet<>();

    // Add elements to the Set (duplicates will automatically be removed)
    for (int num : arr) {
      set.add(num);
    }

    int[] uniqueArr = new int[set.size()];
    int idx = 0;

    for (int n : set) {
      uniqueArr[idx++] = n;
    }

    return uniqueArr;
  }

  public static int[] removeDuplicatesStream(int[] duplicates) {
    var collect = IntStream.of(duplicates)
        .boxed()
        .collect(Collectors.toSet());
    return collect.stream().mapToInt(Integer::intValue).toArray();
  }


}
