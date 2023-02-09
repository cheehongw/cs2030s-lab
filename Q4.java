/**
 * Declare a generic class called A with type parameter T and a single private field x of type T.
 */

//CODE FOR class A HERE:
class A<T> {
  private T x;
}


class Q4 {
  public static void main(String[] args) {
    //Now instantiate an instance of A with type argument Integer here, 
    //and assign it to a variable called `a`

    A<Integer> a = new A<Integer>();
    System.out.println(a);
  }
}
