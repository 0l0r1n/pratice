import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

class UniqueFinder {

    // set
    // time complexity of O(n)
    // space complexity of O(1)
    public static boolean areAllCharsUniqueSet(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (uniqueChars.contains(ch)) return false;
            uniqueChars.add(ch);
        }
        return true;
    }

    // using array of booleans
    // time complexity of O(n)
    // space complexity of O(1)
    public static boolean areAllCharsUniqueArrayBooleans(String s) {
        // let's assume this is an ascii string
        boolean[] char_set = new boolean[128]; // assuming 128 char set of ascii
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (char_set[val]) return false;
            else char_set[val] = true;
        }
        return true;
    }

    // no extra data structures
    // requires a time complexity of O(n2) 
    // space complexity is still constant O(1)
    public static boolean areAllCharsUniqueNoExtraDataStructs(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && i != j) return false;
            }
        }
        return true;
    }

}