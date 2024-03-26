package com.soebes.performance.commons;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public final class StringReplacement {

  private StringReplacement() {
  }

  public static String stringReplace(String veryLongString, List<String> givenStrings, int replaceIndex) {
    return veryLongString.replace(givenStrings.get(replaceIndex), "");
  }

  public static String stringUtilsReplace(String veryLongString, List<String> givenStrings, int replaceIndex) {
    return StringUtils.replace(veryLongString, givenStrings.get(replaceIndex), "");
  }


}
