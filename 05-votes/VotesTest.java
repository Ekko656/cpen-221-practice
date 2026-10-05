import java.util.HashSet;
import java.util.List;

public class VotesTest {
    static int passed = 0, total = 0;

    static void check(String name, boolean ok) {
        total++;
        if (ok) passed++;
        System.out.println((ok ? "PASS  " : "FAIL  ") + name);
    }

    static boolean throwsIAE(String s) {
        try { new Votes(s); return false; }
        catch (IllegalArgumentException e) { return true; }
    }

    public static void main(String[] args) {
        check("rejects null", throwsIAE(null));
        check("rejects \"\"", throwsIAE(""));
        check("rejects \"xyz-\"", throwsIAE("xyz-"));
        check("rejects \"cab\"", throwsIAE("cab"));
        check("accepts \"A\"", !throwsIAE("A"));
        check("accepts \"AABxC-A\"", !throwsIAE("AABxC-A"));

        Votes v = new Votes("AABxC-A");
        check("countFor('A') == 3", v.countFor('A') == 3);
        check("countFor('B') == 1", v.countFor('B') == 1);
        check("countFor('Z') == 0", v.countFor('Z') == 0);
        check("countFor('x') == 0", v.countFor('x') == 0);
        check("countFor('A') on \"BB\" == 0", new Votes("BB").countFor('A') == 0);
        check("candidates() of \"AABxC-A\" == {A, B, C}", v.candidates().equals(new HashSet<>(List.of('A', 'B', 'C'))));
        check("candidates() of \"BB\" == {B}", new Votes("BB").candidates().equals(new HashSet<>(List.of('B'))));

        System.out.println(passed + "/" + total + " passed");
    }
}
