public class SearchInRotatedSortedArrayLeetcode {
    /*
        Input: nums = [4,5,6,7,0,1,2], target = 0
        Output: 4
        Example 2:

        Input: nums = [4,5,6,7,0,1,2], target = 3
        Output: -1
        Example 3:

        Input: nums = [1], target = 0
        Output: -1

        Time Complexity : O(n)
        Space (1)
     */
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start+end) / 2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[start] <= nums[mid]){
                if(target >= nums[start] && target <= nums[mid]){
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target >= nums[mid] && target <= nums[end]){
                    start = mid +1;
                } else {
                    end = mid -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
