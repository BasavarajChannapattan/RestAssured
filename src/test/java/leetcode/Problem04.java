package leetcode;

public class Problem04 {
    public boolean isPalindrome(String s) {
        int strLength = s.length();
        String reversedString = "";
        for (int i = (strLength - 1); i >= 0; i--) {

            reversedString = reversedString += s.charAt(i);
        }

        if (s.toLowerCase().equals(reversedString.toLowerCase())) {
            System.out.println("it's a palindrome");
        } else {
            System.out.println("its not palindrome");
        }

        return true;
    }


    public static void main(String[] args) {

        Problem04 problem = new Problem04();
        problem.isPalindrome("A man, a plan, a canal: Panama");
    }
}
