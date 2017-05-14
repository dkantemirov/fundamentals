package lang.java.utils;

public class Wrapper<T> {
  private T ref;

  public Wrapper(T ref) {
    this.ref = ref;
  }

  public T get() {
    return ref;
  }

  public void set(T a) {
    this.ref = ref;
  }
}
