public class ReverseWords {

    public static String solve(String s) {
        String[] strs = s.trim().split(" ");
        System.out.println(Arrays.toString(strs));
        StringBuilder buffer = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--){
            String word = strs[i].trim();
            if (word.equals("")) continue;
            buffer.append(word);
            buffer.append(' ');
        }
        if (buffer.length() > 0) buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString().trim();
    }
}