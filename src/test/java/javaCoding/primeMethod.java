package javaCoding;

public class primeMethod {

    public void isPrime(int num) {

        boolean flag = true;
        if (num == 0 || num == 1) {
            flag = false;
        }

        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }

    }


    public static void main(String[] args) {
        primeMethod pm = new primeMethod();
        pm.isPrime(10);
    }
}
