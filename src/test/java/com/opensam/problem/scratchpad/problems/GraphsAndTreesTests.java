package com.opensam.problem.scratchpad.problems;

import com.opensam.problem.scratchpad.models.BSTNode;
import com.opensam.problem.scratchpad.models.BinaryNode;
import com.opensam.problem.scratchpad.models.Edge;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@RunWith(SpringRunner.class)
public class GraphsAndTreesTests {
  private GraphsAndTrees graphsAndTrees;

  @Before
  public void before() {
    graphsAndTrees = new GraphsAndTrees();
  }

  @Test
  public void routeBetweenNodesTests() {
    Assert.assertFalse(graphsAndTrees.routeBetweenNodes(null, 0, 0));
    Assert.assertFalse(graphsAndTrees.routeBetweenNodes(new int[5][6], 0, 0));
    Assert.assertFalse(graphsAndTrees.routeBetweenNodes(new int[5][5], 5, 0));
    Assert.assertFalse(graphsAndTrees.routeBetweenNodes(new int[5][5], 0, 5));

    Assert.assertTrue(graphsAndTrees.routeBetweenNodes(populateConnectivity(new int[5][5], new Edge(1, 0), new Edge(1, 2), new Edge(0, 2), new Edge(3, 2), new Edge(2, 4)), 1, 4));
    Assert.assertFalse(graphsAndTrees.routeBetweenNodes(populateConnectivity(new int[5][5], new Edge(1, 0), new Edge(1, 2), new Edge(0, 2), new Edge(3, 2)), 1, 4));
  }

  @Test
  public void constructMinimalHeightBSTTests() {
    List<Integer> oddInput = Arrays.asList(3,5,7,9,12,15,17);
    BSTNode root = graphsAndTrees.constructMinimalHeightBST(oddInput, null);
    Assert.assertEquals(3, getBinTreeHeight(root));

    List<Integer> evenInput = Arrays.asList(3,5,7,9,10,12,15,17);
    root = graphsAndTrees.constructMinimalHeightBST(evenInput, null);
    Assert.assertEquals(4, getBinTreeHeight(root));
  }

  @Ignore
  @Test
  public void getPathCountWithSumTests() {
    BinaryNode root = constructBinaryTree(Arrays.asList(5, -1, 4, -2, 3, 2, 7, -5));

    Assert.assertEquals(2, graphsAndTrees.getPathCountWithSum(root, 7));
  }

  private BinaryNode constructBinaryTree(List<Integer> input) {
    BinaryNode root = new BinaryNode(input.get(0));

    for(int i = 1; i< input.size();i++)
      insertInCompleteFashion(root, input.get(i));

    return root;
  }

  private void insertInCompleteFashion(BinaryNode root, Integer data) {
    Queue<BinaryNode> queue = new LinkedList<>();
    queue.add(root);
    while(true) {
        BinaryNode currentNode = queue.poll();
        if(currentNode.getLeft() == null) {
          currentNode.setLeft(new BinaryNode(data));
          break;
        } else if (currentNode.getRight() == null) {
          currentNode.setRight(new BinaryNode(data));
          break;
        }

        queue.add((BinaryNode) currentNode.getLeft());
        queue.add((BinaryNode) currentNode.getRight());
    }
  }

  private int getBinTreeHeight(BSTNode root) {
    if(root == null)
      return 0;
    return 1 + Math.max(
        getBinTreeHeight(root.getLeft()),
        getBinTreeHeight(root.getRight())
    );
  }

  private int[][] populateConnectivity(int[][] adj, Edge... edges) {
    for(Edge edge : edges) {
      adj[edge.getFrom()][edge.getTo()] = 1;
    }

    return adj;
  }
}
