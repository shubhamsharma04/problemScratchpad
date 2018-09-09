package com.opensam.problem.scratchpad.models;

import java.util.Objects;

public class Edge implements Comparable<Edge>{

  private int from;
  private int to;
  private int weight;

  public Edge(int from, int to, int weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }

  public Edge(int to, int weight) {
    this.to = to;
    this.weight = weight;
  }

  public int getFrom() {
    return from;
  }

  public void setFrom(int from) {
    this.from = from;
  }

  public int getTo() {
    return to;
  }

  public void setTo(int to) {
    this.to = to;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public int compareTo(Edge o) {
    return this.weight - o.getWeight();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Edge edge = (Edge) o;
    return from == edge.from &&
        to == edge.to &&
        weight == edge.weight;
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to, weight);
  }
}
