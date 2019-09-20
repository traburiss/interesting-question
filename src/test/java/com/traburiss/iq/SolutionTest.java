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

        List<String> result;
        result = Solution.instance.solution(new int[]{2,3});
        log.info("result1 is {}", result);
        result = Solution.instance.solution(new int[]{1,0});
        log.info("result1 is {}", result);
        result = Solution.instance.solution(new int[]{0,2,3});
        log.info("result2 is {}", result);
        result = Solution.instance.solution(new int[]{0,1,2,3,2,1,0});
        log.info("result3 is {}", result);

        expect.expect(IndexOutOfBoundsException.class);
        expect.expectMessage("nums should in [0,9]");
        Solution.instance.solution(new int[]{0,1,2,11,2,1,0});
    }

    @Test
    public void solutionStage2Test(){

        List<String> result;
        result = Solution.instance.solutionStage2(new int[]{33,2,98});
        log.info("result1 is {}", result);
        result = Solution.instance.solutionStage2(new int[]{1,11,21});
        log.info("result1 is {}", result);
        result = Solution.instance.solutionStage2(new int[]{0,2,3,99});
        log.info("result2 is {}", result);
        result = Solution.instance.solutionStage2(new int[]{0,1,2,3,11,2,1,0});
        log.info("result3 is {}", result);

        expect.expect(IndexOutOfBoundsException.class);
        expect.expectMessage("nums should in [0,99]");
        Solution.instance.solutionStage2(new int[]{0,1,2,100,2,1,0});
    }
}
