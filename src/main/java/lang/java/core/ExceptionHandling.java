package lang.java.core;

class ExceptionHandling {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Throwable e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("fin");
        }
    }
}

class MultiCatchBlock {
    private class Exception1 extends Exception {

    }
    private class Exception2 extends Exception {

    }
    private class Exception3 extends Exception {

    }

//    void show() {
//        try {
//            throw new Exception1();
//        }
//        catch (Exception1 | Exception2 | Exception3 e){
//            System.out.println(e);
//        }
//    }
}

