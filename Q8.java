/**
 * Write a generic class D<T> that contains a field that is an array of 
 * type T with 10 elements. Instantiate that array in the constructor.
 */

class D<T> {
  
  private T[] arr;

  public D() {
    @SuppressWarnings("unchecked")
    T[] arr = (T[]) new Object[10];
    this.arr = arr;
  }

}
