import java.util.HashSet;

public class PalindromePermutation {

    // not the greatest run time
    public static boolean isPalindrome(String s) {
        String trimmedString = s.trim();
        int length = s.length();
        
        char[] firstHalf = new char[length/2];
        char[] secondHalf = new char[length/2];
        
        for (int i = 0; i < length/2; i++) firstHalf[i] = trimmedString.charAt(i);
        
        for (int i = length % 2 == 0 ? length/2 : length/2 + 1; i < s.length(); i++) secondHalf[i] = trimmedString.charAt(i);
        
        java.util.Arrays.sort(firstHalf);
        java.util.Arrays.sort(secondHalf);

        for (int i = 0; i < firstHalf.length; i++) if (firstHalf[i] != secondHalf[i]) return false;
        
        return true;
    }

    public static boolean isPermutationOfPalindromeBitVector(String s) {
        int bitVector = createBitVector(s);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    private static int createBitVector(s) {
        int bitVector = 0;
        for (char c : s.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    private static int toogle(int bitvector, int index) {
        if (index < 0) return bitvector;
        int mask = 1 << index;
        if ((bitvector & mask) == 0) {
             bitvector |= mask;
        } else {
            bitvector &= ~mask;
        }
        return bitvector;
    }

    private static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    public static boolean isPermutationOfPalindrome(String s) {
        int[] table = buildCharFrequencyTable(s);
        return checkMaxOneOdd(table);
    }

    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) return false;
            foundOdd = true;
        }
        return foundOdd;
    }

    private static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    private static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if ( x != -1) table[x]++;
        } 
        return table;
    }

}