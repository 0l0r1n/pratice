import java.util.HashMap;

/*
    A palindrome is a word or phrase that is the same forwards or backwards.
    Characteristics of a palindrome = even chars of each + allows one odd char. 
    We can further expand this to ignore whitespace as well as capitalisation
*/
public class PalindromePermutation {
    
    public static boolean solveWithHashTable(String s) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (frequency.containsKey(ch)) frequency.put(ch, frequency.get(ch) + 1);
            else frequency.put(ch, 1);
        }
        boolean oddFound = false;
        for (Integer value : frequency.values()) {
            if (value % 2 == 1) {
                if (oddFound) return false;
                oddFound = true;
            }
        }
        return true;
    }

    // space is O(1). Time remains O(n) where n is the length of the string
    public static boolean solveWithBitVector(String s) {
        return false;
    }
    public static void main(String[] args) {
        System.out.println(solveWithHashTable("tactcoa"));
        System.out.println(solveWithHashTable("aabbaa"));
        System.out.println(solveWithHashTable("tactcoapapa"));
        System.out.println(solveWithHashTable("dhakweqasdn"));
    }
}