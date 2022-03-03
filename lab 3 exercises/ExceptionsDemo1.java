// import java.io.File;
// import java.util.Scanner;

// class ExceptionsDemo1 {
//   public static void main(String[] args) {
// 	File f = new File("hello.txt");
// 	Scanner s = new Scanner(f);
//   }
// }

//ANSWER
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class ExceptionDemo {
  public static void main(String[] args) {
    File f = new File("hello.txt");
    try {
      Scanner s = new Scanner(f);
    } catch (FileNotFoundException e) {
      // do something
    }
  }
}