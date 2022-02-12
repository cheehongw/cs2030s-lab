/**
 * Write a generic method that copy from one array to another. 
 * Here is the skeleton:
 */
class G { 
  public static ??? void copy(???  from, ??? to) {
    for (int i = 0; i < from.length; i++) {
      to[i] = from[i];
    }
  }
}

/** ANSWER */
class G { 
  public static <T> void copy(T[] from, T[] to) {
    for (int i = 0; i < from.length; i++) {
      to[i] = from[i];
    }
  }
 }

/*
Heres how it should work:
    String s[] = new String[2];
    String t[] = new String[2];
    Integer i[] = new Integer[2];
    Integer j[] = new Integer[2];

    G.<String>copy(s, t); // ok
    G.<Integer>copy(i, j); // ok
    G.<String>copy(i, j); // error
    G.<String>copy(s, j); // error

    Once you are done with G.java, open jshell and type:
    
    /open G.java
    /open G_init.jsh

    You should see 2 errors.
*/
