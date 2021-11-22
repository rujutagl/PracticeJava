package StringNArrays;

import javax.print.DocFlavor;

public class StringToAtoi {
    //https://www.youtube.com/watch?v=lJy5GhKYHl0
    public static int myAtoi(String str) {
        double result = 0;
        int sign = 1; // to store negative or positive int

        str = str.trim();
        System.out.println("trim"+str);

        if(str.length() == 0 || str == null){
            return 0;
        }
        boolean isNegative = false;
        int startIndex = 0;
        if(str.charAt(0) == '+' || str.charAt(0) == '-')
            startIndex++;
        if(str.charAt(0) == '-')
            isNegative = true;
        for(int i = startIndex; i < str.length(); i++){
            // for non numeric
            if(str.charAt(i) < '0' || str.charAt(i) > '9' ){
                break;
            }
            int digitValue = (int)(str.charAt(i) -  '0');
            result = result * 10 + digitValue;
        }
        if(isNegative){
            result = -result;
        }
        // out of int range
        if(result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)result;
    }
    public static void main(String[] args){
        System.out.println(myAtoi("  -42"));
    }
}
