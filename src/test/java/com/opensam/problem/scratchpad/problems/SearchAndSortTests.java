package com.opensam.problem.scratchpad.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class SearchAndSortTests {

  private SearchAndSort searchAndSort;

  @Before
  public void before() {
    searchAndSort = new SearchAndSort();
  }

  @Test
  public void mergeSortTest() {
    int[] input = new int[]{1, 4, 5, 2, 8, 9};

    searchAndSort.mergeSort(input, 0, input.length - 1);
  }

  @Test
  public void sortWithAnagramCaveat() {
    List<String> input = Arrays.asList("abc","cab","bca", "aaa","b","123", "qwert");
    List<String> result = searchAndSort.sortWithAnagramCaveat(input);
    result.forEach(System.out::println);
  }

  @Test
  public void getIndexTest() {
    Assert.assertEquals(8, searchAndSort.getIndex(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
    Assert.assertEquals(7, searchAndSort.getIndex(new int[]{15, 16, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
    Assert.assertEquals(6, searchAndSort.getIndex(new int[]{15, 16, 20, 1, 3, 4, 5, 7, 10, 14}, 5));
    Assert.assertEquals(6, searchAndSort.getIndex(new int[]{15, 16, 20, 1, 3, 4, 5, 10, 14}, 5));
    Assert.assertEquals(3, searchAndSort.getIndex(new int[]{1, 3, 4, 5}, 5));
  }
}
