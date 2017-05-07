package fundamentals.patterns.behavioral;

class MyResource implements AutoCloseable {
    private int level;
    private boolean exceptionOnClose;

    MyResource(int level, boolean exceptionOnClose) {
        this.level = level;
        this.exceptionOnClose = exceptionOnClose;
        System.out.println("Creating MyResource. Level = " + level);
    }

    void use() {
        if (level <= 0) {
            throw new RuntimeException("Low in level.");
        }
        System.out.println("Using MyResource level " + this.level);
        level--;
    }

    @Override
    public void close() {
        if (exceptionOnClose) {
            throw new RuntimeException("Error in closing");
        }
        System.out.println("Closing MyResource...");
    }
}

/**
 * Ensures that a resource is deterministically disposed of once it goes out of scope.
 */
public class Loan {
    public static void main(String[] args) {
    // Create and use a resource of MyResource type.
    // Its close() method will be called automatically */
        try (MyResource mr = new MyResource(2, false)) {
            mr.use();
            mr.use();
        }
    }
}
