package com.opensam.problem.scratchpad.problems;

import org.springframework.stereotype.Component;

@Component
public class BitManipulation {

  public int insertInBetween(int N, int M, int j, int i) {
    for (int x = j; x <= i; x++)
      N = N & (~(1 << j));
    M = M << j;
    return N | M;
  }
}
