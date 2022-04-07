import cs2030s.fp.Consumer
import cs2030s.fp.Producer
import cs2030s.fp.Transformer
import cs2030s.fp.Try

Try.success(4).onFailure(System.out::println).get()

try {
  Try.failure(new IOException()).onFailure(System.out::println).get();
} catch (IOException e) {
  System.out.println(e);
}

try {
  Try.failure(new IOException()).onFailure(e -> { int x = 1 / 0; }).get();
} catch (ArithmeticException e) {
  System.out.println(e);
}

Consumer<Object> print = System.out::println
Try.<Number>success(4).onFailure(print).get()

Try.success(4).recover(e -> 10).get()
Try.failure(new IOException()).recover(e -> 10).get();

try {
  Try.failure(new IOException()).recover(e -> e.hashCode() / 0).get();
} catch (ArithmeticException e) {
  System.out.println(e);
}

Transformer<Object, Integer> hash = x -> x.hashCode();
Try.<Number>success(4).recover(hash).get()
