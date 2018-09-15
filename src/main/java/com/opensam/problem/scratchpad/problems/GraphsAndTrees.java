package com.opensam.problem.scratchpad.problems;

import com.opensam.problem.scratchpad.models.BSTNode;
import com.opensam.problem.scratchpad.models.BinaryNode;
import com.opensam.problem.scratchpad.models.Edge;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
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

  public int getPathCountWithSum(BinaryNode node, int sum) {
    return getPathCountWithSum(node, sum, sum);
  }

  public int[] djikstra(List<List<Edge>> adjList) {
    Set<Integer> coveredVertices = new HashSet<>();
    Queue<Edge> priorityQueue = new PriorityQueue<>();
    int[] output = new int[adjList.size()];

    priorityQueue.addAll(adjList.get(0));
    coveredVertices.add(0);

    while (coveredVertices.size() != adjList.size() - 1) {
      Edge leastWeightEdge = priorityQueue.remove();

      while(!coveredVertices.contains(leastWeightEdge.getTo())) {
        leastWeightEdge = priorityQueue.remove();
      }

      int currentMinWeight = leastWeightEdge.getWeight();

      output[leastWeightEdge.getTo()] = currentMinWeight;
      coveredVertices.add(leastWeightEdge.getTo());
      List<Edge> newEdges = adjList.get(leastWeightEdge.getTo());
      newEdges.forEach(edge -> priorityQueue.add(new Edge(edge.getFrom(), edge.getTo(), edge.getWeight() + currentMinWeight)));
    }
    return output;
  }

  private int getPathCountWithSum(BinaryNode node, int totalSum, int sumNeeded) {
    if(node == null)
      return 0;

    int currentCount = node.getData() == sumNeeded
        ? 1
        : 0;

    return currentCount + getPathCountWithSum((BinaryNode) node.getLeft(), totalSum, sumNeeded - node.getData())
                        + getPathCountWithSum((BinaryNode) node.getRight(), totalSum, sumNeeded - node.getData())
                        + getPathCountWithSum((BinaryNode) node.getLeft(), totalSum, totalSum)
                        + getPathCountWithSum((BinaryNode) node.getRight(), totalSum, totalSum);

  }
}
