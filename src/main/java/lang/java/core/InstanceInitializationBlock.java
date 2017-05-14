package lang.java.core;

public class InstanceInitializationBlock {
    int i;
    {
        i = 1;
        System.out.println(i);
    }

    /*
      Static initializer is executed only once for a class when the class
      definition is loaded into JVM
     */
    static {
        System.out.println("init");
    }

    public static void main(String[] args) {
        new InstanceInitializationBlock();
    }
}
