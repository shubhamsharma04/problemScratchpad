package com.opensam.problem.scratchpad.problems;

import org.springframework.stereotype.Component;

@Component
public class Fibo {

  public int calculateFibo(int limit) {
    if (limit < 0) {
      throw new IllegalArgumentException("Please enter something greater than 0");
    }

    if (limit == 0) {
      return 0;
    }

    int[] fibonacciSeries = new int[limit + 1];
    fibonacciSeries[0] = 0;
    fibonacciSeries[1] = 1;

    for (int index = 2; index <= limit; index++) {
      fibonacciSeries[index] = fibonacciSeries[index - 1] + fibonacciSeries[index - 2];
    }

    return fibonacciSeries[limit];
  }
}
