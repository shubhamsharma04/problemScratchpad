package com.opensam.problem.scratchpad.problems;

import java.util.Set;
import java.util.HashSet;

public class ArraySumPairs {

  public static void main(String [] args) {
    int [] input = new int[] {1,2,6,0,-5,11,20};
    int sum = 8;

    Set<Tuple> pairs = getPairs(input, sum);

    pairs.stream()
        .forEach(System.out::println);
  }

  private static Set<Tuple> getPairs(int [] input, int sum) {
    Set<Tuple> result = new HashSet<>();

    if(input == null || input.length <= 1)
      return result;

    Set<Integer> inputElements = new HashSet<>();

    for(int i : input)
      inputElements.add(i);

    for(int i : input) {
      if(inputElements.contains(sum - i)) {
        result.add(new Tuple(i, sum - i));
      }
    }

    return result;

  }

}

class Tuple {
  int first;
  int second;

  public Tuple(int first, int second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public String toString() {
    return this.first +" " +this.second;
  }

  @Override
  public int hashCode() {
    return (first*10 + second) + (second*10 + first);
  }

  @Override
  public boolean equals(Object o) {
    if(o == null || !(o instanceof Tuple))
      return false;
    if( o == this)
      return true;
    Tuple that = (Tuple) o;
    return (this.first == that.first && this.second == that.second) || (this.first == that.second && this.second == that.first) ;
  }
}

