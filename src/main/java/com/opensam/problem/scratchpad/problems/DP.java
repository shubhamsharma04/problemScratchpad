package com.opensam.problem.scratchpad.problems;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class DP {

  public void buildAllPermutations(String input, List<String> output){
    if(input.length() <= 1){
      output.add(input);
    } else {
      buildAllPermutations(input.substring(0, input.length() - 1), output);

      getAllInfixes(output, input.charAt(input.length() - 1));
    }
  }

  private void getAllInfixes(List<String> previousOutput, char infix) {
    List<String> output = new LinkedList<>();
    int length = previousOutput.size();
    previousOutput.forEach(str ->
        {
          for (int i = 0; i <= length; i++) {
            StringBuilder s = new StringBuilder(str);
            output.add(s.insert(i, infix).toString());
          }
        }
    );
    previousOutput.clear();
    previousOutput.addAll(output);
  }

}
