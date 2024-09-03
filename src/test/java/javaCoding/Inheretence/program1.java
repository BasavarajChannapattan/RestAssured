package javaCoding.Inheretence;

public class program1 {


    static class Vechicle{
        protected  String brand="BMW0";
        public void sound()
        {
            System.out.println("Budrrrrrrrrrrrrrrrr");
        }
    }

    static class Car extends Vechicle{
        private String modelName ="Ford";

        public static void main(String[] args) {
            Car myCar = new Car();
            myCar.sound();
            System.out.println(myCar.brand);
            System.out.println(myCar.modelName);
        }
    }
}
