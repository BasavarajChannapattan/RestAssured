package javaCoding;

public class prime {

    public static void main(String[] args) {

        int num=11;
        boolean isPrime = true;

        for (int i =2; i<Math.sqrt(num); i++)
        {
           if(num%i==0)
           {
               isPrime =false;
               break;

           }

        }

        if (isPrime)
        {
            System.out.println("It's a prime number: " + num);
        }
        else
        {
            System.out.println("It's not a prime number: " + num);
        }


    }
}
