package javaCoding;

public class fibonacci {

    public static void main(String[] args) {
        int n=10, num1=0, num2 =1;

        for (int i =1; i<n; i++)
        {
            int num3= num1+num2;
            System.out.println(" , " + num3);
            num1=num2;
            num2=num3;
        }
    }
}
