package com.opensam.problem.scratchpad.problems;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

@Component
class PreInorderTree {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder == null || preorder.length == 0)
      return null;

    int val = preorder[0];
    TreeNode root = new TreeNode(val);
    int [] leftInOrder = getLeftInOrder(val, inorder);
    int [] rightInOrder = getRightInOrder(val, inorder);
    int [] leftPreOrder = getLeftPreOrder(preorder, leftInOrder.length);
    int [] rightPreOrder = getRightPreOrder(preorder, rightInOrder.length);

    root.left = buildTree(leftPreOrder, leftInOrder);
    root.right = buildTree(rightPreOrder, rightInOrder);

    return root;
  }

  private int [] getLeftInOrder(int value, int [] inorder) {
    List<Integer> leftInOrder = new LinkedList<>();

    for(int val : inorder){
      if(val == value)
        break;
      else
        leftInOrder.add(val);
    }

    return getAsArray(leftInOrder);
  }

  private int [] getRightInOrder(int value, int [] inorder) {
    List<Integer> rightInOrder = new LinkedList<>();
    int size = inorder.length;
    for(int i= size - 1; i >= 0; i--){
      if(inorder[i] == value)
        break;
      else
        rightInOrder.add(inorder[i]);
    }
    Collections.reverse(rightInOrder);
    return getAsArray(rightInOrder);
  }

  private int [] getLeftPreOrder(int [] preorder, int length) {
    List<Integer> leftPreOrder = new LinkedList<>();
    for(int i=0; i < length; i++)
      leftPreOrder.add(preorder[i + 1]);

    return getAsArray(leftPreOrder);
  }

  private int [] getRightPreOrder(int [] preorder, int length) {
    List<Integer> rightPreOrder = new LinkedList<>();
    int size = preorder.length - 1;
    for(int i=0; i < length; i++)
      rightPreOrder.add(preorder[size - i]);
    Collections.reverse(rightPreOrder);
    return getAsArray(rightPreOrder);
  }

  private int [] getAsArray(List<Integer> list) {
    int size = list.size();
    int [] output = new int[size];
    for(int i=0; i < size; i++){
      output[i] = list.get(i);
    }

    return output;
  }
}
