package com.opensam.problem.scratchpad.problems;

import com.opensam.problem.scratchpad.models.Trie;

import java.util.HashSet;
import java.util.Set;

public class TrieInsertAndSearch {

  public Trie insert() {
    Set<String> dict = new HashSet<>();
    dict.add("Many");
    dict.add("More");

    Trie root = new Trie();

    for (String word : dict) {
      insert(root, word, 0);
    }

    return root;
  }

  private Trie insert(Trie root, String word, int charIndex) {
    if(charIndex == word.length()){
      Trie terminalNode = new Trie();
      terminalNode.setTerminal(true);
      return terminalNode;
    }

    char ch = Character.toLowerCase(word.charAt(charIndex));
    if (root == null) {
      root = new Trie();
    }

    root.getChildren()[ch - 'a'] = insert(root.getChildren()[ch - 'a'], word, charIndex + 1);

    return root;
  }

  public String searchNext(Trie root, String word) {
    if(root == null || word == null)
      return null;

    Trie temp = root;

    char[] wordArr = word.toLowerCase().toCharArray();
    int length = wordArr.length;

    for (int i = 0; i < length; i++) {
      if (temp.getChildren()[wordArr[i] - 'a'] == null)
        return null;

      else
        temp = temp.getChildren()[wordArr[i] - 'a'];
    }

    return word + getNextWord(temp, "");
  }

  private String getNextWord(Trie temp, String prefix) {
    if(temp == null || temp.isTerminal())
      return prefix;

    int nextIndex = getNextIndex(temp);
    return prefix + ((char) ('a' + nextIndex)) + getNextWord(temp.getChildren()[nextIndex], prefix);
  }

  private int getNextIndex(Trie temp) {
    for (int i = 0; i < temp.getChildren().length; i++) {
      if (temp.getChildren()[i] != null)
        return i;
    }

    return -1;
  }
}
