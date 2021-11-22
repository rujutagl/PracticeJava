import java.util.Arrays;

public class DynamicProgramming {

    public static void main(String[] args) {
        int[] testArr= {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(testArr));
    }
    // O(n2) longest increasing subsequence
    public static int lengthOfLIS(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        int[] dpArr = new int[nums.length];
        Arrays.fill(dpArr, 1);
        int max = -1;
        for(int i = 1; i< nums.length ; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    dpArr[i] = Math.max(dpArr[i], dpArr[j]+1);
                }
            }
            max = Math.max(max, dpArr[i]);
        }
        return max;
    }
}
