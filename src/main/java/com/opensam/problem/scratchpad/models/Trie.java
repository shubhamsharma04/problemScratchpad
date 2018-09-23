package com.opensam.problem.scratchpad.models;

public class Trie {
  private Trie[] children;
  private boolean isTerminal;

  public Trie() {
    children = new Trie[26];
  }

  public Trie[] getChildren() {
    return children;
  }

  public void setChildren(Trie[] children) {
    this.children = children;
  }

  public boolean isTerminal() {
    return isTerminal;
  }

  public void setTerminal(boolean terminal) {
    isTerminal = terminal;
  }
}
