package javaCoding;

public class ReverseString {


    public static void main(String[] args) {
        //declare string
        String name ="Basava";
        //split the strin
        StringBuilder str = new StringBuilder(name).reverse();
        System.out.println(str);
    }


}
