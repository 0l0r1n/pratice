public class StringCompression {
    
    public static void main(String[] args) {
        System.out.println(solve("aabccccaaa"));
    }

    public static String solve(String s) {
        StringBuilder buffer = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < s.length(); i++) {
            // immediately count up as there is at least one of the current char
            countConsecutive++;
            // check next to see if you reached end of string or if the next character is different
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                buffer.append(s.charAt(i));
                buffer.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return buffer.length() < s.length() ? buffer.toString() : s;
    }

    // there is an alternative approach using two loops where you first count the consecutives and
    // find the length of the buffer before hand. The upside is that you don't need to double the size of the buffer
    // everytime it reaches it is limit. The downside is that you need to loop through things twice.
}