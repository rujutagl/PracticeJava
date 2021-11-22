package StringNArrays;

import java.io.*;
import java.util.*;
public class MinimumWindowSubstring {

// Add any extra import statements you may need here


        // Add any helper functions you may need here


    public String minWindow(String s, String t) {
        if(s.length() == 0 || s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap();
        for(char c: t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int minLeft = 0;

        for(int i = 0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) >= 0){
                    count++;
                }
            }

            while(count == t.length()){
                if(minLength > (i-start+1)){
                    minLength = i-start+1;
                    minLeft = start;
                }
                if(map.containsKey(s.charAt(start))){
                    map.put(s.charAt(start) , map.get(s.charAt(start))+1);
                    if(map.get(s.charAt(start)) > 0) count--;
                }
                start++;
            }
        }
        if(minLength > s.length()) return "";

        return s.substring(minLeft, minLeft+minLength);
    }


        // These are the tests we use to determine if the solution is correct.
        // You can add your own at the bottom.
        int test_case_number = 1;
        void check(int expected, int output) {
            boolean result = (expected == output);
            char rightTick = '\u2713';
            char wrongTick = '\u2717';
            if (result) {
                System.out.println(rightTick + " Test #" + test_case_number);
            }
            else {
                System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
                printInteger(expected);
                System.out.print(" Your output: ");
                printInteger(output);
                System.out.println();
            }
            test_case_number++;
        }
        void printInteger(int n) {
            System.out.print("[" + n + "]");
        }
        public void run() throws IOException {
            String s_1 = "ADOBECODEBANC";
            String t_1 = "ABC";
            int expected_1 = 5;
            String output= "BANC";
          //  int output_1 = minLengthSubstring(s_1, t_1);
            //check(expected_1, output_1);
            String outputStr = minWindow(s_1, t_1);
//            String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
//            String t_2 = "cbccfafebccdccebdd";
//            int expected_2 = -1;
//            int output_2 = minLengthSubstring(s_2, t_2);
//            check(expected_2, output_2);

            // Add your own test cases here

        }
        public static void main(String[] args) throws IOException {
            new MinimumWindowSubstring().run();
        }
    }
