package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem01 {

    public int[] twoSum(int[]nums, int target){

        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int diff= target - nums[i];

            if(numMap.containsKey(diff)){
                return new int[]{numMap.get(diff), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Problem01 solution = new Problem01();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
