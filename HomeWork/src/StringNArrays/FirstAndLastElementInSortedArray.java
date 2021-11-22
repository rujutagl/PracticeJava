package StringNArrays;

public class FirstAndLastElementInSortedArray {

    public static void main(String[] args) {

    }

    // O(n) O(1) - regular linear
    public int[] searchRangeLinear(int[] nums, int target) {
        int[] resultArr = new int[2];
        int startIndex = -1;
        int endIndex=-1;
        for(int i=0 ; i<nums.length; i++){
            if(nums[i] == target && startIndex == -1){
                startIndex = i;
                resultArr[0] = startIndex;
            }
            if(nums[i] == target && startIndex != -1){
                endIndex = i;
                resultArr[1] = endIndex;
            }
        }
        return resultArr;
    }

    // O(log n) O(1) BST
    public int findFirstIndex(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start+end) / 2;
            if(nums[mid] == target){
                index = mid;
                end = mid-1;
            } else if(nums[mid] > target){
                end = mid - 1;
            } else {
                start = start + 1;
            }
        }
        return index;
    }

    public int findLastIndex(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start+end) / 2;
            if(nums[mid] == target){
                index = mid;
                start = mid + 1;
            } else if(nums[mid] > target){
                end = mid - 1;
            } else {
                start = start + 1;
            }
        }
        return index;
    }
}
