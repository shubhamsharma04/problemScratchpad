package com.opensam.problem.scratchpad.problems;

import com.opensam.problem.scratchpad.models.DirectedGraphAdjacencyMatrix;
import com.opensam.problem.scratchpad.models.Edge;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

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

  private int[][] populateConnectivity(int[][] adj, Edge... edges) {
    for(Edge edge : edges) {
      adj[edge.getFrom()][edge.getTo()] = 1;
    }

    return adj;
  }
}
