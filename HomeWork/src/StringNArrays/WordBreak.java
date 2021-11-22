package StringNArrays;

import java.util.*;

public class WordBreak {

    HashMap<String, Boolean> map = new HashMap();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s)) return true;
        for(int i = 1; i<= s.length() ; i++){
            String sub = s.substring(0, i);
            if(map.containsKey(s))
                return map.get(s);
            if(wordDict.contains(sub) && wordBreak(s.substring(i), wordDict)){
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    static boolean ans = false;
    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<>();
        //map.put("abc", 3);
        //map.put("ab", 2);
        //map.put("abca", 1);
        map.put("abc", 3);
        map.put("ab", 2);
        String str = "abcabcabcabca";
        //String str = "abcabab";

        Set<String> set = new HashSet<>();
        for(String s : map.keySet()){
            set.add(s);
        }

        dfs(map, set, str, 0);
        System.out.println(ans);
    }

    public static void  dfs(Map<String, Integer> map, Set<String> set, String str, int start){
        if(start == str.length()){
            ans = true;
            return;
        }
        for(int i=start; i<str.length(); i++){
            String ss = str.substring(start, i+1);
            if(!set.contains(ss))
                continue;
            if(map.get(ss) == 0){
                continue;
            }
            map.put(ss, map.get(ss)-1);
            dfs(map, set, str, i+1);
            map.put(ss, map.get(ss)+1);
        }
    }
}
