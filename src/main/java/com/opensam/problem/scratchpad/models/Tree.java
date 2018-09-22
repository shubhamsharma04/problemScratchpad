package com.opensam.problem.scratchpad.models;

import java.util.ArrayList;
import java.util.List;

public class Tree {

  private int data;
  private List<Tree> children;

  public Tree(int data) {
    this.data = data;
    children = new ArrayList<>();
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public List<Tree> getChildren() {
    return children;
  }

  public void setChildren(List<Tree> children) {
    this.children = children;
  }
}
