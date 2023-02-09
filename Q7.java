/**
 * Write a generic method that copy from one array to another. 
 * Here is the skeleton:
 * 
 */
class Q7 { 
  public static <T> void copy(T[] from, T[] to) {
    for (int i = 0; i < from.length; i++) {
      to[i] = from[i];
    }
  }

  /**
   * Heres how it should work:
   * String s[] = new String[2];
   * String t[] = new String[2];
   * Integer i[] = new Integer[2];
   * Integer j[] = new Integer[2];
   * Q7.<String>copy(s, t); // ok
   * Q7.<Integer>copy(i, j); // ok
   * Q7.<String>copy(i, j); // error
   * Q7.<String>copy(s, j); // error
   */
  public static void main(String[] args) {
    String s[] = new String[2];
    String t[] = new String[2];
    Integer i[] = new Integer[2];
    Integer j[] = new Integer[2];

    Q7.<String>copy(s, t); // ok
    Q7.<Integer>copy(i, j); // ok
    Q7.<String>copy(i, j); // error
    Q7.<String>copy(s, j); // error
  }
}




