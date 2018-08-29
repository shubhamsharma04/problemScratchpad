package com.opensam.problem.scratchpad.problems;

import com.opensam.problem.scratchpad.models.Node;
import org.springframework.stereotype.Component;

@Component
public class LinkedLists {

  public Node getKthElement(Node head, int k) {
    if (head == null || k <= 0)
      return head;

    Node last = head;
    for (int i = 0; i < k; i++) {
      last = last.getNext();
      if (last == null)
        return last;
    }

    Node kThElement = head;
    while (last.getNext() != null) {
      last = last.getNext();
      kThElement = kThElement.getNext();
    }

    return kThElement;
  }
}
