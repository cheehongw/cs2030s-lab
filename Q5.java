/**
 * Declare a generic class B<T> that extends from A<T>, 
 * and a generic class C<T> that contains a field of type A<T>
 */

//class B<T> here:

class B<T> extends A<T> {

}


//class C here:

class C<T> {
  
  private A<T> x; 

}







// Are the occurrences of T referring to the same T?
