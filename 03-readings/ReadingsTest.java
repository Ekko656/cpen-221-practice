import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ReadingsTest {
    static int passed = 0, total = 0;

    static void check(String name, boolean ok) {
        total++;
        if (ok) passed++;
        System.out.println((ok ? "PASS  " : "FAIL  ") + name);
    }

    static boolean throwsIAE(int[] v) {
        try { new Readings(v); return false; }
        catch (IllegalArgumentException e) { return true; }
    }

    public static void main(String[] args) {
        check("rejects null", throwsIAE(null));
        check("rejects {}", throwsIAE(new int[]{}));
        check("rejects {-999, -999}", throwsIAE(new int[]{-999, -999}));
        check("rejects {20, 80}", throwsIAE(new int[]{20, 80}));
        check("rejects {20, -51}", throwsIAE(new int[]{20, -51}));
        check("accepts {50}", !throwsIAE(new int[]{50}));
        check("accepts {-50, -999}", !throwsIAE(new int[]{-50, -999}));

        Readings r = new Readings(new int[]{20, -999, 25, 20});
        check("validReadings() == [20, 25, 20]", Arrays.equals(r.validReadings(), new int[]{20, 25, 20}));
        check("distinctReadings() == {20, 25}", r.distinctReadings().equals(new HashSet<>(List.of(20, 25))));

        System.out.println(passed + "/" + total + " passed");
    }
}
