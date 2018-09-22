package com.opensam.problem.scratchpad.problems;

import com.opensam.problem.scratchpad.models.Tree;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
public class TreeTraversals {

  public void dfs(Tree root) {
    if(root == null)
        return;

    System.out.println(root.getData());
    root.getChildren().stream()
        .forEach(this::dfs);
  }

  public void bfs(Tree root) {
    if(root == null)
      return;

    Queue<Tree> verticesToBeVisited = new LinkedList<>();
    verticesToBeVisited.add(root);

    while(!verticesToBeVisited.isEmpty()) {
      Tree currentVertex = verticesToBeVisited.remove();

      System.out.println(currentVertex.getData());
      verticesToBeVisited.addAll(currentVertex.getChildren());
    }
  }
}
