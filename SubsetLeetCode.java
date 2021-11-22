package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetLeetCode {

    public static void  main(String[] args){

    }

    // iterative solution
    // TC: O(n*2^n)
    // SC: O(n*2^n)
    public List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int num : nums){
            int n = res.size();
            for(int j = 0; j< n; j++){
                List<Integer> temp = new ArrayList(res.get(j));
                temp.add(num);
                res.add(temp);
            }
        }
        return res;
    }
    // TC: O(n*2^n)
    // SC: O(n*2^n)
    // we used SC O(n), if output is ignored O(n*2^n), recursive O(n)
    public List<List<Integer>> subsetsRecursive(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubset(0, nums, new ArrayList(), res);
        return res;
    }

    private void generateSubset(int index, int[] nums, ArrayList curr, List<List<Integer>> res) {
        res.add(new ArrayList(curr));
        for(int i = index ; i < nums.length; i++){
            curr.add(nums[i]);
            generateSubset(i+1, nums, curr, res);
            curr.remove(curr.size() -1);
        }
    }
    /*
    Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.
    Example 1:
    Input: nums = [1,2,2]
    Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        generateSubsetWithDup(0, nums, new ArrayList(),res);
        return res;
    }

    private void generateSubsetWithDup(int index, int[] nums, ArrayList curr, List<List<Integer>> res) {
        res.add(new ArrayList(curr));
        for(int i = index ; i < nums.length; i++){
            if(i>index && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            generateSubsetWithDup(i+1, nums, curr, res);
            curr.remove(curr.size() -1);
        }
    }


}
