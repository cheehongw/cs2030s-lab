/**
 * Write a generic class D<T> that contains a field that is an array of
 * type T with 10 elements. Instantiate that array in the constructor.
 */
// Answer
class D<T> {
    T[] a;

    D() {
        @SuppressWarnings("unchecked")
        T[] tmp = (T[]) new Object[10];
        this.a = tmp;
    }
}