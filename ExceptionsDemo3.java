/**
 * Task 3: 
 * 
 * Create a new checked exception `MyOwnException` and throw it
 * from `Exception::foo` and catch it in main
 */
/*

class ExceptionDemo {
    public static void foo() {
      // throw MyOwnException
    }
    public static void main(String[] args) {
      foo();
    }
}

//CREATE `MyOwnException` here
class MyOwnException

*/
//-----------------------------------------------------------------

//ANSWER
class MyOwnException extends Exception {

}

class ExceptionDemo {
  public static void foo() throws MyOwnException {
    throw new MyOwnException();
  }
  public static void main(String[] args) {
    try {
      foo();
    } catch (MyOwnException e) {
      // do something
    }
  }
}