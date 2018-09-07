package com.opensam.problem.scratchpad.problems;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

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

}
