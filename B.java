/**
 * Declare a generic class B<T> that extends from A<T>,
 * and a generic class C<T> that contains a field of type A<T>
 */

// class B<T> here:
//ANSWER
class B<T> extends A<T> {
}

// class C here:
//ANSWER
class C<T> {
    private A<T> a;
}
