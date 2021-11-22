import java.util.HashMap;

public class TwoSum {

    /*
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].
    Time Complexity : O(n)
     */
    public static int[] twoSum(int[] numbers, int target) {
       HashMap<Integer, Integer> map = new HashMap();
      for(int i=0; i< numbers.length; i++){
           int diff = target - numbers[i];
           if(map.containsKey(diff)){
               int toReturn[] = {map.get(diff), i };
               return toReturn;
           }
           map.put(numbers[i], i);
       }
       return null;
    }

    public static void main(String[] args){
        int arr[]= {2,7,11,15};
        int toReturn[] = twoSum(arr, 9);
        System.out.println(toReturn);
    }
}
