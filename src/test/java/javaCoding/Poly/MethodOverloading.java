package javaCoding.Poly;

import org.example.Main;

public class MethodOverloading {

    public int dosomething(int a, int b)
    {
        return a+b;
    }

    public int dosomething(int a, int b, int c)
    {
        return a+b+c;
    }

    public int dosomething(int a, int b, int c, int d)
    {
        return a+b+c+d;
    }

    public static void main(String[] args) {

        MethodOverloading obj = new MethodOverloading();
        System.out.println(obj.dosomething(4,5));
        System.out.println(obj.dosomething(4,5));
        System.out.println(obj.dosomething(4,5,6));
        System.out.println(obj.dosomething(4,5,6,7));
    }
}
