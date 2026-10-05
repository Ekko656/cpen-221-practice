import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DNATest {
    static int passed = 0, total = 0;

    static void check(String name, boolean ok) {
        total++;
        if (ok) passed++;
        System.out.println((ok ? "PASS  " : "FAIL  ") + name);
    }

    static boolean throwsIAE(String s) {
        try { new DNA(s); return false; }
        catch (IllegalArgumentException e) { return true; }
    }

    public static void main(String[] args) {
        check("accepts \"ATCGAA\"", !throwsIAE("ATCGAA"));
        check("accepts \"ACGT-!BAG\"", !throwsIAE("ACGT-!BAG"));
        check("accepts \"ACGT-BAG\"", !throwsIAE("ACGT-BAG"));
        check("rejects null", throwsIAE(null));
        check("rejects \"\"", throwsIAE(""));
        check("rejects \"ACGT\"", throwsIAE("ACGT"));
        check("rejects \"---\"", throwsIAE("---"));
        check("rejects \"ATCGAxbTTz\"", throwsIAE("ATCGAxbTTz"));

        DNA d = new DNA("ATCGAA");
        check("nucleotideCount('A') == 3", d.nucleotideCount('A') == 3);
        check("nucleotideCount('X') == 0", d.nucleotideCount('X') == 0);

        check("codonSet of \"ATCGAA\"", new DNA("ATCGAA").codonSet().equals(new HashSet<>(List.of("ATC", "GAA"))));
        check("codonSet of \"AAAAAA\"", new DNA("AAAAAA").codonSet().equals(new HashSet<>(List.of("AAA"))));
        check("codonSet of \"ACGT-!BAG\"", new DNA("ACGT-!BAG").codonSet().equals(new HashSet<>(List.of("ACG", "TAG"))));

        System.out.println(passed + "/" + total + " passed");
    }
}
