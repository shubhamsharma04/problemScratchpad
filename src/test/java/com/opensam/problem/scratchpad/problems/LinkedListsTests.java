package com.opensam.problem.scratchpad.problems;

import com.opensam.problem.scratchpad.models.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LinkedListsTests {
  private LinkedLists linkedLists;

  @Before
  public void before() {
    linkedLists = new LinkedLists();
  }

  @Test
  public void getKthElementTest() {
    Assert.assertEquals(null, linkedLists.getKthElement(null, 1));
    Assert.assertEquals(null, linkedLists.getKthElement(new Node(5), 1));

    Assert.assertEquals(5, linkedLists.getKthElement(new Node(5), 0).getData());

    Assert.assertEquals(4, linkedLists.getKthElement(buildNode(8), 3).getData());
    Assert.assertEquals(3, linkedLists.getKthElement(buildNode(8), 2).getData());
  }

  private Node buildNode(int size) {
    if (size == 0)
      return null;

    Node node = new Node(size);
    node.setNext(buildNode(size - 1));
    return node;
  }
}
