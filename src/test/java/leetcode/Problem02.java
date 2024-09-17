package leetcode;

import javaCoding.palindrome;

public class Problem02 {
    public boolean isPalindrome(int x) {
        String original = String.valueOf(x);
        String reversed = new StringBuilder(original).reverse().toString();
        return original.equals(reversed);
    }


    public static void main (String[] args)
    {
        Problem02 sol = new Problem02();
        boolean res = sol.isPalindrome(121);
        System.out.println(res);
    }
}
