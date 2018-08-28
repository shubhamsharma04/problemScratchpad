package com.opensam.problem.scratchpad.problems;

import org.springframework.util.StringUtils;

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

  public boolean isAnyPermutationAPalindrome(String input) {
    if (input == null || "".equals(input))
      return false;

    Map<Character, Integer> countByCharacter = new HashMap<>();
    for (Character ch : input.toCharArray()) {
      if (Character.isAlphabetic(ch)) {
        char lowerCaseCh = ch.toLowerCase(ch);
        int currentCount = countByCharacter.computeIfAbsent(lowerCaseCh, value -> 0);
        countByCharacter.put(lowerCaseCh, currentCount + 1);
      }
    }

    return countByCharacter.values().stream()
        .filter(count -> count % 2 != 0)
        .count() <= 1;
  }

  public boolean areStringsRotated(String first, String second) {
    if(first == null || second == null)
      return false;
    if(first.length() != second.length())
      return false;

    int indexOfRotatedStart = 0;
    int rotationCount = 0;
    char firstChar = first.charAt(indexOfRotatedStart);
    int length = first.length();

    while(indexOfRotatedStart + rotationCount < length) {
      if(firstChar == second.charAt(indexOfRotatedStart)) {
        while(indexOfRotatedStart + rotationCount < length && first.charAt(rotationCount) == second.charAt(indexOfRotatedStart + rotationCount)) {
          rotationCount++;
        }
        if(indexOfRotatedStart + rotationCount < length ) {
          indexOfRotatedStart = indexOfRotatedStart + rotationCount;
          rotationCount = 0;
        }
      } else {
        indexOfRotatedStart++;
      }
    }

    return StringUtils.startsWithIgnoreCase(first.substring(0, rotationCount) + second, first);
  }
}
