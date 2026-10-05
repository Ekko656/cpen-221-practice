import java.util.Set;
import java.util.HashSet;

public class Readings {
    private final int[] values;

    public Readings(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("array is null");
        }

        int realCount = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == -999) {
                continue;
            }
            if (values[i] < -50 || values[i] > 50) {
                throw new IllegalArgumentException("reading out of range");
            }
            realCount++;
        }

        if (realCount == 0) {
            throw new IllegalArgumentException("no real readings");
        }

        this.values = values;
    }

    public int[] validReadings() {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != -999) {
                count++;
            }
        }

        int valid[] = new int[count];
        int pos = 0;

        for (int i = 0; i < values.length; i++) {
            if (values[i] != -999) {
                valid[pos] = values[i];
                pos++;
            }
        }
        return valid;
    }

    public Set<Integer> distinctReadings() {
        Set<Integer> distinct = new HashSet<>();
        int valid[] = validReadings();

        for (int i = 0; i < valid.length; i++) {
            distinct.add(valid[i]);
        }
        return distinct;
    }
}
