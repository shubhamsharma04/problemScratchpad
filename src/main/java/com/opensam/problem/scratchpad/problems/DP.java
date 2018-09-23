package com.opensam.problem.scratchpad.problems;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DP {

  public void buildAllPermutations(String input, List<String> output){
    if(input.length() <= 1){
      output.add(input);
    } else {
      buildAllPermutations(input.substring(0, input.length() - 1), output);

      getAllInfixes(output, input.charAt(input.length() - 1));
    }
  }

  private void getAllInfixes(List<String> previousOutput, char infix) {
    List<String> output = new LinkedList<>();
    int length = previousOutput.size();
    previousOutput.forEach(str ->
        {
          for (int i = 0; i <= length; i++) {
            StringBuilder s = new StringBuilder(str);
            output.add(s.insert(i, infix).toString());
          }
        }
    );
    previousOutput.clear();
    previousOutput.addAll(output);
  }

  public int getLongestPath (int [][] input) {

    if (input == null || input.length == 0)
      return -1;

    int rows = input.length;
    int cols = input[0].length;

    int past[][] = new int [rows][cols];
    int currMax = 0;

    for (int i = 0; i < rows; i++) {
      for(int j = 0; j < cols; j++) {
        if(past[i][j] == 0) {
          int pathLength = getPathLength(input, past, i , j);

          past[i][j] = pathLength;
          if(pathLength > currMax) {
            currMax = pathLength;
          }
        }
      }
    }

    return currMax;
  }

  private int getPathLength(int [][] input, int [][] past, int i, int j) {

    if(past[i][j] != 0)
      return past[i][j];

    int pathLength = 1;
    int currElement = input[i][j];

    if (i > 0 && input[i - 1][j] == currElement + 1) {
      pathLength += getPathLength(input, past, i - 1, j);
      past[i][j] = pathLength;
    } else if (j > 0 && input[i][j - 1] == currElement + 1) {
      pathLength += getPathLength(input, past, i, j - 1);
      past[i][j] = pathLength;
    }  else if (i < input.length - 1 && input[i + 1][j] == currElement + 1) {
      pathLength += getPathLength(input, past, i + 1, j);
      past[i][j] = pathLength;
    } else if (j < input[0].length - 1 && input[i][j + 1] == currElement + 1) {
      pathLength += getPathLength(input, past, i, j + 1);
      past[i][j] = pathLength;
    }

    return pathLength;

  }

  public int knapsack(int[] weight, int[] value, int w, int i) {
    if (i == weight.length || w == 0)
      return 0;

    if (weight[i] <= w) {
      return Math.max(
          value[i] + knapsack(weight, value, w - weight[i], i + 1), knapsack(weight, value, w, i + 1));
    }

    return knapsack(weight, value, w, i + 1);
  }
}
