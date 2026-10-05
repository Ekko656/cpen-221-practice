import java.util.Set;
import java.util.HashSet;

public class Intervals {
    private final int[] lower;
    private final int[] upper;

    public Intervals(int[] lower, int[] upper) {
        if (lower == null || upper == null) {
            throw new IllegalArgumentException("null array");
        }
        if (lower.length == 0 || upper.length == 0) {
            throw new IllegalArgumentException("empty array");
        }
        if (lower.length != upper.length) {
            throw new IllegalArgumentException("different lengths");
        }
        for (int i = 0; i < lower.length; i++) {
            if (lower[i] > upper[i]) {
                throw new IllegalArgumentException("range runs backward");
            }
        }
        this.lower = lower;
        this.upper = upper;
    }

    public int[] range(int i) {
        int[] ordered = new int[upper[i] - lower[i] + 1];
        int array_pos = 0;

        for (int x = lower[i]; x <= upper[i]; x++) {
            ordered[array_pos] = x;
            array_pos++;
        }
        return ordered;
    }

    public Set<Integer> singleIndices() {
        Set<Integer> equal = new HashSet<>();
        for (int i = 0; i < lower.length; i++) {
            if (lower[i] == upper[i]) {
                equal.add(i);
            }
        }
        return equal;
    }
}
