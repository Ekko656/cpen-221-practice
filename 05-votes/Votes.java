import java.util.Set;
import java.util.HashSet;

public class Votes {
    private final String ballots;

    public Votes(String ballots) {
        if (ballots == null) {
            throw new IllegalArgumentException("null ballot");
        }

        int count = 0;
        for (int i = 0; i < ballots.length(); i++) {
            if (ballots.charAt(i) == 'A' || ballots.charAt(i) == 'B' || ballots.charAt(i) == 'C') {
                count++;
            }
        }

        if (count == 0) {
            throw new IllegalArgumentException("ballot is empty");
        }

        this.ballots = ballots;
    }

    public int countFor(char c) {
        if (c != 'A' && c != 'B' && c != 'C') {
            return 0;
        }
        int votes = 0;
        for (int i = 0; i < ballots.length(); i++) {
            if (ballots.charAt(i) == c) {
                votes++;
            }
        }
        return votes;
    }

    public Set<Character> candidates() {
        Set<Character> candidates = new HashSet<>();
        int A = countFor('A');
        int B = countFor('B');
        int C = countFor('C');

        if (A != 0) {
            candidates.add('A');
        }

        if (B != 0) {
            candidates.add('B');
        }

        if (C != 0) {
            candidates.add('C');
        }
        return candidates;
    }
}
