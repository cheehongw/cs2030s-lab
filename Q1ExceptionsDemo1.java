import java.io.File;
import java.util.Scanner;
/**
 * Q: Does this compile?
 */
class Q1ExceptionsDemo1 {
  public static void main(String[] args) {
	File f = new File("hello.txt");
	Scanner s = new Scanner(f);
  }
}
