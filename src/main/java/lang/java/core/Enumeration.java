package lang.java.core;

public class Enumeration {
    public enum Severity {
        LOW, MEDIUM, HIGH, URGENT;
    }

    static Severity defaultSeverity = Severity.MEDIUM;

    public static void main(String[] args) {
        int i;
        switch (defaultSeverity) {
            case LOW:
                i = 30;
                break;
            case MEDIUM:
                i = 15;
                break;
            case HIGH:
                i = 7;
                break;
            case URGENT:
                i = 1;
                break;
            default:
                i = 0;
        }
        System.out.println(i); // 30

        // Comparing Two Enum Constants
        System.out.println(defaultSeverity == Severity.MEDIUM); // true
        System.out.println(defaultSeverity.equals(Severity.MEDIUM)); // true
        System.out.println(defaultSeverity.compareTo(Severity.MEDIUM)); // 0
    }

    /**
     * Associating Data and Methods to Enum Constants.
     */
    enum SmartSeverity {
        LOW(30), MEDIUM(15), HIGH(7), URGENT(1);

        // Declare an instance variable
        private int projectedTurnaroundDays;

        // Declare a private constructor
        private SmartSeverity(int projectedTurnaroundDays) {
            this.projectedTurnaroundDays = projectedTurnaroundDays;
        }

        // Declare a public method to get the turnaround days
        public int getProjectedTurnaroundDays() {
            return projectedTurnaroundDays;
        }
    }

    /**
     * Associating a Body to an Enum Constant.
     */
    public enum SuperSmartSeverity {
        LOW("Low Priority", 30) {
            public double getProjectedCost() {
                return 1000.0;
            }
        },

        MEDIUM("Medium Priority",15) {
            public double getProjectedCost () {
                return 2000.0;
            }
        },

        HIGH("High Priority",7){
            public double getProjectedCost() {
                return 3000.0;
            }
        },

        URGENT("Urgent Priority",1){
            public double getProjectedCost() {
                return 5000.0;
            }
        };

        //Declare instance variables
        private String description;
        private int projectedTurnaroundDays;

        // Declare a private constructor
        private SuperSmartSeverity(String description, int projectedTurnaroundDays) {
            this.description=description;
            this.projectedTurnaroundDays=projectedTurnaroundDays;
        }

        // Declare a public method to get the turn around days
        public int getProjectedTurnaroundDays() {
            return projectedTurnaroundDays;
        }

        // Override the toString() method in the Enum class to return description
        @Override
        public String toString() {
            return this.description;
        }

        // Provide getProjectedCost() abstract method, so all constants
        // override and provide implementation for it in their body
        public abstract double getProjectedCost();
    }
}


