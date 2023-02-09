/**
 * Task 3: 
 * 
 * Create a new checked exception `MyOwnException` and throw it
 * from `ExceptionDemo::foo` and catch it in main
 */
class ExceptionDemo {
    public static void foo() throws MyOwnException {
      // throw MyOwnException
      throw new MyOwnException();
    }


    public static void main(String[] args) {
      try {
        foo();
      } catch (MyOwnException e) {
        System.out.println(e);
      }
    }
}

//CREATE `MyOwnException` her
class MyOwnException extends Exception {

}
