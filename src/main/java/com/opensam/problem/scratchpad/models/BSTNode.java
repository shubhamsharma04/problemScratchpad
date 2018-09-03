package com.opensam.problem.scratchpad.models;

public class BSTNode {
  private BSTNode left;
  private int data;
  private BSTNode right;

  public BSTNode() {

  }

  public BSTNode(int data) {
    this.data = data;
  }

  public BSTNode getLeft() {
    return left;
  }

  public void setLeft(BSTNode left) {
    this.left = left;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public BSTNode getRight() {
    return right;
  }

  public void setRight(BSTNode right) {
    this.right = right;
  }
}
