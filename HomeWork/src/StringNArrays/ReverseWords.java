package StringNArrays;

public class ReverseWords {

    public static String reverseWords(String s) {
        String result = null;
        int start = 0;
        int end = 0;
        while(start<s.length()) {
            while (start < s.length() && s.charAt(start) == ' ') {
                start++;
            }
            if(start>=s.length()) break;
            end = start + 1;
            while (end < s.length() && s.charAt(end) != ' ') {
                end++;
            }
            String subStr = s.substring(start, end);
            if (result == null) {
                result = subStr;
            } else {
                result = subStr + " " + result;
            }
            start = end+1;
        }

        return result;
    }

    public static void main(String[] args){
        String s= "  hello world  ";
        s = reverseWords(s);
    }
}
