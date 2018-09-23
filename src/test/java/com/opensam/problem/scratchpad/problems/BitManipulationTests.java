package com.opensam.problem.scratchpad.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BitManipulationTests {

  private BitManipulation bitManipulation;

  @Before
  public void before() {
    bitManipulation = new BitManipulation();
  }

  @Test
  public void insertInBetweenTests() {
    Assert.assertEquals(0b10001001100, bitManipulation.insertInBetween(0b10000000000, 0b10011, 2 ,6));
  }

  @Test
  public void scratchTest() {
    bitManipulation.scratch();
  }
}
