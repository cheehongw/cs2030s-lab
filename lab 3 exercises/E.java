/**
 * Write a generic class E<T extends Comparable<T>> that contains
 * a field that is an array of type T with 10 elements.
 * 
 * Instantiate that array in the constructor.
 */

// Answer
class E<T extends Comparable<T>> {
    T[] a;

    E() {
        @SuppressWarnings({ "unchecked", "rawtypes" })
        T[] tmp = (T[]) new Comparable[10];
        this.a = tmp;
    }
}