package com.opensam.problem.scratchpad.problems;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

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
}
