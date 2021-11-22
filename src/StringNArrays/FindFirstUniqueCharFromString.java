package StringNArrays;

import java.util.HashMap;

public class FindFirstUniqueCharFromString {
    public static void main(String[] args) {

    }
    /*
    TC: O(n)
    SC: O(n)
     */
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s.length() ; i++){
            Character ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, i);
            } else{
                map.put(ch, -1);
            }
        }
        int min = Integer.MAX_VALUE;
        for(char ch:map.keySet()){
            if(map.get(ch) > -1 && map.get(ch) < min)
                min = map.get(ch);
        }
        return min == Integer.MAX_VALUE ? -1:min;
    }
}
