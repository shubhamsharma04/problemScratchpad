package com.opensam.problem.scratchpad.problems;

import com.opensam.problem.scratchpad.models.Trie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TrieInsertAndSearchTests {

  private TrieInsertAndSearch trieInsertAndSearch;

  @Before
  public void before(){
    trieInsertAndSearch = new TrieInsertAndSearch();
  }

  @Test
  public void trieInsertAndSearchTest () {
    Trie root = trieInsertAndSearch.insert();
    Assert.assertEquals("Many", trieInsertAndSearch.searchNext(root, "Man"));
    Assert.assertEquals("Many", trieInsertAndSearch.searchNext(root, "M"));
    Assert.assertEquals("More", trieInsertAndSearch.searchNext(root, "More"));
  }
}
