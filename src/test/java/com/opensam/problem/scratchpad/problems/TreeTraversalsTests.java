package com.opensam.problem.scratchpad.problems;

import com.opensam.problem.scratchpad.models.Tree;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
public class TreeTraversalsTests {

  private TreeTraversals treeTraversals;
  private Tree root;

  @Before
  public void before() {
    treeTraversals = new TreeTraversals();

    root = buildTree(5,
              buildTree(4,
                  buildTree(2),
                  buildTree(3),
                  buildTree(9)),
              buildTree(1,
                  buildTree(0),
                  buildTree(10)),
              buildTree(-1,
                  buildTree(12,
                      buildTree(13))));

  }

  @Test
  public void dfsTest() {
    treeTraversals.dfs(root);
  }

  @Test
  public void bfsTest() {
    treeTraversals.bfs(root);
  }

  private Tree buildTree(int data, Tree... children) {
    Tree tree = new Tree(data);
    tree.setChildren(Arrays.asList(children));
    return tree;
  }
}
