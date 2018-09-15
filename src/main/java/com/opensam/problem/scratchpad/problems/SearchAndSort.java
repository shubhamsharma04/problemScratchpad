package com.opensam.problem.scratchpad.problems;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SearchAndSort {

  public void mergeSort(int[] input, int start, int end) {
    if (start >= end)
      return;

    int mid = (start + end) / 2;

    mergeSort(input, start, mid);
    mergeSort(input, mid+1, end);
    merge(input, start, mid, end);

  }

  private static void merge(int[] input, int start, int mid, int end) {
    int [] helper = new int[input.length];
    for (int i = start; i <= end; i++) {
      helper[i] = input[i];
    }

    int rightStart = mid + 1;

    int currIndex = start;
    while (start <= mid && rightStart <= end) {
      if (helper[start] <= helper[rightStart]) {
        input[currIndex] = helper[start];
        start++;
      } else {
        input[currIndex] = helper[rightStart];
        rightStart++;
      }

      currIndex++;
    }

    while (start <= mid) {
      input[currIndex++] = helper[start++];
    }

    while (rightStart <= end) {
      input[currIndex++] = helper[rightStart++];
    }
  }
}
