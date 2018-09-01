package com.opensam.problem.scratchpad.problems;

import org.springframework.stereotype.Component;

import java.util.Arrays;
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

      while(!pathQ.isEmpty()){
        int source = ((LinkedList<Integer>) pathQ).remove();

        if(source == to)
          return true;

        for(int i=0; i < adj.length; i++) {
          if(adj[source][i] != 0 && !visitedNodes.contains(i)) {
            pathQ.add(i);
            visitedNodes.add(i);
          }
        }
      }

      return false;
    }
}
