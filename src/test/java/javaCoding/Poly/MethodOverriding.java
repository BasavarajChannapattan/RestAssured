package javaCoding.Poly;

public class MethodOverriding {

    // Base Class
    class Parent {
        void show() { System.out.println("Parent's show()"); }
    }

    // Inherited class
    class Child extends Parent {
        @Override
        void show() {
            System.out.println("Child's show()");
        }
    }

    // Driver method
    public static void main(String[] args) {
        MethodOverriding outer = new MethodOverriding();

        // If a Parent type reference refers to a Parent object, Parent's show() is called
        Parent obj1 = outer.new Parent();
        obj1.show();

        // If a Parent type reference refers to a Child object, Child's show() is called.
        Parent obj2 = outer.new Child();
        obj2.show();
    }
}
