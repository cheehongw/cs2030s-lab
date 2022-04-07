
INSTRUCTIONS
------------

1. This Practical Assessment consists of two questions.  Answer ALL questions.

2. The total mark for this assessment is 40.  Answer ALL questions.

3. This is an OPEN BOOK assessment.  You are only allowed to refer to written/printed notes.  No online resources/digital documents are allowed, except those accessible from the PE nodes (peXXX.comp.nus.edu.sg) (e.g., man pages are allowed).

4. You should see the following in your home directory.
   
   - The files Test1.java, Test2.java... TestXXX.java, and CS2030STest.java for testing your solution.
   - The skeleton files for Question 1: `cs2030s/fp/Try.java`
   - The skeleton files for Question 2: `YYY.java`
   - The following files to solve Question 2 are provided as part of the `cs2030s.fp` package: `Producer.java`, `Consumer.java`, `Transformer.java`, and `Runnable.java`.
     
5. Solve the programming tasks by creating any necessary files and editing them.

6. Only the files directly under your home directory and under cs2030s/fp will be graded.

7. Write your student number on top of EVERY FILE you created or edited as part of the @author tag.  Do not write your name.

# QUESTION 1: Try (20 marks)
-----------------------------

## Marking Criteria

- functionality and type correctness (12 marks)
- OO design (4 marks)
- style (2 marks)
- documentation (2 marks)

Code that cannot be compiled will receive 10 marks at most for this question.
Note that you need to write javadoc document for five of the methods identified below.  You don't have to write javadoc for other methods besides those identified below.

## Your Task

In Java, we handle exceptions with `try` and `catch`.  For example,
```
Circle c;
try {
  c = new Circle(point, radius);
} catch (IllegalArgumentException e) {
  System.err.println(e.getMessage());
}
```

When we code with the functional paradigm, however, we prefer to chain our operations and keep our functions pure.  A more functional way to write this block of code is to use the `Try` monad:
```
Try<Circle> c = Try.of(() -> new Circle(point, radius))
```

The `Try` monad is a way to encapsulate the result of the computation if it is successful, or the reason for failure if the computational failed.  We refer to these two possibilities as success and failure respectively.  In the example above, the `Try<Circle>` instance would contain the new circle if it is a success, an `IllegalArgumentException` if it fails.

The reason for failure can be encapsulated as an instance of the `Throwable` class.  This class is defined in the `java.lang` package and it is the parent class of `Exception` and `Error`.  A `Throwable` instance can be thrown and catch.  Note that `cs2030s.fp.Producer::produce` and `cs2030s.fp.Runnable::run` now throws a `Throwable`.

## Your Task

You will implement the `Try` monad in this question as part of the `cs2030s.fp` package.

We break down the tasks you need to do into several sections.  We suggest that you read through the whole question, plan your solution carefully before starting.

Please be reminded of the following:

- You should design your code so that it is extensible to other possible states of computation in the future, beyond just success and failure. 

- Your code should be type-safe and catch as many type mismatches as possible during compile time.

## Assumption

You can assume that everywhere a method accepts a functional interface or a `Throwable` as a parameter, the argument we pass in will not be `null`.  When a value is expected, however, there is a possibility that we pass in a `null` as an argument.

## The Basics

First, please implement the following factory methods:

- The `of` factory method, which allows us to create a new `Try` monad with a producer of type `Producer` (imported from the package `cs2030s.fp.Producer`).    Returns success if the producer produces a value successfully, or a failure containing the throwable if the producer throws an exception.

- The `success` factory method, which allows us to create a new `Try` monad with a value.  A `Try` monad created this way is always a success.

- The `failure` factory method, which allows us to create a new `Try` monad with a `Throwable`.  A `Try` monad created this way is always a failure.

- Implement the `equals` method so that it checks if two different `Try` instances are equal.  Two `Try` instances are equal if (i) they are both success and the value contained equals to each other, or (ii) they are both failures and have the same String representation of `Throwable`.

- Implement the method `get()` which will return the value if the `Try` is a success or throw the `Throwable` if it is a failure.

Study carefully how these methods can be used in the examples below:
```
jshell> import cs2030s.fp.Producer
jshell> import cs2030s.fp.Try

jshell> Try.success(1).get();
$.. ==> 1

jshell> try {
   ...>   Try.failure(new Error()).get();
   ...> } catch (Error e) { 
   ...>   System.out.println(e);
   ...> }
java.lang.Error

jshell> Try.<Number>of((Producer<Integer>) () -> 2).get();
$.. ==> 2

jshell> try {
   ...>   Try<Number> t = Try.of(() -> 4/0);
   ...> } catch (java.lang.ArithmeticException e) { 
   ...>   System.out.println(e);
   ...> }

jshell> Try.success(3).equals(Try.success(3))
$.. ==> true
jshell> Try.success(null).equals(Try.success(null))
$.. ==> true
jshell> Try.success(3).equals(Try.success(null))
$.. ==> false
jshell> Try.success(null).equals(Try.success(3))
$.. ==> false
jshell> Try.success(3).equals(Try.success("3"))
$.. ==> false
jshell> Try.success(3).equals(3)
$.. ==> false
jshell> Try.failure(new Error()).equals(new Error())
$.. ==> false
jshell> Try.failure(new Error()).equals(Try.success(3))
$.. ==> false
jshell> Try.failure(new Error()).equals(Try.success(new Error()))
$.. ==> false
jshell> Try.success(new Error()).equals(Try.failure(new Error()))
$.. ==> false
jshell> Try.failure(new ArithmeticException()).equals(Try.failure(new Error()))
$.. ==> false
jshell> Try.failure(new ArithmeticException()).equals(Try.failure(new ArithmeticException()))
$.. ==> true


```

You can also test your code with `Test1.java`:
```
$ javac cs2030s/fp/Try.java
$ javac Test1.java
$ java Test1
$ java -jar ~cs2030s/bin/checkstyle.jar -c ~cs2030s/bin/cs2030_checks.xml cs2030s/fp/Try.java
```

Write the javadoc documentation for `of`, and `success`, `failure` for `Try`.  Since we do not require you to write javadoc for every class and methods, `checkstyle` no longer warns about missing javadoc for your class and methods.  If you wrote some javadoc and did not format it properly, however, `checkstyle` will still warn you to help you write proper `javadoc` comments.

## map 

Now, implement the `map` method so that we can apply a computation on the content of `Try`.  If `map` is called on a `Try` instance that is a failure, the same instance of `Try` is returned.  Otherwise, if it is a success, the lambda expression is applied to the value contained within `Try`.  If this lambda expression throws a `Throwable`, the calling `Try` becomes a failure containing the `Throwable` thrown.

Study carefully how `map` can be used in the examples below:
```
jshell> import cs2030s.fp.Producer
jshell> import cs2030s.fp.Transformer
jshell> import cs2030s.fp.Try

jshell> Try.success(4).map(x -> x + 1).get();
$.. ==> 5

jshell> try {
   ...>   Try.failure(new NullPointerException()).map(x -> x.toString()).get();
   ...> } catch (NullPointerException e) {
   ...>   System.out.println(e);
   ...> }
java.lang.NullPointerException

jshell> Try.failure(new IOException()).map(x -> x.toString()).equals(Try.failure(new IOException()));
$.. ==> true

jshell> Try.success(4).map(x -> 8 / x).map(x -> x + 1).get();
$.. ==> 3

jshell> try {
   ...>   Try.success(0).map(x -> 8 / x).map(x -> x + 1).get();
   ...> } catch (ArithmeticException e) {
   ...>   System.out.println(e);
   ...> }
java.lang.ArithmeticException: / by zero

jshell> Transformer<Object, Integer> hash = x -> x.hashCode();
jshell> Try.success("hello").map(hash).get()
$.. ==> 99162322

jshell> try {
   ...>   Try.<Integer>success(null).map(hash).get();
   ...> } catch (NullPointerException e) {
   ...>   System.out.println(e);
   ...> }
java.lang.NullPointerException



```
You can also test your code with `Test2.java`:
```
$ javac cs2030s/fp/Try.java
$ javac Test2.java
$ java Test2
$ java -jar ~cs2030s/bin/checkstyle.jar -c ~cs2030s/bin/cs2030_checks.xml cs2030s/fp/Try.java
```

## flatMap 

Now, make `Try` a monad.  Implement the `flatMap` method so that we can compose multiple methods that produce a `Try` together.  If `flatMap` is called on a failure, return the failure.  Otherwise, if it is a success, apply the lambda expression on the value contained within `Try` and return the result.

Study carefully how `map` can be used in the examples below:
```
jshell> import cs2030s.fp.Producer
jshell> import cs2030s.fp.Transformer
jshell> import cs2030s.fp.Try

jshell> Try.success(4).flatMap(x -> Try.success(x + 1)).get();
$.. ==> 5

jshell> try {
   ...>   Try.success(4)
   ...>       .flatMap(x -> Try.failure(new IOException()))
   ...>       .get();
   ...> } catch (IOException e) {
   ...>   System.out.println(e);
   ...> }
java.io.IOException

jshell> try {
   ...>   Try.failure(new NullPointerException())
   ...>       .flatMap(x -> Try.success(x.toString()))
   ...>       .get();
   ...> } catch (NullPointerException e) {
   ...>   System.out.println(e);
   ...> }
java.lang.NullPointerException

jshell> Try.failure(new IOException()).flatMap(x -> Try.success(x.toString())).equals(Try.failure(new IOException()));
$.. ==> true

jshell> try {
   ...>   Try.failure(new NullPointerException())
   ...>       .flatMap(x -> Try.failure(new IOException()))
   ...>       .get();
   ...> } catch (NullPointerException e) {
   ...>   System.out.println(e);
   ...> }
java.lang.NullPointerException

jshell> Transformer<Object, Try<Integer>> hash = x -> Try.success(x.hashCode());
jshell> Try<Number> t = Try.success("hello").flatMap(hash);



```

You can also test your code with `Test3.java`:
```
$ javac cs2030s/fp/Try.java
$ javac Test3.java
$ java Test3
$ java -jar ~cs2030s/bin/checkstyle.jar -c ~cs2030s/bin/cs2030_checks.xml cs2030s/fp/Try.java
```

## Dealing with failures

The method `map` and `flatMap` applies the given lambdas to the value contained within the `Try` monad where it is a success.  Write the following method to deal with failure:

- `onFailure`: Return this instance if the calling `Try` instance is a success.  Consume the `Throwable` with a `Consumer` if it is a failure, and then either (i) return this instance if the consumer runs successfully, or (ii) return a failure instance containing the error/exception when consuming the `Throwable`.   

For example, we can use `onFailure` to replace this snippet 
```
Circle c;
try {
  c = new Circle(point, radius);
} catch (IllegalArgumentException e) {
  System.err.println(e.getMessage());
}
```

with:
```
Try<Circle> c = Try.of(() -> new Circle(point, radius))
                   .onFailure(System.err::println);
```


We can also recover from the failure, by turning the `Try` into a success.  Write the following method:

- `recover`: Return this instance if it is a success.  If this `Try` instance is a failure.  Apply the given `Transformer` to the `Throwable`, if the transformation is a success, return the resulting `Try`, otherwise, return a failure containing the error/exception when transforming the `Throwable`.

For example, we can use `recover` to replace this snippet 
```
Circle c;
try {
  c = new Circle(point, radius);
} catch (IllegalArgumentException e) {
  c = new Circle(point, 1);
}
```

with:
```
Try<Circle> c = Try.of(() -> new Circle(point, radius))
                   .recover(e -> new Circle(point, 1));
```

Study carefully how `onFailure` and `recover` can be used in the examples below:
```
jshell> import cs2030s.fp.Consumer
jshell> import cs2030s.fp.Producer
jshell> import cs2030s.fp.Transformer
jshell> import cs2030s.fp.Try

jshell> Try.success(4).onFailure(System.out::println).get()
$.. ==> 4

jshell> try {
   ...>   Try.failure(new IOException()).onFailure(System.out::println).get();
   ...> } catch (IOException e) {
   ...>   System.out.println(e);
   ...> }
java.io.IOException
java.io.IOException

jshell> try {
   ...>   Try.failure(new IOException()).onFailure(e -> { int x = 1 / 0; }).get();
   ...> } catch (ArithmeticException e) {
   ...>   System.out.println(e);
   ...> }
java.lang.ArithmeticException: / by zero

jshell> Consumer<Object> print = System.out::println
jshell> Try.<Number>success(4).onFailure(print).get()
$.. ==> 4

jshell> Try.success(4).recover(e -> 10).get()
$.. ==> 4
jshell> Try.failure(new IOException()).recover(e -> 10).get();
$.. ==> 10

jshell> try {
   ...>   Try.failure(new IOException()).recover(e -> e.hashCode() / 0).get();
   ...> } catch (ArithmeticException e) {
   ...>   System.out.println(e);
   ...> }
java.lang.ArithmeticException: / by zero

jshell> Transformer<Object, Integer> hash = x -> x.hashCode();
jshell> Try.<Number>success(4).recover(hash).get()
$.. ==> 4


```

You can also test your code with `Test4.java`:
```
$ javac cs2030s/fp/Try.java
$ javac Test4.java
$ java Test4
$ java -jar ~cs2030s/bin/checkstyle.jar -c ~cs2030s/bin/cs2030_checks.xml cs2030s/fp/Try.java
```

Write the javadoc documentation for `onFailure` and `recover` for `Try`.

                                   END OF PAPER
