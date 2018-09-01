package com.opensam.problem.scratchpad.models;

import java.util.List;

public class DirectedGraphAdjacencyList {
  public List<Node> getAdjacencyList() {
    return adjacencyList;
  }

  public void setAdjacencyList(List<Node> adjacencyList) {
    this.adjacencyList = adjacencyList;
  }

  private List<Node> adjacencyList;
}
