package lang.java.core;

class Car {
    private int year;

    /**
     * Nested class
     */
    public static class Tire {
        private double radius;

        public Tire(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }
    }

    public Car(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}

public class NestedClass {
   public static void main(String[] args) {
       Car car = new Car(2015);
       Car.Tire tire = new Car.Tire(15.0); // nested class init
       System.out.println(tire.getRadius());
   }
}
