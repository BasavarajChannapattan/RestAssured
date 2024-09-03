package javaCoding;

public class palindrome {

    public static void main(String[] args) {
        String name = "madam";



        if (isPalindrome(name)) {
            System.out.println("It's a palindrome: " + name);
        } else {
            System.out.println("It's not a palindrome: " + name);
        }
        int num =121;
        if (isPalindrome(String.valueOf(num))) {
            System.out.println("It's a palindrome: " + num);
        } else {
            System.out.println("It's not a palindrome: " + num);
        }
    }

    public static boolean isPalindrome(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }
}
