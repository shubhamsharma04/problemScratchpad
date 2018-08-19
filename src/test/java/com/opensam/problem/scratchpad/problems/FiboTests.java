package com.opensam.problem.scratchpad.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class FiboTests {

  private Fibo fibo;

  @Before
  public void before() {
    fibo = new Fibo();
  }

  @Test
  public void calculateFiboShouldHandleZero() {
    Assert.assertEquals(0, fibo.calculateFibo(0));
  }

  @Test
  public void calculateFiboShouldHandleNonZero() {
    Assert.assertEquals(5, fibo.calculateFibo(5));
  }

}
