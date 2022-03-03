public class GenericsMain {
  public static void main(String[] args) {
    // instantiate an instance of A<T>, with type argument `Integer`
    A<Integer> a1 = new A<Integer>();
    // instantiate an instance of A, without any type argument
    A a2 = new A();   //note: rawtypes are NOT to be used
  }
}
