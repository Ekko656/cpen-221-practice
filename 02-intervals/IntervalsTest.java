import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IntervalsTest {
    static int passed = 0, total = 0;

    static void check(String name, boolean ok) {
        total++;
        if (ok) passed++;
        System.out.println((ok ? "PASS  " : "FAIL  ") + name);
    }

    static boolean throwsIAE(int[] lo, int[] hi) {
        try { new Intervals(lo, hi); return false; }
        catch (IllegalArgumentException e) { return true; }
    }

    public static void main(String[] args) {
        check("rejects null lower", throwsIAE(null, new int[]{1}));
        check("rejects null upper", throwsIAE(new int[]{1}, null));
        check("rejects empty arrays", throwsIAE(new int[]{}, new int[]{}));
        check("rejects different lengths", throwsIAE(new int[]{1, 2}, new int[]{3}));
        check("rejects lower > upper", throwsIAE(new int[]{5}, new int[]{2}));
        check("accepts lower == upper", !throwsIAE(new int[]{4}, new int[]{4}));

        Intervals iv = new Intervals(new int[]{2, 7, 4}, new int[]{5, 7, 4});
        check("range(0) == [2, 3, 4, 5]", Arrays.equals(iv.range(0), new int[]{2, 3, 4, 5}));
        check("range(1) == [7]", Arrays.equals(iv.range(1), new int[]{7}));
        check("range(2) == [4]", Arrays.equals(iv.range(2), new int[]{4}));
        check("singleIndices() == {1, 2}", iv.singleIndices().equals(new HashSet<>(List.of(1, 2))));

        System.out.println(passed + "/" + total + " passed");
    }
}
