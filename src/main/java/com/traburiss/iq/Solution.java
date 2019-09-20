package com.traburiss.iq;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by traburiss on 2019/9/19.
 * describe: a interesting question solution
 */
@Slf4j
public enum  Solution {
    instance;
    Solution(){
        for (int i = 0; i < digitsStage2.length; i++) {
            int i1 = i%digits.length;
            digitsStage2[i] = digits[i1];
        }
    }
    private final String[] digits = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private final String[] digitsStage2 = new String[100];

    /**
     * the first solution
     * @param nums integer array , need in [0,9]
     */
    public List<String> solution(int[] nums){
        List<String> resList = new ArrayList<String>();
        if (nums.length > 0){
            solution(nums, digits,0, resList, "");
        }
        return resList;
    }

    /**
     * the second solution
     * @param nums integer array , need in [0,99]
     */
    public List<String> solutionStage2(int[] nums){
        List<String> resList = new ArrayList<String>();
        if (nums.length > 0){
            solution(nums, digitsStage2,0,resList, "");
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
    private void solution(int[] nums, String[] digits, int index, List<String> resList, String res){
        if (index < nums.length){
            int num = nums[index];
            if (num < 0 || num >= digits.length) {
                throw new IndexOutOfBoundsException("nums should in [0,"  + (digits.length - 1) + "]");
            }
            else {
                String letterList = digits[num];
                if (letterList.length() == 0){
                    solution(nums, digits, ++index, resList, res);
                }else {
                    for (int i = 0; i < letterList.length(); i++) {
                        char letter = letterList.charAt(i);
                        solution(nums, digits, index + 1, resList, res + letter);
                    }
                }
            }
        }else {
            resList.add(res);
        }
    }
}
