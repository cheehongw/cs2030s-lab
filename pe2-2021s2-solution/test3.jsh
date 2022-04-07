import cs2030s.fp.Producer
import cs2030s.fp.Transformer
import cs2030s.fp.Try

Try.success(4).flatMap(x -> Try.success(x + 1)).get();

try {
  Try.success(4)
      .flatMap(x -> Try.failure(new IOException()))
      .get();
} catch (IOException e) {
  System.out.println(e);
}

try {
  Try.failure(new NullPointerException())
      .flatMap(x -> Try.success(x.toString()))
      .get();
} catch (NullPointerException e) {
  System.out.println(e);
}

Try.failure(new IOException()).flatMap(x -> Try.success(x.toString())).equals(Try.failure(new IOException()));

try {
  Try.failure(new NullPointerException())
      .flatMap(x -> Try.failure(new IOException()))
      .get();
} catch (NullPointerException e) {
  System.out.println(e);
}

Transformer<Object, Try<Integer>> hash = x -> Try.success(x.hashCode());
Try<Number> t = Try.success("hello").flatMap(hash);

