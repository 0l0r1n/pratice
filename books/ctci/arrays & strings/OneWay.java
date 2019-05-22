/* 
    There are three types of edits that can be performed on a string: remove a char, add a char or replace a char.
    Given two strings, write a function to check if they are one or zero edits away.
    Hint: you don't need to check the strings for insertion, replacement and removal edits. The lenghts of the strings
    will indicate which of these you need to check
    
*/
public class OneWay {
    
    // This algorithm will take max O(n) where n is the length of the shorter string
    public static boolean solve(String s, String t) {
        if (s.length() == t.length()) return oneEditReplace(s, t);
        if (s.length() + 1 == t.length()) return oneEditInsert(s, t);
        if (t.length() + 1 == s.length()) return oneEditInsert(t, t);
        return false;
    }

    private static boolean oneEditInsert(String s, String t) {
        int indexS = 0;
        int indexT = 0;
        while (indexS < s.length() && indexT < t.length()) {
            if (s.charAt(indexS) != t.charAt(indexT)) {
                if (indexS != indexT) return false;
                indexT++;
            } else {
                indexS++;
                indexT++;
            }
        }
        return true;
    }

    private static boolean oneEditReplace(String s, String t) {
        boolean foundDifference = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (foundDifference) return false;
                foundDifference = true;
            }
        }
        return true;
    } 

    public static void main(String[] args) {
        System.out.println(solve("pale", "ple"));
        System.out.println(solve("pales", "pale"));
        System.out.println(solve("pale", "bale"));
        System.out.println(solve("pale", "base"));
    }
}