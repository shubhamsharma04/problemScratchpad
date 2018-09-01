package com.opensam.problem.scratchpad.problems;

import com.opensam.problem.scratchpad.models.BSTNode;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
public class GraphsAndTrees {

  public boolean routeBetweenNodes(int adj[][], int from, int to) {
    if (adj == null || adj.length == 0 || adj.length != adj[0].length || adj.length <= from || adj.length <= to)
      return false;

    List<Integer> pathQ = new LinkedList<>();
    Set<Integer> visitedNodes = new HashSet<>();

    pathQ.add(from);
    visitedNodes.add(from);

    while (!pathQ.isEmpty()) {
      int source = ((LinkedList<Integer>) pathQ).remove();

      if (source == to)
        return true;

      for (int i = 0; i < adj.length; i++) {
        if (adj[source][i] != 0 && !visitedNodes.contains(i)) {
          pathQ.add(i);
          visitedNodes.add(i);
        }
      }
    }

    return false;
  }

  public BSTNode constructMinimalHeightBST(List<Integer> input, BSTNode root) {
    int size = input.size();
    int mid = size / 2;

    int data = input.get(mid);
    if (root == null)
      root = new BSTNode(data);

    if (mid > 0) {
      root.setLeft(constructMinimalHeightBST(input.subList(0, mid), null));
    }

    if (mid + 1 < size) {
      root.setRight(constructMinimalHeightBST(input.subList(mid + 1, size), null));
    }

    return root;
  }
}
