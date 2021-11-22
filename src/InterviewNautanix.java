import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class InterviewNautanix {


   /* 1. Nautanix interview 16th June 2021 - Return starting index of substring if the second string is substring of first
    "HelloWorld".indexOf("World") -> 5
    "HelloWorld".indexOf("Word") -> -1
     "HellHelloWorld".indexOf("Hello") 4
     int indexOf(String s1, String s2)
     indexOf("HelloWorld", "World") -> 5*/
    public static void main(String[] args){
        String s1= "HelloWorld";
        String s2= "World";
        //System.out.println(isSubstringWithIndexIfSubstring(s1,s2));
        isBalanced("{{)[](}}");

    }

    public static int isSubstringWithIndexIfSubstring(String s1, String s2){
        int i = 0; // s1
        int j = 0; // s2
        for(;i<s1.length(); i++){
            if(j == s2.length())
                break;
            if(s1.charAt(i) == s2.charAt(j)){
                j++;
            }
            // Special case where character preceding the i'th character is duplicate
        /*if(j>0){
            i -= j;
        }
        counter = 0;*/
        }
        // to return if substring or not
        //return j < s2.length()?false:true;

        // if not substring return -1 else return index
        return j< s2.length()?-1:i-j;
    }

     /* 2. Nautanix interview 7th july 2021 - Check for Balanced Brackets in an expression
        Input: exp = “[()]{}{[()()]()}”
        Output: Balanced

        Input: exp = “[(])”
        Output: Not Balanced
        Time Complexity: O(n)
        Auxiliary Space: O(n) for stack. */
     static boolean areBracketsBalanced(String expr)
     {
         // Using ArrayDeque is faster than using Stack class
         Deque<Character> stack
                 = new ArrayDeque<Character>();

         // Traversing the Expression
         for (int i = 0; i < expr.length(); i++)
         {
             char x = expr.charAt(i);

             if (x == '(' || x == '[' || x == '{')
             {
                 // Push the element in the stack
                 stack.push(x);
                 continue;
             }

             // If current character is not opening
             // bracket, then it must be closing. So stack
             // cannot be empty at this point.
             if (stack.isEmpty())
                 return false;
             char check;
             switch (x) {
                 case ')':
                     check = stack.pop();
                     if (check == '{' || check == '[')
                         return false;
                     break;

                 case '}':
                     check = stack.pop();
                     if (check == '(' || check == '[')
                         return false;
                     break;

                 case ']':
                     check = stack.pop();
                     if (check == '(' || check == '{')
                         return false;
                     break;
             }
         }

         // Check Empty Stack
         return (stack.isEmpty());
     }
     /*
     Nautanix round 3 Find kth smallest element from given list of int
     Implemented with Priority Queue having custom comparator. time complexity n log K

     Another manager round with behavioural questions.

     Design question :
     If you have to design rest API to apply rules for email system how would you do that
     ex POST /v1/rules
     {
        trigger = "",
        action = "",
        rules= ""
     }
     rules can have simple as well as complex rules
     ex : email != "abc@ss.com" AND subject == "abc" OR body == "test"
     how would you define API and how would you implement the rule on a particular email
     say you have evaluate method and that takes in email object and rule object. How would you implement the rule on that email.
     say you have evaluate method and that takes in email object and rule object. How would you implement the rule on that email.
      */

    /*
    given a set of digit from 1 to 9 {1,2,3,4,5,6,7,8,9}, write code to find k elements whose sum is equal to n.

    e.g.
    k=3, n= 9
    {1, 2, 6}, {1, 3, 5}, {2, 3, 4}

    vector<vector<int>> findKElementsSum(int k, int n)
    {

    }
     */

    public static String isBalanced(String s) {
        // Write your code here {[()]}
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch== '{' || ch=='['){
                stack.push(ch);
                continue;
            }
            if(stack.isEmpty()) return "NO";
            char check;
            switch(ch){
                case ')':
                    check = stack.pop();
                    if(check=='{' || check=='[')
                        return "NO";
                    break;
                case '}':
                    check = stack.pop();
                    if(check=='(' || check=='[')
                        return "NO";
                    break;
                case ']':
                    check = stack.pop();
                    if(check=='}' || check==')')
                        return "NO";
                    break;
            }
        }
        String  res;
        if(stack.isEmpty())res="YES";
        else res="NO";
        return res;
    }
}
