/**
 * What is wrong with the following?
 */
class F extends A<T> {

}

// ANSWER:
// F must extend an instantiated type of A
// In this case, A<T> is not an instantiated type since the 
// type parameter T is not provided by F

