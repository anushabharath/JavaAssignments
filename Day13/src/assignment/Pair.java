package assignment;

public class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public Pair<U, T> reverse() {
        return new Pair<>(second, first);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Hello", 123);
        System.out.println("Original Pair: " + pair);

        Pair<Integer, String> reversedPair = pair.reverse();
        System.out.println("Reversed Pair: " + reversedPair);
    }
}
