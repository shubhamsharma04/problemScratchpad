package com.opensam.problem.scratchpad.problems;

import com.opensam.problem.scratchpad.models.AnagramComparator;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

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

  public List<String> sortWithAnagramCaveat(List<String> input) {
    if(input == null)
      return null;

    Collections.sort(input, new AnagramComparator());

    return input;
  }

  public int getIndex(int[] input, int element) {
    if (input == null || input.length == 0)
      return -1;

    int length = input.length;

    int rotatedIndex = length == 1 ?
        0 :
        getRotatedIndex(input, 0, length - 1);

    int start = element > input[0] && element < input[rotatedIndex] ? 0 : rotatedIndex;
    int end = start != 0 ? length - 1 : rotatedIndex;

    return binarySearch(input, element, start, end);
  }

  private int getRotatedIndex(int[] input, int start, int end) {
    if (start == end - 1)
      return end;
    int mid = (start + end) / 2;

    if (input[mid] > input[start])
      return getRotatedIndex(input, mid, end);
    else
      return getRotatedIndex(input, start, mid);

  }

  private int binarySearch(int[] input, int element, int start, int end) {
    if (start > end)
      return -1;

    int mid = (start + end) / 2;

    if (input[mid] == element)
      return mid;
    if (input[mid] < element)
      return binarySearch(input, element, mid + 1, end);
    return binarySearch(input, element, start, mid - 1);
  }
}
