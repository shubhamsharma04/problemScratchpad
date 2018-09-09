package com.opensam.problem.scratchpad.problems;

import com.opensam.problem.scratchpad.models.BSTNode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component
public class Hashing {

  public void verticalTraversal(BSTNode root) {
    Map<Integer, List<BSTNode>> nodesByVerticalOrder = new TreeMap<>();

    populateVerticalTraversal(root, nodesByVerticalOrder, 0);

    for (Map.Entry<Integer, List<BSTNode>> entry : nodesByVerticalOrder.entrySet()) {
      entry.getValue().forEach(bstNode -> System.out.print(bstNode.getData() + " "));
      System.out.println();
    }
  }

  private void populateVerticalTraversal(BSTNode node, Map<Integer, List<BSTNode>> nodesByVerticalOrder, int order) {
    if (node == null)
      return;

    List<BSTNode> nodesWithSameOrder = nodesByVerticalOrder.computeIfAbsent(order, k -> new LinkedList<>());
    nodesWithSameOrder.add(node);
    populateVerticalTraversal(node.getLeft(), nodesByVerticalOrder, order - 1);
    populateVerticalTraversal(node.getRight(), nodesByVerticalOrder, order + 1);
  }
}
