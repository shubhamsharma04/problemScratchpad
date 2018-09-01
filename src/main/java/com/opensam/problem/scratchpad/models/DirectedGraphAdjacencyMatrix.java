package com.opensam.problem.scratchpad.models;

public class DirectedGraphAdjacencyMatrix {
  private int N;
  private int adjacencyMatrix[][];

  public DirectedGraphAdjacencyMatrix(int N) {
    this.N = N;
    adjacencyMatrix = new int[N][N];
  }

  public int getN() {
    return N;
  }

  public void setN(int n) {
    N = n;
  }

  public int[][] getAdjacencyMatrix() {
    return adjacencyMatrix;
  }

  public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
    this.adjacencyMatrix = adjacencyMatrix;
  }
}
