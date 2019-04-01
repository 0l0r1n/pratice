public class AtoI { 

    public static int solve(String str) {
        boolean isNegative = false;
        boolean hasStarted = false;
        int result = 0;
        try {
            for (char c : str.toCharArray()) {
                if (!hasStarted && Character.isWhitespace(c)) {
                    // irrelevant
                } else if (!hasStarted && (c == '+' || c == '-') ) {                
                    isNegative = c == '-';
                    hasStarted = true;
                } else if (Character.isDigit(c)) {
                    hasStarted = true;
                    result = Math.multiplyExact(result, 10);
                    result = Math.addExact(result, Character.getNumericValue(c));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            return isNegative? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return isNegative? -result : result;
    }
}