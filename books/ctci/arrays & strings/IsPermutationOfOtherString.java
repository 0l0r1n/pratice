import java.util.Arrays;

/*
    Permutation - if two strings are permutations, they should have the same chars but in different orders
*/
public class IsPermutationOfOtherString {

    public static void main(String[] args) {
        System.out.println(solveBySorting("logarithm", "algorithm"));
        System.out.println(solveByCounting("logarithm", "algorithm"));
        System.out.println(solveBySorting("abab", "bbaa"));
        System.out.println(solveByCounting("abab", "bbaa"));
        System.out.println(solveBySorting("not applicable", "something"));
        System.out.println(solveByCounting("not applicable", "something"));
    }

    // solveBySorting runs at n log n where n is the length of the string
    public static boolean solveBySorting(String s, String t) {
        if (s.length() != t.length()) return false;
        String sortedS = sortString(s);
        String sortedT = sortString(t);
        return sortedS.equals(sortedT);
    }

    // solveByCounting
    public static boolean solveByCounting(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[128];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }
        for (char ch : t.toCharArray()) {
            if (count[ch] < 0) return false;
            count[ch]--;
        }
        return true;
    }

    private static String sortString(String s) {
        char[] arrayOfCharacters = s.toCharArray();
        Arrays.sort(arrayOfCharacters);
        return new String(arrayOfCharacters);
    }
    
}