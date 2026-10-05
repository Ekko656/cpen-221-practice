import java.util.Set;
import java.util.HashSet;

public class Digits {
    private final String s;

    public Digits(String s) {
        if (s == null) {
            throw new IllegalArgumentException("null string");
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                count++;
            }
        }

        if (count == 0) {
            throw new IllegalArgumentException("string is empty");
        }

        if (count % 4 != 0) {
            throw new IllegalArgumentException("not a multiple of 4");
        }

        this.s = s;
    }

    public int digitSum() {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                int value = c - '0';
                sum += value;
            }
        }
        return sum;
    }

    public Set<String> distinctGroups() {
        String cleaned = removeJunk(s);
        Set<String> distinct = new HashSet<>();
        for (int i = 0; i < cleaned.length(); i += 4) {
            distinct.add(cleaned.substring(i, i + 4));
        }
        return distinct;
    }

    private String removeJunk(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                result += c;
            }
        }
        return result;
    }
}
