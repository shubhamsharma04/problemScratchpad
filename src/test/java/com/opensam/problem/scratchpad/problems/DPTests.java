package com.opensam.problem.scratchpad.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
public class DPTests {

  private DP dp;

  @Before
  public void before() {
    dp = new DP();
  }

  @Test
  public void buildAllPermutationsTest() {
    List<String> output = new LinkedList<>();
    dp.buildAllPermutations("ABC", output);
    output.forEach(System.out::println);
  }

  @Test
  public void getLongestPathTest() {
    int input[][] = new int [][]{{1,2,9},{5,3,8},{4,6,7}};
    Assert.assertEquals(4, dp.getLongestPath(input));
  }

  @Test
  public void knapsackTest() {
    Assert.assertEquals(220, dp.knapsack(new int[]{10, 20, 30}, new int[]{60, 100, 120}, 50, 0));
  }
}
