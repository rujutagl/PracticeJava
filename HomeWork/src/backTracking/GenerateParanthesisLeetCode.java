package backTracking;

import javax.print.DocFlavor;
import java.util.*;
public class GenerateParanthesisLeetCode {

    //https://www.youtube.com/watch?v=s9fokUqJ76A
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, 0,0,new StringBuilder(), n);
        return result;
    }

    public static void backtrack(List<String> result, int open, int close, StringBuilder current, int n){
        if(current.length() == n* 2){
            result.add(current.toString());
            return;
        }
        if( open < n){
            current.append("(");
            backtrack(result, open+1, close, current, n);
            current.deleteCharAt(current.length() -1);
        }
        if(close < open){
            current.append(")");
            backtrack(result, open, close+1, current, n);
            current.deleteCharAt(current.length() -1);
        }
    }

    public static void main(String[] args){
        generateParenthesis(3);
    }

}
