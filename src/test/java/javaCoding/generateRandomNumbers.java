package javaCoding;

import java.util.concurrent.ThreadLocalRandom;

public class generateRandomNumbers {
    public static void main(String[] args) {

        int min = 1, max =100;
        System.out.println("Generating random numbers between " + min + " and " + max + ":"+
                 generateRandomNum(min, max));
    }

    public static int generateRandomNum(int min, int max)
    {

        return ThreadLocalRandom.current().nextInt(min, max+1);
    }
}
