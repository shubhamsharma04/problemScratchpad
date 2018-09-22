package com.opensam.problem.scratchpad.problems;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

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

  public List<Integer> getPairsToMakeSumEqual(int[] first, int[] second) {

    if(first == null || second == null || first.length == 0 || second.length == 0)
      return null;

    Set<Integer> firstElements = new HashSet<>();
    int firstSum = 0;

    Set<Integer> secondElements = new HashSet<>();
    int secondSum = 0;

    for ( int i : first) {
      firstSum+=i;
      firstElements.add(i);
    }

    for (int i : second) {
      secondSum += i;
      secondElements.add(i);
    }

    int totalSum = firstSum + secondSum;

    if (totalSum %2 != 0)
      return null;

    int requiredSum = totalSum/2;
    int diff = requiredSum - firstSum;
    List<Integer> result = new ArrayList<>();

    for(int i : firstElements) {
      if(secondElements.contains(diff + i)){
        result.add(i);
        result.add(diff + i);
        break;
      }
    }

    return result;

  }

}
