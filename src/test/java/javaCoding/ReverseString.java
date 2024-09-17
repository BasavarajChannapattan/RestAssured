package javaCoding;

public class ReverseString {


    public static void main(String[] args) {
//        //declare string
//        String name ="Basava";
//        //split the strin
//        StringBuilder str = new StringBuilder(name).reverse();
//        System.out.println(str);



        String name ="Basava";
        String reverse="";

        for(int i=name.length()-1; i>=0; i--)
        {
            reverse+=name.charAt(i);
        }
        System.out.println(reverse);

    }


}
