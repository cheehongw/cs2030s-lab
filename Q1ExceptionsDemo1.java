import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Q: Does this compile?
 */
class Q1ExceptionsDemo1 {
  public static void main(String[] args) {
	File f = new File("hello.txt");
  
  try {
	  Scanner s = new Scanner(f);
  } catch (FileNotFoundException err) {

    System.out.println(err);
  }

  }
}
