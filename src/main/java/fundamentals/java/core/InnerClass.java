package fundamentals.java.core;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Concise Scala analog {@link fundamentals.scala.core.InnerClass}
 */
public class InnerClass {
    /**
     * Member Inner Class
     */
    public class Car {
        private int year;

        // Inner class
        public class Tire {
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

    /**
     * Local Inner Class
     */
    public class TitleList {
        private ArrayList<String> titleList = new ArrayList<>();

        public void addTitle(String title) {
            titleList.add(title);
        }

        public void removeTitle(String title) {
            titleList.remove(title);
        }

        public Iterator<String> titleIterator() {
            // A local inner class - TitleIterator
            class TitleIterator implements Iterator<String> {
                int count = 0;

                @Override
                public boolean hasNext() {
                    return (count < titleList.size());
                }

                @Override
                public String next() {
                    return titleList.get(count++);
                }
            }

            // Create an object of the local inner class and return the reference
            TitleIterator titleIterator = new TitleIterator();
            return titleIterator;
        }
    }

    /**
     * Anonymous Inner Class
     */
    public class TitleListWithAnonymousInnerClass {
        private ArrayList<String> titleList = new ArrayList<>();

        public void addTitle(String title) {
            titleList.add(title);
        }

        public void removeTitle(String title) {
            titleList.remove(title);
        }

        public Iterator<String> titleIterator() {
            // An anonymous inner class
            Iterator<String> iterator =
                    new Iterator<String>() {
                        int count = 0;

                        @Override
                        public boolean hasNext() {
                            return (count < titleList.size());
                        }

                        @Override
                        public String next() {
                            return titleList.get(count++);
                        }
                    }; // Anonymous inner class ends here

            return iterator;
        }
    }

    /**
     * Creating Objects of Inner Classes
     */
    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        Car car = innerClass.new Car(2015);
        Car.Tire tire = car.new Tire(15.0);
        System.out.println(tire.getRadius());
    }
}

