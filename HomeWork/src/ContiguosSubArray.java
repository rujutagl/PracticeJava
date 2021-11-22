public class ContiguosSubArray {

    public static void main(String[] args) {

    }
    // brute force TC: O(n^3) SC: O(n)
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i< nums.length; i++){
            for( int j=i; j< nums.length ; j++){
                /*for(int k = j ;k <=j; k++){
                    sum = sum+nums[k];
                }*/
                sum  = sum + nums[j];   //O(n^2)
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    // kadane's algo O(n)
    public int maxSubArrayEfficicent(int[] nums) {
        int bestSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0; i< nums.length; i++){
            currentSum = Math.max(nums[i], currentSum+nums[i]);
            bestSum = Math.max(bestSum, currentSum);
        }
        return bestSum;
    }
}
