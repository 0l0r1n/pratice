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

}