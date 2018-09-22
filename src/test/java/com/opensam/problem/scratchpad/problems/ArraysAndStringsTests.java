package com.opensam.problem.scratchpad.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

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

  @Test
  public void isAnyPermutationAPalindrome() {
    Assert.assertFalse(arraysAndStrings.isAnyPermutationAPalindrome(null));
    Assert.assertFalse(arraysAndStrings.isAnyPermutationAPalindrome(""));

    Assert.assertTrue(arraysAndStrings.isAnyPermutationAPalindrome("Tact Coa"));

    Assert.assertFalse(arraysAndStrings.isAnyPermutationAPalindrome("Nope"));
  }

  @Test
  public void areStringsRotatedTests() {
    Assert.assertFalse(arraysAndStrings.areStringsRotated(null, "abc"));
    Assert.assertFalse(arraysAndStrings.areStringsRotated("abc", null));
    Assert.assertFalse(arraysAndStrings.areStringsRotated("abc", "abcd"));

    Assert.assertTrue(arraysAndStrings.areStringsRotated("waterbottle", "erbottlewat"));
    Assert.assertTrue(arraysAndStrings.areStringsRotated("waterbottle", "waterbottle"));
  }

  @Test
  public void getPairsToMakeSumEqualTests() {
    Assert.assertNull(arraysAndStrings.getPairsToMakeSumEqual(null, null));
    Assert.assertNull(arraysAndStrings.getPairsToMakeSumEqual(new int[]{}, new int[]{3,6,3,3}));

    Assert.assertEquals(Arrays.asList(1, 3), arraysAndStrings.getPairsToMakeSumEqual(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3}));
  }
}
