//import java.util.Stack;
//
//public class FBCodingQuestion {
//
//    // Given a string with alpha-numeric characters and parentheses,
//// return a string with balanced parentheses by removing the fewest characters possible.
//// You cannot add anything to the string.
//
//// Input: a(b)) , Output: a(b)
//
//// Input: c((b)
//// OpenParentStack: 1
//// ClosingParen: 4
//
//// a(b)
//
//
//    // stack - a ( b
//
////    public String balancedParantheses(String input){
////
////        Stack stack = new Stack();
////        String result = null;
////        for(int i = 0; i< input.length(); i ++){
////            Character ch = input.charAt(i);
////            if(ch.equals("(")){
////                stack.push(ch);
////                continue;// (
////            }
////        }
////        if(stack.isEmpty) return input;
////        if(ch.equals(")")){
////            stack.pop();
////        }
////        char check = stack.pop();
////        if(check.equals(")")){
////
////        }
////    }
//    //1249. Minimum Remove to Make Valid Parentheses
//    public String minRemoveToMakeValid(String s) {
//        Stack<Integer> openBracketsPos = new Stack<>();
//        char[] arr = s.toCharArray();
//        for(int i=0; i<arr.length;i++){
//            if(arr[i] == '('){
//                openBracketsPos.push(i);
//            }
//            if(arr[i] == ')'){
//                if(openBracketsPos.isEmpty()){
//                    arr[i]='!';
//                }
//                else{
//                    openBracketsPos.pop();
//                }
//            }
//        }
//        while(!openBracketsPos.isEmpty()){
//            arr[openBracketsPos.pop()]='!';
//        }
//        StringBuilder sb = new StringBuilder();
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]!='!')
//                sb.append(arr[i]);
//        }
//        return sb.toString();
//    }
//
//}
//}
