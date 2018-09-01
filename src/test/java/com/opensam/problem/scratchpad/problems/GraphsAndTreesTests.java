package com.opensam.problem.scratchpad.problems;

import com.opensam.problem.scratchpad.models.BSTNode;
import com.opensam.problem.scratchpad.models.Edge;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

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
