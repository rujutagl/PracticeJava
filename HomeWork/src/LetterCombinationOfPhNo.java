import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhNo {
    /*
    O(3^N×4^M) where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9),
    and N+M is the total number digits in the input.
    Space complexity: O(3^N×4^M) since one has to keep 3^N times 4^M solutions.
    https://www.youtube.com/watch?v=h6FmiyYDjmk&t=1194s
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.isEmpty())
            return result;
        Map<Character, char[]> map = new HashMap<>();
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r', 's'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y', 'z'});
        StringBuilder sb = new StringBuilder();
        letterCombinationsHelper(digits, sb, map, result);
        return result;
    }

    private static void letterCombinationsHelper(String digits, StringBuilder sb, Map<Character,char[]> map, List<String> result) {
        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }

        for(char c : map.get(digits.charAt(sb.length()))){
            sb.append(c);
            letterCombinationsHelper(digits, sb, map, result);
            sb.deleteCharAt(sb.length() -1);
        }
    }

    public static void main(String[] args){
        letterCombinations("23");
    }
}
