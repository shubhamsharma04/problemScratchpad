package com.opensam.problem.scratchpad.models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class AnagramComparator implements Comparator<String> {

  @Override
  public int compare(String o1, String o2) {
    if(isAnagram(o1, o2)) {
      return 0;
    } else {
      return o1.compareTo(o2);
    }
  }

  private boolean isAnagram(String o1, String o2) {
    Map<Character, Integer> firstCountByCharacter = getCountByCharacter(o1);
    Map<Character, Integer> secondCountByCharacter = getCountByCharacter(o2);

    for(Map.Entry<Character, Integer> entry : firstCountByCharacter.entrySet()) {
      if(entry.getValue() != secondCountByCharacter.get(entry.getKey())) {
        return false;
      }
    }

    return true;
  }

  private Map<Character,Integer> getCountByCharacter(String o) {
    Map<Character, Integer> countByCharacter = new HashMap<>();
    int length = o.length();
    for(int i=0; i < length; i++) {
      int currentCount = countByCharacter.computeIfAbsent(o.charAt(i), k -> 0);

      countByCharacter.put(o.charAt(i), currentCount + 1);
    }

    return countByCharacter;
  }
}
