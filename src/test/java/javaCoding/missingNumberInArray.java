package javaCoding;

public class missingNumberInArray {

    public static void main(String[] args) {
            int total;
            int []numbers = new int[]{1,2,3,5,6,7};
            total =7;
            int expected = total*(total + 1)/2;
            int num_sum =0;

            for(int i:numbers)
            {
                num_sum += i;
            }
     System.out.println(expected-num_sum);

//        int[] arr = {1, 2, 3, 5, 6, 7, 8, 9, 10};
//        int n = arr.length;
//        System.out.println("Missing number: " + findMissingNumber(arr, n));
//    }
//
//    private static String findMissingNumber(int[] arr, int n) {
//        int sum = (n * (n + 1)) / 2;
//        for (int i = 0; i < n; i++) {
//            sum -= arr[i];
//        }
//        return String.valueOf(sum);
//    }
    }
}
