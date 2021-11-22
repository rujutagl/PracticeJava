package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /*
    duplicate combinations are allowed. hint = instead of passing i+1 to recursive loop pass i
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        generateCombinations(0, candidates, new ArrayList(), res, target);
        return res;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        generateCombinations2(0, candidates, new ArrayList(), res, target);
        return res;
    }

    private void generateCombinations(int index, int[] nums, ArrayList curr, List<List<Integer>> res, int target) {
        if(target == 0 ){
            res.add(new ArrayList(curr));
        }

        if(target < 0){
            return;
        }
        for(int i = index ; i < nums.length; i++){
            curr.add(nums[i]);
            generateCombinations(i, nums, curr, res, target - nums[i]);
            curr.remove(curr.size() -1);
        }
    }

    private void generateCombinations2(int index, int[] nums, ArrayList curr, List<List<Integer>> res, int target) {
        if(target == 0 ){
            res.add(new ArrayList(curr));
        }
        if(target < 0){
            return;
        }
        for(int i = index ; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            generateCombinations2(i+1, nums, curr, res, target - nums[i]);
            curr.remove(curr.size() -1);
        }
    }
    // leetcode 77
    /*
    Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
    You may return the answer in any order.
    Example 1:
    Input: n = 4, k = 2
    Output:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
    */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> subset = new ArrayList<>();
        generateCombination(1, n, new ArrayList<Integer>(), subset, k);
        return subset;
    }

    void generateCombination(int start, int n, ArrayList<Integer> currList, List<List<Integer>> subset, int k){
        if(currList.size() == k){
            subset.add(new ArrayList<>(currList));
            return;
        }
         for(int i = start ; i <= n ; i++){
             currList.add(i);
             generateCombination(i+1, n, currList, subset, k);
             currList.remove(currList.size() - 1);
         }
    }
    /*
    Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
    Only numbers 1 through 9 are used.
    Each number is used at most once.
    Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

    Example 1:
    Input: k = 3, n = 7
    Output: [[1,2,4]]
    Explanation:
    1 + 2 + 4 = 7
    There are no other valid combinations.
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateCombinations(1, 9, new ArrayList<Integer>(), subsets,k , n);
        return subsets;
    }

    void generateCombinations(int start, int end , ArrayList<Integer> currentList,  List<List<Integer>> subsets,int k , int target){
        if(target == 0 && currentList.size() ==k) {
            subsets.add(new ArrayList(currentList)); // target, k
            return;
        }
        for(int i = start;i<=end;i++){
            currentList.add(i);
            generateCombinations(i+1, 9, currentList, subsets,k , target-i);
            currentList.remove(currentList.size() -1);
        }
    }
}
