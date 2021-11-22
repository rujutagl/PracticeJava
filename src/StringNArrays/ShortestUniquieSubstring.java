package StringNArrays;

import java.util.HashMap;
import java.util.Map;

public class ShortestUniquieSubstring {
    public static Map<String, String> shortestUniqueSubstr(String[] strArr) {
        Map<String, String> result = new HashMap<>();

        for(String str : strArr) {
            result.put(str, str);

            for(int i = 0; i < str.length(); i++) {
                for(int j = i + 1; j <= str.length(); j++) {
                    String subStr = str.substring(i, j);
                    boolean addSub = true;
                    for(String str2 : strArr) {
                        if(str2.equals(str)) continue;

                        if(str2.contains(subStr)) {
                            addSub = false;
                            break;
                        }
                    }

                    if(addSub && subStr.length() < result.get(str).length()) {
                        result.put(str, subStr);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, String> result = shortestUniqueSubstr(new String[] {"cheapair", "cheapoair", "peloton", "pelican"});

        for(String key : result.keySet()) {
            System.out.println(key + ": " + result.get(key));
        }
    }
}
