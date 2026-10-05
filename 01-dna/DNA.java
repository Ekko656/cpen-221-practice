import java.util.Set;
import java.util.HashSet;

public class DNA {

    private final String sequence;

    public DNA(String sequence) {
        if (sequence == null) {
            throw new IllegalArgumentException("sequence is null");
        }
        int n = removeJunk(sequence).length();
        if (n == 0 || n % 3 != 0) {
            throw new IllegalArgumentException("bad nucleotide count");
        }
        this.sequence = sequence;
    }

    public int nucleotideCount(char c) {
        if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public Set<String> codonSet() {
        String cleaned = removeJunk(sequence);
        Set<String> codons = new HashSet<>();
        for (int i = 0; i < cleaned.length(); i += 3) {
            codons.add(cleaned.substring(i, i + 3));
        }
        return codons;
    }

    private String removeJunk(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A' || c == 'C' || c == 'G' || c == 'T') {
                result += c;
            }
        }
        return result;
    }
}
