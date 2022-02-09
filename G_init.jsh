String s[] = new String[2];
String t[] = new String[2];
Integer i[] = new Integer[2];
Integer j[] = new Integer[2];

G.<String>copy(s, t); // ok
G.<Integer>copy(i, j); // ok
G.<String>copy(i, j); // error
G.<String>copy(s, j); // error