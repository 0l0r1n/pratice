import java.util.HashMap;

class PermutationsFinder {

    public static boolean isApermutationOfBCountCharsApproach(String a, String b) {
        if (a.length() != b.length()) return false;
        HashMap<Character, Integer> mapOfA = new HashMap<>();
        HashMap<Character, Integer> mapOfB = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char chA = a.charAt(i);
            char chB = b.charAt(i);
            if (mapOfA.containsKey(chA)) mapOfA.put(chA, mapOfA.get(chA) + 1);
            else mapOfA.put(chA, 1);
            if (mapOfB.containsKey(chB)) mapOfB.put(chB, mapOfA.get(chB) + 1);
            else mapOfB.put(chB, 1);
        }
        if (mapOfA.keySet().size() != mapOfB.keySet().size()) return false;
        for (Character ch : mapOfA.keySet()) {
            if (mapOfA.get(ch) != mapOfB.get(ch)) return false;
        }
        return true;
    }

    public static boolean isApermutationOfBCountCharsBetterApproach(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] letters = new int[128]; // assuming ascii
        for (int i = 0; i < a.length(); i++) letters[a.charAt(i)]++;
        for (int i = 0; i < b.length(); i++) {
            letters[b.charAt(i)]--;
            if (letters[b.charAt(i)] < 0) return false;
        }
        return true;
    }

    // 2 N + N log N => O(N)
    public static boolean isApermutationOfBSortingStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        return sort(a).equals(sort(b));
    }

    private static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

}