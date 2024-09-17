package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem03 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int length = 1;

                while (numSet.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        Problem03 pro =new Problem03();
        int result = pro.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(result);
    }
}
