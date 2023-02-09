/**
 * Write a generic class E<T extends Comparable<T>> that contains 
 * a field that is an array of type T with 10 elements. 
 * 
 * Instantiate that array in the constructor. 
 */

class E<T extends Comparable<T>> {
  private T[] arr;

  public E() { //constructor
  
    @SuppressWarnings({"unchecked", "rawtypes"})
    T[] arr = (T[]) new Comparable[10];
    this.arr = arr;
  }
}

