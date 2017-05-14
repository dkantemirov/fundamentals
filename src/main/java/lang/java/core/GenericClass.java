package lang.java.core;

import lang.java.utils.Wrapper;

public class GenericClass<T> {
    private void foo(T a) {
    }

    private <V> void foo(Wrapper<V> a, Wrapper<V> b, T c) {
    }

    public static void main(String[] args) {
        GenericClass<Integer> g = new GenericClass<>();
        g.foo(new Wrapper<String>("str1"), new Wrapper<String>("str2"), 100);
    }
}
