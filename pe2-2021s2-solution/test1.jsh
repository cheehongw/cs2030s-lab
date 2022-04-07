import cs2030s.fp.Producer
import cs2030s.fp.Try

Try.success(1).get();

try {
  Try.failure(new Error()).get();
} catch (Error e) { 
  System.out.println(e);
}

Try.<Number>of((Producer<Integer>) () -> 2).get();

try {
  Try<Number> t = Try.of(() -> 4/0);
} catch (java.lang.ArithmeticException e) { 
  System.out.println(e);
}

Try.success(3).equals(Try.success(3))
Try.success(null).equals(Try.success(null))
Try.success(3).equals(Try.success(null))
Try.success(null).equals(Try.success(3))
Try.success(3).equals(Try.success("3"))
Try.success(3).equals(3)
Try.failure(new Error()).equals(new Error())
Try.failure(new Error()).equals(Try.success(3))
Try.failure(new Error()).equals(Try.success(new Error()))
Try.success(new Error()).equals(Try.failure(new Error()))
Try.failure(new ArithmeticException()).equals(Try.failure(new Error()))
Try.failure(new ArithmeticException()).equals(Try.failure(new ArithmeticException()))
