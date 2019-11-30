package com.opensam.problem.scratchpad.problems;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MinHeapTests {

  @Test
  public void testMinHeap() {
    MinHeap minHeap = new MinHeap(5);
    minHeap.insert(3);
    minHeap.insert(5);
    minHeap.insert(-22);
    minHeap.insert(12);
    minHeap.insert(0);

    assertEquals(-22, minHeap.remove());
    assertEquals(0, minHeap.remove());
    assertEquals(3, minHeap.remove());
    assertEquals(5, minHeap.remove());
    assertEquals(12, minHeap.remove());

  }
}
