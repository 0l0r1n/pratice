import java.util.HashMap;

class StringCompresser {

    public static String compress(String s) {
        StringBuilder buffer = new StringBuilder();
        HashMap<Character, Integer> occurrences = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (occurrences.contains(ch)) occurrences.put(ch, occurrences.get(ch) + 1);
            else occurrences.put(ch, 1);
        }
        for (Character c : occurrences.keySet()) {
            buffer.append(c + occurrences.get(c));
        }
        String newString = buffer.toString();
        return newString.length() > s.length() ? newString : s;
    }
}