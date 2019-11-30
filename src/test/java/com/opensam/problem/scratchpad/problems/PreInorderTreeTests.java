package com.opensam.problem.scratchpad.problems;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PreInorderTreeTests {
  private PreInorderTree preInorderTree;

  @Before
  public void before() {
    preInorderTree = new PreInorderTree();
  }

  @Test
  public void happyPath() {
    int [] preorder = new int[]{3,9,20,15,7};
    int [] inorder = new int[]{9,3,15,20,7};

    preInorderTree.buildTree(preorder, inorder);
    System.out.println(Integer.toBinaryString(240));
  }
}
