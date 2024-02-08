package _03__Java_8.Java_Stream_API;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        createStreamMethod();
        limitMethod();
        skipMethod();
        sortedMethod();
        distinctMethod();
        // peekMethod();
        mapMethod();
        flatMapMethod();
        filterMethod();
        reduceMethod();
        // collectMethod();
        // Method();
    }

    public static void limitMethod() {
        Stream.iterate(1, n -> n + 1).limit(20).forEach(System.out::println);
        Stream.generate(new Random()::nextInt).limit(20).forEach(System.out::println);
    }

    public static void skipMethod() {
        Stream.iterate(1, n -> n + 1).skip(10).limit(20).forEach(System.out::println);
        Stream.generate(new Random()::nextInt).skip(10).limit(20).forEach(System.out::println);
    }

    public static void sortedMethod() {
        Stream.iterate(10, n -> n - 1).limit(20).sorted().forEach(System.out::println);
        Stream.generate(new Random()::nextInt).limit(20).sorted().forEach(System.out::println);
    }

    public static void distinctMethod() {
        Arrays.stream(new int[]{1, 3, 2, 3, 2, 1}).distinct().sorted().forEach(System.out::println);
    }

    public static void mapMethod() {

        Supplier<List<User>> supplyUserList = () -> {
            List<User> userList = new ArrayList<User>();
            for (int i = 1; i <= 5; i++) {
                User user = new User("user-" + i, i);
                userList.add(user);
            }
            return userList;
        };

        System.out.println("NOTE: map(Function<T,R> mapper)");

        System.out.println("\n[ Supplier<List<User>> Returns List<User> ]");
        List<User> userList = supplyUserList.get();
        supplyUserList.get().forEach(System.out::println);

        System.out.println("\n[ Supplier<List<User>> Returns List<User> To List<String> ]");
        supplyUserList.get().stream().map((user) -> {
            return user.getName().toUpperCase() + ":" + user.getId();
        }).toList().forEach(System.out::println);

    }

    public static void flatMapMethod() {

        String[] stringArray = {"first", "middle", "last"};

        // problem
        Arrays.stream(stringArray).map((word) -> word.split("")).forEach(System.out::println);
        Arrays.stream(stringArray).map((word) -> word.split("")).map(Arrays::stream).forEach(System.out::println);
        // solution
        Arrays.stream(stringArray).map((word) -> word.split("")).flatMap(Arrays::stream).forEach(System.out::println);

        List<List<String>> stringList = Arrays.asList(Arrays.asList("first"), Arrays.asList("middle"), Arrays.asList("last"));

        // problem
        stringList.stream().map(Collection::stream).forEach(System.out::println);
        // solution
        stringList.stream().flatMap(Collection::stream).forEach(System.out::println);

        // problem
        stringList.stream().flatMap(Collection::stream).map(e -> e.split("")).forEach(System.out::println);
        stringList.stream().flatMap(Collection::stream).map(e -> e.split("")).map(Arrays::stream).forEach(System.out::println);
        // solution
        stringList.stream().flatMap(Collection::stream).map(e -> e.split("")).flatMap(Arrays::stream).forEach(System.out::println);

    }

    public static void filterMethod() {

        Supplier<List<Integer>> supplyList = () -> {
            List<Integer> intList = new ArrayList<Integer>();
            for (int i = 0; i < 10; i++) {
                intList.add(i);
            }
            return intList;
        };

        Supplier<List<User>> supplyUserList = () -> {
            List<User> userList = new ArrayList<User>();
            for (int i = 0; i < 10; i++) {
                User user = new User("user-" + i, i);
                userList.add(user);
            }
            return userList;
        };

        System.out.println("> EVEN: " + supplyList.get().stream().filter(x -> x % 2 == 0 ? true : false).toList());
        supplyUserList.get().stream().filter(u -> u.getId() % 2 == 0 ? true : false).forEach(System.out::println);

        System.out.println("> ODD : " + supplyList.get().stream().filter(x -> x % 2 == 1 ? true : false).toList());
        supplyUserList.get().stream().filter(u -> u.getId() % 2 == 1 ? true : false).forEach(System.out::println);

    }

    public static void reduceMethod() {

        // return new Random().nextInt(10); // 0 to 9
        // return new Random().nextInt(10) + 1; // 1 to 10

        System.out.println(Stream.generate(() -> new Random().nextInt(10) + 1).limit(10).filter(x -> x % 2 == 0).reduce(0, (x, y) -> x + y));

        // simplified code
        System.out.println(Stream.generate(() -> {
            Random random = new Random();
            int r = random.nextInt(10) + 1;
            return r;
        }).limit(10).filter((x) -> {
            if (x % 2 == 0) {
                return true;
            } else {
                return false;
            }
        }).reduce(0, (x, y) -> x + y));

    }

    public static void createStreamMethod() {

        Character[] cArr = {'a', 'b', 'c', 'd'};
        List<Character> cList = Arrays.asList('A', 'B', 'C', 'D');

        Consumer<Stream<?>> println = (stream) -> stream.forEach(System.out::println);

        // Arrays.stream(T[] array); // creates a stream from an array
        Stream<Character> stream1 = Arrays.stream(cArr);
        println.accept(stream1);

        // Arrays.stream(T[] array, int startInclusive, int endExclusive); // creates a stream from a part of an array
        Stream<Character> stream2 = Arrays.stream(cArr, 1, 3); // [1,2]
        println.accept(stream2);

        // Collection.stream(); // returns a sequential stream
        Stream<Character> stream3 = cList.stream();
        println.accept(stream3);

        // Collection.parallelStream(); // returns a non-sequential stream
        Stream<Character> stream4 = cList.parallelStream();
        println.accept(stream4);

        // Stream.empty();
        Stream<Character> stream5 = Stream.empty(); // returns an empty stream
        println.accept(stream5);

        // Stream.of(T... values); // returns a sequential ordered stream whose elements are the specified values
        Stream<Character> stream6 = Stream.of('a', 'b', 'c', 'd');
        println.accept(stream6);

        // Stream.of(T t); // returns a singleton sequential stream
        Stream<Character> stream7 = Stream.of('a');
        println.accept(stream7);

        // Stream.ofNullable(T t); // returns an empty stream if null, otherwise a singleton sequential stream
        Stream<Character> stream8 = Stream.ofNullable('a');
        println.accept(stream8);

        // Stream.iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next);
        Stream<Character> stream9 = Stream.iterate(null, null, null);
        println.accept(stream9);

        // Stream.iterate(T seed, UnaryOperator<T> f);
        // infinite sequential ordered Stream, elements generated by UnaryOperator
        Stream<Character> stream10 = Stream.iterate(1, n -> n + 1).limit(50);
        println.accept(stream10);

        // Stream.generate(Supplier<? extends T> s);
        // infinite sequential unordered stream, elements generated by Supplier
        Supplier<List<Character>> supplierList = () -> Arrays.asList('a', 'b', 'c', 'd');
        Stream<List<Character>> stream11 = Stream.generate(supplierList);
        println.accept(stream11); // infinite printing supplierList on the console, i.e. single list of characters
        Stream<List<Character>> stream12 = Stream.generate(new Random()::nextInt).limit(50);
        println.accept(stream12);

        // Stream.concat(Stream<? extends T> a, Stream<? extends T> b); // it concats 2 streams into 1
        Stream<Character> stream13 = Stream.concat(stream3, stream4);
        println.accept(stream13);

    }

}

/*

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Stream Class
-----------------------------------------------------------------------------------------------------------------------------------------------------------
- NOTE: java.io.stream (processing binary data to/from files) != java.util.stream (processing objects inside collection)
- Collections like List, Set will be used if we want to represent a group of similar objects as a single entity,
  whereas Stream will be used to process a group of objects present inside a Collection.
- The java.util.stream API has classes for processing sequences of objects that are stored inside the Collections.
- The central API class is the Stream<T>.
- We can create a Stream from Collection, Arrays, Iterator, or by passing the elements directly to Stream.
- A Stream doesn’t store its elements. They may be stored in an underlying Collection or generated on demand.
- The Stream operations do not mutate their source. Instead, they return new Stream that hold the result.
- In Stream, the code is written in a declarative way
  (we specify what we want to achieve like in query style as opposed to specifying how to implement an operation).
-----------------------------------------------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Create A Stream<T> Object Using Collection
-----------------------------------------------------------------------------------------------------------------------------------------------------------
1) Collection.stream();
   - returns a sequential stream

2) Collection.parallelStream();
   - returns a non-sequential stream
-----------------------------------------------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Create A Stream<T> Object Using Arrays
-----------------------------------------------------------------------------------------------------------------------------------------------------------
1) Arrays.stream(T[] array);
   - creates a stream from an array

2) Arrays.stream(T[] array, int startInclusive, int endExclusive);
   - creates a stream from a part of an array
-----------------------------------------------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------------------------------------------
> Create A Stream<T> Object Using Stream
-----------------------------------------------------------------------------------------------------------------------------------------------------------
1) Stream.empty();
   - empty stream

2) Stream.of(T... values);
   - returns a sequential ordered stream whose elements are the specified values

3) Stream.of(T t);
   - returns a singleton sequential stream

4) Stream.ofNullable(T t);
   - returns an empty stream if null, otherwise a singleton sequential stream

5) Stream.iterate(T seed, UnaryOperator<T> f);
   - infinite sequential ordered Stream, elements generated by UnaryOperator

6) Stream.iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next);

7) Stream.generate(Supplier<? extends T> s);
   - infinite sequential unordered Stream, elements generated by Supplier

8) Stream.concat(Stream<? extends T> a, Stream<? extends T> b);
   - it concat 2 streams into 1
-----------------------------------------------------------------------------------------------------------------------------------------------------------

 */