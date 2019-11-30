package com.opensam.problem.scratchpad.problems;

import java.util.HashMap;
import java.util.Map;

public class Trie {

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    if (word == null || word.trim().length() == 0)
      return;

    TrieNode current = root;

    int wordLength = word.length();

    for (int i = 0; i < wordLength; i++) {
      char currentChar = word.charAt(i);
      current.children.computeIfAbsent(currentChar, k -> new TrieNode());
      current = current.children.get(currentChar);
    }

    current.isTerminal = true;
  }

  public boolean search(String word) {
    if (word == null || word.trim().length() == 0)
      return false;

    TrieNode current = root;
    int wordLength = word.length();

    for (int i = 0; i < wordLength; i++) {
      char currentChar = word.charAt(i);
      if(current.children.get(currentChar) == null) {
        return false;
      }
      current = current.children.get(currentChar);
    }

    return current != null && current.isTerminal;
  }

  public boolean startsWith(String word) {
    if (word == null || word.trim().length() == 0)
      return false;

    TrieNode current = root;
    int wordLength = word.length();

    for (int i = 0; i < wordLength; i++) {
      char currentChar = word.charAt(i);
      if(current.children.get(currentChar) == null) {
        return false;
      }
      current = current.children.get(currentChar);
    }

    return current != null;
  }

}

class TrieNode {
  Map<Character, TrieNode> children;
  boolean isTerminal;

  public TrieNode() {
    children = new HashMap<>();
  }

  public TrieNode(boolean isTerminal) {
    children = new HashMap<>();
    this.isTerminal = isTerminal;
  }
}
