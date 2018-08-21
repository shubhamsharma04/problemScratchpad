package com.opensam.problem.scratchpad.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ArraysAndStringsTests {

  private ArraysAndStrings arraysAndStrings;

  @Before
  public void before() {
    arraysAndStrings = new ArraysAndStrings();
  }

  @Test
  public void isPermutationTests () {
    Assert.assertFalse(arraysAndStrings.isPermutation(null, null));
    Assert.assertFalse(arraysAndStrings.isPermutation(null, "12"));
    Assert.assertFalse(arraysAndStrings.isPermutation("", "some"));

    Assert.assertTrue(arraysAndStrings.isPermutation("", ""));
    Assert.assertTrue(arraysAndStrings.isPermutation("avbbbss", "avbbbss"));
    Assert.assertTrue(arraysAndStrings.isPermutation("avbbs", "avsbb"));

    Assert.assertFalse(arraysAndStrings.isPermutation("qwerty", "some"));
  }
}