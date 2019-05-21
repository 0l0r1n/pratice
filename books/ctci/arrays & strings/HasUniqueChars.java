/*
    This algorithm runs on O(1) and requires O(1) space - it will always require the same amount of space and it will
    max iterate through the same amount of characters. 
    Assumptions made:
    - ASCII characters only - ASCII stands for American Standard Code for Information Interchange. 
*/
public class HasUniqueChars {
    
    public static boolean solveWithArray(String s) { 
        boolean[] found = new boolean[128];
        for (char ch : s.toCharArray()) {
            if (found[ch]) return false;
            found[ch] = true;
        }
        return true;
    }

    // you can also solve this by using a bit vector instead if you don't want to use an array
    public static boolean solveWithBitVector(String s) {
        int checker = 0;
        for (char ch : s.toCharArray()) {
            if ((checker & (1 << ch)) > 0) return false;
            checker |= (1 << ch);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveWithArray("hi"));
        System.out.println(solveWithBitVector("hi"));
        System.out.println(solveWithArray("Leonardo"));
        System.out.println(solveWithBitVector("Leonardo"));
        System.out.println(solveWithArray("algorithm"));
        System.out.println(solveWithBitVector("algorithm"));
        System.out.println(solveWithArray("computer"));
        System.out.println(solveWithBitVector("computer"));
        System.out.println(solveWithArray("science"));
        System.out.println(solveWithBitVector("science"));
    }
}