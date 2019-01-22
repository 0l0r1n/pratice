public class OneEdit {

    public static boolean isOneEditAway(String s, String t) {
        if (s.length() == t.length()) return oneEditReplace(s, t);
        if (s.length() + 1 == t.length()) return oneEditInsert(s, t);
        if (s.length - 1 == t.length()) return oneEditInsert(t, s);
        return false;
    }
    
    private static boolean oneEditReplace(String s, String t) {
        boolean foundDifference = false;
        for (int i = 0;  i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (foundDifference) return false;
                foundDifference = true;
            }
        }
        return true;
    }

    private static boolean oneEditInsert(String s, String t) {
        int indexS = 0;
        int indexT = 0;
        while (indexS < s.length() && indexT <= t.length()) {
            if (s.charAt(indexS) != t.charAt(indexT)) {
                if (indexS != indexT) return false;
                indexT++;
            }
            else {
                indexS++;
                indexT++;
            }
        }
        return true;
    }

}