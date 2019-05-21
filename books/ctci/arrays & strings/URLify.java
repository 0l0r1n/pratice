/*
    When working with string problems, it is a common practice to edit the string starting from the end and work your way backwards
    The following algorithm uses a two scan approach
*/

public class URLify {
    public static void main(String[] args) {
        System.out.println(solve("Mr John Smith     ".toCharArray(), 13));
        System.out.println(solve("Leo Alves     ".toCharArray(), 9));  
    }

    public static String solve(char[] s, int trueLength) { 
        int spaces = 0;
        for (int i = 0; i < trueLength; i++) if (s[i] == ' ') spaces++;
        int index = trueLength + spaces * 2;
        if (trueLength < s.length) s[trueLength] = '\0';
        for (int i = trueLength - 1; i >= 0; i--) {
            if (s[i] == ' ') {
                s[index - 1] = '0';
                s[index - 2] = '2';
                s[index - 3] = '%';
                index-=3;
            } else {
                s[index - 1] = s[i];
                index--;
            }
        }
        return new String(s);
    }
}