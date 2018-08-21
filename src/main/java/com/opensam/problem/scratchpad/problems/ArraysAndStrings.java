package com.opensam.problem.scratchpad.problems;

import java.util.HashMap;
import java.util.Map;

public class ArraysAndStrings {

  public boolean isPermutation(String first, String second) {
    if (first == null)
      return false;

    if (second == null)
      return false;

    if (first.length() != second.length())
      return false;

    Map<Character, Integer> characterCount = new HashMap<>();

    int length = first.length();
    for (int i = 0; i < length; i++) {
      char ch = first.charAt(i);

      int count = characterCount.computeIfAbsent(ch, value -> 0);
      characterCount.put(ch, count + 1);

    }

    for (int i = 0; i < length; i++) {
      char ch = second.charAt(i);

      if (characterCount.get(ch) == null || characterCount.get(ch) == 0)
        return false;
      else
        characterCount.put(ch, characterCount.get(ch) - 1);
    }

    return true;
  }
}
