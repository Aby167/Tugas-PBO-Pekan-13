public class Hands4 {
    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(10, "Budi");
        Pair<Double, Boolean> p2 = new Pair<>(3.14, true);

        p1.showTypes();
        p2.showTypes();

        Pair<String, Integer> p1Swap = p1.swap();
        System.out.println("Sebelum swap: " + p1);
        System.out.println("Sesudah swap: " + p1Swap);
        p1Swap.showTypes();

        Pair<Boolean, Double> p2Swap = p2.swap();
        System.out.println("Sebelum swap: " + p2);
        System.out.println("Sesudah swap: " + p2Swap);
    }
}

class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public void showTypes() {
        System.out.println(first.getClass().getName() + " & " + second.getClass().getName());
    }

    public Pair<T2, T1> swap() {
        return new Pair<>(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
