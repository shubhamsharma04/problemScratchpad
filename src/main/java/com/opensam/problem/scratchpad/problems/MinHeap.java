package com.opensam.problem.scratchpad.problems;

public class MinHeap {
  private static int MAX_SIZE;
  private static int currSize = 0;

  private int[] heap;

  public MinHeap(int size) {
    this.MAX_SIZE = size + 1;
    this.heap = new int[MAX_SIZE];
  }

  public void insert(int element) {
    if (currSize + 1 == MAX_SIZE) {
      throw new IllegalArgumentException("Heap Full");
    }

    heap[currSize + 1] = element;
    currSize++;
    percolateUp();
  }

  public int remove() {
    if (currSize == 0)
      throw new IllegalArgumentException("Heap Empty");

    int min = heap[1];
    heap[1] = heap[currSize];
    currSize--;
    trickleDown();
    return min;
  }

  private void trickleDown() {
    int parentIndex = 1;
    int leftChildIndex = 2 * parentIndex;
    int rightChildIndex = leftChildIndex + 1;
    while (leftChildIndex <= currSize) {
      int indexOfSmaller = rightChildIndex <= currSize ?
          (heap[leftChildIndex] < heap[rightChildIndex] ? leftChildIndex : rightChildIndex) :
          leftChildIndex;

      if (heap[parentIndex] <= heap[indexOfSmaller]) {
        break;
      } else {
        swap(parentIndex, indexOfSmaller);
        parentIndex = indexOfSmaller;
        leftChildIndex = 2 * parentIndex;
        rightChildIndex = leftChildIndex + 1;
      }
    }
  }

  private void percolateUp() {
    int childIndex = currSize;
    int parentIndex = childIndex / 2;

    while (parentIndex >= 1 && heap[childIndex] < heap[parentIndex]) {
      swap(childIndex, parentIndex);

      childIndex = parentIndex;
      parentIndex = childIndex / 2;
    }
  }

  private void swap(int left, int right) {
    int temp = heap[left];
    heap[left] = heap[right];
    heap[right] = temp;
  }
}
