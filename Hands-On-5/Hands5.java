public class Hands5 {
    public static <T extends Comparable<T>> boolean isEqual(T a, T b) {
        return a.compareTo(b) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isEqual(5, 5));            // true
        System.out.println(isEqual("Hello", "World")); // false
        System.out.println(isEqual(3.14, 3.14));      // true

        // test case tambahan: Double
        System.out.println(isEqual(2.5, 2.5));        // true
        System.out.println(isEqual(1.1, 2.2));        // false

        // test case tambahan: Character
        System.out.println(isEqual('a', 'a'));        // true
        System.out.println(isEqual('a', 'b'));        // false
    }
}
