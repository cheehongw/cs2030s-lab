/**
 * Task 2:
 * 
 * Fix this code so that it compiles. 
 * There are 2 ways to do this, try both ways.
 */

import java.io.File;
import java.util.Scanner;

class ExceptionsDemo2 {
  public static Scanner openFile(String filename) {
    File f = new File(filename);
    return new Scanner(f);
  }
  public static void main(String[] args) {
    Scanner sc = openFile("hello.txt");
  }
}