public class URLifier {

    // first attempt - would not work
    public static String brokenUrlifiy(String s, int length) {
        char[] arr = new char[length];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                arr[i] = '%';
                arr[i+1] = '2';
                arr[i+2] = '0';
            }
            else arr[i] = ch;
        }
        return new String(arr);
    }

    public static String urlify(String s, int length) {
        int countSpaces = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') countSpaces += 3;
            else countSpaces++;
        } 
        char[] arr = new char[length+countSpaces];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                arr[i] = '%';
                arr[i+1] = '2';
                arr[i+2] = '0';
            }
            else arr[i] = ch;
        }
        return new String(arr);
    }

}