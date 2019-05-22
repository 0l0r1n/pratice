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
            int x = getCharNumber(ch);
            if (x == - 1) continue;
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

    private static int getCharNumber(char ch) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(ch);
        if (a <= val && val <= z) return val - a;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solveWithHashTable("tact coa"));
        System.out.println(solveWithHashTable("aabbaa"));
        System.out.println(solveWithHashTable("tactcoapapa"));
        System.out.println(solveWithHashTable("dhakweqasdn"));
    }
}