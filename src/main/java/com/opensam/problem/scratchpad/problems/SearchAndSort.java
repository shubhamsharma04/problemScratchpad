package com.opensam.problem.scratchpad.problems;

import com.opensam.problem.scratchpad.models.AnagramComparator;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class SearchAndSort {

  public void quickSort(int [] arr) {
    if(arr != null) {
      quickSort(arr, 0, arr.length - 1);
    }
  }

  private void quickSort(int [] arr, int left, int right) {
    int partition = getPartition(arr, left, right);
    if(left < partition - 1) {
      quickSort(arr, left, partition - 1);
    }

    if(partition < right) {
      quickSort(arr, partition, right);
    }
  }

  private int getPartition(int [] arr, int left, int right) {
    int pivot = arr[(left + right)/2];

    while(left <= right) {
      while(arr[left] < pivot) left++;
      while(arr[right] > pivot) right--;

      if(left <= right) {
        swap(arr, left, right);
        left++;
        right--;
      }
    }

    return left;
  }

  private void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  public void mergeSort(int [] input) {
    if(input == null || input.length == 0) {
      return;
    }

    mergeSort(input, new int[input.length], 0, input.length - 1);
  }

  public void mergeSort(int [] input, int [] helper, int left, int right) {
    if(left < right) {
      int middle = (left + right) / 2;
      mergeSort(input, helper, left, middle);
      mergeSort(input, helper, middle + 1, right);
      merge(input, helper, left, middle, right);
    }
  }

  private void merge(int [] input, int [] helper, int left, int middle, int right) {
    for(int i=left; i <= right; i++) {
      helper[i] = input[i];
    }

    int leftIndex = left;
    int currentIndex = left;
    int rightIndex = middle + 1;

    while(leftIndex <= middle && rightIndex <= right) {
      if(helper[leftIndex] < helper[rightIndex]) {
        input[currentIndex] = helper[leftIndex++];
      } else {
        input[currentIndex] = helper[rightIndex++];
      }

      currentIndex++;
    }

    while(leftIndex <= middle) {
      input[currentIndex++] = helper[leftIndex++];
    }
  }

  public List<String> sortWithAnagramCaveat(List<String> input) {
    if(input == null)
      return null;

    input.sort(new AnagramComparator());

    return input;
  }

  public int getIndex(int[] input, int element) {
    List<Integer> l = new LinkedList<>();
    int [] copy = new int[l.size()];
    l.toArray(new int[][]{copy});

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
