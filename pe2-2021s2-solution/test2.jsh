import cs2030s.fp.Producer
import cs2030s.fp.Transformer
import cs2030s.fp.Try

Try.success(4).map(x -> x + 1).get();

try {
  Try.failure(new NullPointerException()).map(x -> x.toString()).get();
} catch (NullPointerException e) {
  System.out.println(e);
}

Try.failure(new IOException()).map(x -> x.toString()).equals(Try.failure(new IOException()));

Try.success(4).map(x -> 8 / x).map(x -> x + 1).get();

try {
  Try.success(0).map(x -> 8 / x).map(x -> x + 1).get();
} catch (ArithmeticException e) {
  System.out.println(e);
}

Transformer<Object, Integer> hash = x -> x.hashCode();
Try.success("hello").map(hash).get()

try {
  Try.<Integer>success(null).map(hash).get();
} catch (NullPointerException e) {
  System.out.println(e);
}

