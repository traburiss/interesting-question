package com.traburiss.iq;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by traburiss on 2019/9/19.
 * describe: a interesting question solution
 */
@Slf4j
public enum  Solution {
    instance;
    private static char[][] digits = {
            {},{},{'a','b','c'}, {'d','e','f'},
            {'g','h','i'},{'j','k','l'}, {'m','n','o'},
            {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    /**
     * the first solution
     * @param nums integer array , need in [0,9]
     */
    public List<String> solution(int[] nums){
        List<String> resList = new ArrayList<String>();
        if (nums.length > 0){
            solution(nums, 0, resList, "");
        }
        return resList;
    }
    /**
     * real solution
     * @param nums integer array , need in [0,9]
     * @param index the nums index
     * @param resList the result list
     * @param res the result
     */
    private void solution(int[] nums, int index, List<String> resList, String res){
        if (index < nums.length){
            int num = nums[index];
            if (num < 0 || num > digits.length) throw new IndexOutOfBoundsException("num should in [0,9]");
            else if (num == 0 || num == 1){
                solution(nums, ++index, resList, res);
            } else {
                char[] letterList = digits[num];
                for (char letter : letterList) {
                    solution(nums, index + 1, resList, res + letter);
                }
            }
        }else {
            resList.add(res);
        }
    }
}
