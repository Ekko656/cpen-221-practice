import java.util.HashSet;
import java.util.List;

public class DigitsTest {
    static int passed = 0, total = 0;

    static void check(String name, boolean ok) {
        total++;
        if (ok) passed++;
        System.out.println((ok ? "PASS  " : "FAIL  ") + name);
    }

    static boolean throwsIAE(String s) {
        try { new Digits(s); return false; }
        catch (IllegalArgumentException e) { return true; }
    }

    public static void main(String[] args) {
        check("rejects null", throwsIAE(null));
        check("rejects \"\"", throwsIAE(""));
        check("rejects \"--\"", throwsIAE("--"));
        check("rejects \"123\"", throwsIAE("123"));
        check("rejects \"12-345\"", throwsIAE("12-345"));
        check("accepts \"1234\"", !throwsIAE("1234"));
        check("accepts \"12-34 5678\"", !throwsIAE("12-34 5678"));

        check("digitSum of \"12-34 5678\" == 36", new Digits("12-34 5678").digitSum() == 36);
        check("digitSum of \"1111-1111\" == 8", new Digits("1111-1111").digitSum() == 8);
        check("distinctGroups of \"12-34 5678\"", new Digits("12-34 5678").distinctGroups().equals(new HashSet<>(List.of("1234", "5678"))));
        check("distinctGroups of \"1111-1111\"", new Digits("1111-1111").distinctGroups().equals(new HashSet<>(List.of("1111"))));
        check("distinctGroups of \"1234\"", new Digits("1234").distinctGroups().equals(new HashSet<>(List.of("1234"))));

        System.out.println(passed + "/" + total + " passed");
    }
}
