package com.traburiss.iq;

import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

/**
 * Created by traburiss on 2019/9/19.
 * describe:a interesting question solution test
 */
@Slf4j
public class SolutionTest {

    @Rule
    public final ExpectedException expect = ExpectedException.none();

    @Test
    public void solutionTest(){

        List<String> output;
        int[] input = new int[]{2,3};
        output = Solution.instance.solution(input);
        log.info("input1 is {} output1 is {}", input, output);

        input = new int[]{1,0};
        output = Solution.instance.solution(input);
        log.info("input1 is {} output1 is {}", input, output);

        input = new int[]{0,2,3};
        output = Solution.instance.solution(input);
        log.info("input1 is {} output1 is {}", input, output);

        input = new int[]{0,1,2,3,2,1,0};
        output = Solution.instance.solution(input);
        log.info("input1 is {} output1 is {}", input, output);

        expect.expect(IndexOutOfBoundsException.class);
        expect.expectMessage("nums should in [0,9]");
        input = new int[]{0,1,2,11,2,1,0};
        Solution.instance.solution(input);
    }

    @Test
    public void solutionStage2Test(){

        List<String> output;
        int[] input = new int[]{2,33};
        output = Solution.instance.solutionStage2(input);
        log.info("input2 is {} output2 is {}", input, output);

        input = new int[]{1,11,21};
        output = Solution.instance.solutionStage2(input);
        log.info("input2 is {} output2 is {}", input, output);

        input = new int[]{0,2,3,99};
        output = Solution.instance.solutionStage2(input);
        log.info("input2 is {} output2 is {}", input, output);

        input = new int[]{0,1,2,3,11,2,1,0};
        output = Solution.instance.solutionStage2(input);
        log.info("input2 is {} output2 is {}", input, output);

        expect.expect(IndexOutOfBoundsException.class);
        expect.expectMessage("nums should in [0,99]");
        input = new int[]{0,1,2,100,2,1,0};
        Solution.instance.solutionStage2(input);
    }
}
