package StringNArrays;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[index++] = nums[i];
            }
        }
        for(int j = index; j<nums.length; j++){
            nums[j] = 0;
        }
    }
}
