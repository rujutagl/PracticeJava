package StringNArrays;

import java.util.*;

public class StringsAndArrays {

    public static void fizzBuzz(int n){
        for (int i =1; i <= n; i++){
            if(i % 3 ==0 && i % 5 ==0){
                System.out.println("fizzbuzz");
            } else if(i % 3 ==0) {
                System.out.println("fizz");
            }else if(i % 5 ==0) {
                System.out.println("buzz");
            } else {
                System.out.println(i);
            }
        }

    }

    public static int titleToNumber(String s) {
        int result = 0;
        for (char c : s.toCharArray()) {
            result = result * 26 + (c - 64);
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        String trimmed = s.replace(" ", "");
        StringBuffer sb = new StringBuffer(trimmed);
        if(sb.equals(sb.reverse()))
            return true;
        else
            return false;
    }

    public static List<Integer> rotate_array(List<Integer> input_array, int k) {
        //List<Integer> result = new ArrayList<>(input_array.size());
        Collections.rotate(input_array, k);
        return input_array;
    }

    public static boolean isSubsequence(String s, String t) {
        int i=0; // s pointer
        int j=0; // t pointer
        while(j<s.length()){
            if(t.charAt(j) == s.charAt(i)){
                i++;
                if(i == s.length())
                    return true;
            }
            j++;
        }
        return false;
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.// 5 1 22 25 6 -1 8 10 // 1 6 -1 10
        int i = 0;
        int j = 0;
        while(i<array.size()){
            if(sequence.get(j) == array.get(i)){
                j++;
                if(j == sequence.size()){
                    return true;
                }
            }
            i++;
        }
        return false;
    }
    public static void main(String[] args)
    {
        //fizzBuzz(15);
        // System.out.println(titleToNumber("AA"));
        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7);
//        System.out.println(rotate_array(list, 3));
//        int[] a= {12, 3, 4, 1, 6, 9};
//        find3Numbers(a,24);

      // int[] a= {12, 3, 6, 1, 6, 9};
        // System.out.println(findTriplets(a, 24));

        /*int mat[ ][ ] = {
                {1, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0}};

        System.out.println("Matrix Initially");

        printMatrix(mat);

        modifyMatrix(mat);
        System.out.println("Matrix after modification n");
        printMatrix(mat);*/
       // String arr[] = { "cat", "dog", "tac", "god", "act" };
       // printAnagrams(arr);
       // Print Longest substring without repeating characters
       // String str = "ABDEFGABEF";
       // System.out.print(findLongestSubstring(str));
       // String longestPalindromeStr = longestPalindrome("babad");
        // increasing subsequence
        //int[] nums = {1,2,3,4,5};
        //System.out.println(increasingTriplet(nums));
        //System.out.println(findLongestSubstringEfficientSet("abcabcbb"));
        List<Integer> array = new ArrayList<>(); // 5 1 22 25 6 -1 8 10
        array.add(5);
        array.add(1);
        array.add(22);
        array.add(25);
        array.add(6);
        array.add(-1);
        array.add(8);
        array.add(10);
        List<Integer> seq = new ArrayList<>(); // 1 6 -1 10
        seq.add(1);
        seq.add(6);
        seq.add(-1);
        seq.add(10);
        isValidSubsequence(array,seq);
    }

    //Find a triplet that sum to a given value
    // Input: array = {12, 3, 4, 1, 6, 9}, sum = 24;
    //Output: 12, 3, 9

    public static boolean find3Numbers(int[] a, int sum){
        for(int i = 0 ; i < a.length -2 ; i++){
            for(int j=i+1 ; j < a.length -1; j++){
                for(int k=j+1; k < a.length; k++){
                    if(a[i] + a[j] + a[k] == sum) {
                        System.out.println("triplet is "+ a[i] + "," +a[j] +","+a[k]);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //All unique triplets that sum up to a given value
    //    Input : array = {12, 3, 6, 1, 6, 9} sum = 24
    //    Output : [[3, 9, 12], [6, 6, 12]]
    public static List<List<Integer>> findTriplets(int[] nums, int sum){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempTriplets = new ArrayList<>();
        Arrays.sort(nums);
        TreeSet<String> set = new TreeSet<>();
        for(int i =0; i < nums.length - 2 ; i++){
            int j = i+1;
            int k = nums.length -1;
            while(j < k){
                if(nums[i] + nums[j] + nums[k] == sum){
                    String addStr = nums[i] +":"+nums[j]+":"+nums[k];
                    if(!set.contains(addStr)){
                        tempTriplets.add(nums[i]);
                        tempTriplets.add(nums[j]);
                        tempTriplets.add(nums[k]);
                        result.add(tempTriplets);
                        tempTriplets = new ArrayList<>();
                        set.add(addStr);
                    }
                    j++;
                    k--;
                } else if(nums[i] + nums[j] + nums[k] < sum) {
                    j++;
                } else
                    k--;
            }
        }
        return result;
    }

    //Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1
    // (or true) then make all the cells of ith row and jth column as 1. O(M*N) space O(M+N)
    public static void modifyMatrix(int mat[ ][ ]){
        int R = mat.length;
        int C = mat[0].length;
        int row[] = new int[R];
        int col[] = new int[C];
        for(int i=0; i<R ; i++){
            for(int j=0; j<C; j++){
                if(mat[i][j] == 1){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i=0; i<R ; i++) {
            for (int j = 0; j < C; j++) {
                if(row[i] == 1 || col[j] == 1){
                    mat[i][j] = 1;
                }
            }
        }
    }
    public static void printMatrix(int mat[ ][ ])
    {
        int i, j;
        int R = mat.length;
        int C = mat[0].length ;
        for (i = 0; i < R; i++)
        {
            for (j = 0; j < C; j++)
            {
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println();
        }
    }

    //Given a sequence of words, print all anagrams together | Set 1
    private static void printAnagrams(String arr[]) {
        HashMap<String, List<String>> map= new HashMap();
        for(String s : arr){
            String word = s;
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String characters = new String(chars);
            if(map.containsKey(characters)) {
                map.get(characters).add(word);
            } else {
                List<String> words = new ArrayList<>();
                words.add(word);
                map.put(characters, words);
            }
        }
        for (String s : map.keySet()) {
            List<String> values = map.get(s);
            if (values.size() > 1) {
                System.out.print(values);
            }
        }
    }

    // Print Longest substring without repeating characters O(n) O(n)
    /*Input : GEEKSFORGEEKS
    Output : EKSFORG

    Input : ABDEFGABEF
    Output : BDEFGA*/
        public static String findLongestSubstring(String str) {
        String result = new String();
        int i;
        int currLength = 0;
        int maxLength = 0;
        int st = 0;
        int start = 0;
        // st starting index of current substring start - starting index of the substring with max length
        HashMap<Character, Integer> pop = new HashMap<>(); // A,0  B,1 D,2  E,3 F,4 G,5
        pop.put(str.charAt(0), 0);
        for(i =1 ; i<str.length(); i++){ // 9
            if(!pop.containsKey(str.charAt(i))){
                pop.put(str.charAt(i), i);
            }
            else { //A,6 B,2 D,2  E,4 F,5 G,5
                if(pop.get(str.charAt(i)) >= st){
                    currLength = i - st; // 5
                    if(maxLength < currLength){
                        maxLength = currLength; // 6
                        start = st; // 0
                    }
                    st = pop.get(str.charAt(i)) +1; // st = 5
                }
                pop.replace(str.charAt(i), i);
            }
        }
        if(maxLength < i -st){
            maxLength = i-st;
            start = st;
        }
        result = str.substring(start, start+maxLength);
        return result;
    }
    /*
    Time O(n) Space O(n)
    https://www.youtube.com/watch?v=4-LshVFzfLI
     */
    public static String findLongestSubstringEfficientSet(String s) {// abcabcbb
        if(s.isEmpty() || s.length() == 0) return "";
        int start=0, end=0, max = 0;
        Set<Character> set = new HashSet<>();
        while(end < s.length()){
            char c = s.charAt(end);
            while(set.contains(c)){
                set.remove(s.charAt(start));
                ++start;
            }
            set.add(c);
            max= Math.max(max, end-start+1);
            ++end;
        }
        System.out.println(max);
        return set.toString();
    }

    // Longest Palindromic Substring
    /*
    Input: s = "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
    Example 2:

    Input: s = "cbbd"
    Output: "bb"
    Example 3:

    Input: s = "a"
    Output: "a"
    Example 4:

    Input: s = "ac"
    Output: "a"
    Time Complexity O(n^2) Space complexity O(n)
     */
    public static String longestPalindrome(String s) {
        int start=0, end = 0;
        for(int i=0; i< s.length(); i++){
            int odd = getLength(s, i, i);
            int even = getLength(s, i, i+1);
            int length = Math.max(odd, even);
            if(length > end-start){
                start = i - (length -1)/2;
                end = i+length/2;
            }
        }
        return s.substring(start, end+1);
    }

    public static int getLength(String s, int left, int right){
        int length = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        length = right - left -1;
        return length;
    }

    // Increasing Triplet Subsequence
    /*
    Input: nums = [1,2,3,4,5]
    Output: true
    Input: nums = [5,4,3,2,1]
    Output: false
     */
    public static boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for(int in = 0; in < nums.length ; in++){
            if(nums[in] <= i){
                i = nums[in];
            } else if(nums[j] <= j){
                j = nums[in];
            } else {
                return true;
            }
        }
        return false;
    }

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        char ch;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<input.length() ; i++) {
            ch = input.charAt(i);
            if(Character.isLowerCase(ch)) {
                ch = (char) ((ch + rotationFactor - 'a') %26 + 'a');
                sb.append(ch);
            } else if(Character.isUpperCase(ch))  {
                ch = (char) ((ch + rotationFactor - 'A') %26 + 'A');
                sb.append(ch);
            } else  if(Character.isDigit(ch)) {
                ch = (char) ((ch + rotationFactor - 48) %10 + 48);
                sb.append(ch);
            } else
                sb.append(ch);
        }
        return sb.toString();

    }

    int matchingPairs(String s, String t) { // abcd adcb
        // Write your code here
        if (s == null || t == null || s.length() != t.length()) return 0;

        int len = s.length(); // 4
        Set<Character> unmatchedS = new HashSet<>();
        Set<Character> unmatchedT = new HashSet<>();

        for (int i = 0; i < len; i++) { //0-3
            if (s.charAt(i) != t.charAt(i)) {
                unmatchedS.add(s.charAt(i)); // b d
                unmatchedT.add(t.charAt(i)); // d b
            }
        }

        if (unmatchedS.isEmpty()) return len - 2;

        int res = len - unmatchedS.size(); // 2
        int contains = 0;
        for (char ch : unmatchedS) {
            if (unmatchedT.contains(ch)) {
                contains++;
                if (contains == 2) break;
            }
        }

        return res + contains;

    }
    //XOR Operation Properties:->  x^0=x and x^x=0
    //Test Case :[2,2,1]
    //So basically when we do a XOR of two numbers, we will get a XOR of 2^2=0 and then in the next step 0^1=1 so final answer will be 1.
    // Since XOR is having a commutative property and associative property which means
    //Commutative: x^y=y^x
    //Associative: x^(y^z)=(x^y)^z
    public int singleNumber(int[] nums) {
        int unique = 0;
        for(int i=0;i<nums.length;i++){
            unique^=nums[i];
        }
        return unique;
    }


}
