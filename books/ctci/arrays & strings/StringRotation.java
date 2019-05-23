/*
    The solution assumes the existence of a method isSubstring and it runs on O(A + B) where A and B are the lengthts of each
    string. Since the string lengths would match, runtime is O(N)
*/
public class StringRotation {

    public boolean solve(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }
    
}