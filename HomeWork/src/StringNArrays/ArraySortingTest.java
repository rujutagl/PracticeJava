package StringNArrays;

import java.util.*;

class CustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer number1, Integer number2) {
        int value =  number1.compareTo(number2);

        // elements are sorted in reverse order
        if (value > 0) {
            return -1;
        }
        else if (value < 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
public class ArraySortingTest {
    public static void main(String[] args) {
       // int[] arr = {2,0,2,1,1,0};
        int[] arr = {1,2,3,1};
       // int val = findKthSmallest(arr, 3);
        //int peak = findPeakElement(arr);
        //sortColors(arr);

        ArrayList<Integer> res = kLargest(arr,4, 2);

    }

    // sort array of 0,1,2
    //Input: nums = [2,0,2,1,1,0]
    //Output: [0,0,1,1,2,2]
    public static void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while(index <= end && start < end){
            if(nums[index] == 0){
                nums[index] = nums[start];
                nums[start] = 0;
                start ++;
                index ++;
            } else if(nums[index] == 2){
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                index++;
            }
        }
        for(int i : nums){
            System.out.println(i);
        }
    }

    // kth largest element in an array min heap. PQ is java implementation of min heap. smallest element will be poped out
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        for(int elem : nums){
            pq.add(elem);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }

    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int i : arr){
            q.add(i);
            if(q.size() > k)
                q.poll();
        }

        while(!q.isEmpty()){
            res.add(q.poll());
        }
        Collections.reverse(res);
        return res;
    }

    // kth smallest element in array
    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> pq  = new PriorityQueue<>(new CustomComparator());
        for(int elem : nums){
            pq.add(elem);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
    // top k frequent element
    public int[] topKFrequent(int[] nums, int k) {
        if(k== nums.length){
            return nums;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for(int i : nums){
            count.put(i, count.getOrDefault(i, 0)+1);
        }
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        for(int i: count.keySet()){
            heap.add(i);
            if(heap.size() > k){
                heap.poll();
            }
        }
        int[] result = new int[k];
        for(int i = k-1; i>=0; --i){
            result[i] = heap.poll();
        }
        return result;
    }

    // find peak element in an array
    /*
    time complexity :O(log2(n)) space : O(1)
     */
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = (start + end) / 2;
            if(nums[mid] > nums[mid+1])
                end = mid;
            else
                start = mid+1;
        }
        return start;
    }

    /*
    Find first and last occurance of a num in given sorted array  0 1 2 3 4 5 6
     */
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirstOccurrence(nums, target), findLastOccurrence(nums, target)};
    }
    private int findFirstOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int result = -1;
        while(start <= end){
            int middle = start + (end-start)/2 ;
            if(nums[middle] == target){
                result = middle;
                end = middle - 1;
            } else if(target < nums[middle]){
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return result;
    }
    private int findLastOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int result = -1;
        while(start <= end){
            int middle = start + (end-start)/2 ;
            if(nums[middle] == target){
                result = middle;
                start = middle + 1;
            } else if(target < nums[middle]){
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return result;
    }

    /*
    Reverse to Make Equal
    Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
    Signature
    bool areTheyEqual(int[] arr_a, int[] arr_b)
    Input
    All integers in array are in the range [0, 1,000,000,000].
    Output
    Return true if B can be made equal to A, return false otherwise.
    Example
    A = [1, 2, 3, 4]
    B = [1, 4, 3, 2]
    output = true
    TC O(n log n) - as sorting internally uses merge sort or bubble sort
     */
    boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
        Arrays.sort(array_a);
        Arrays.sort(array_b);
        return Arrays.equals(array_a, array_b);
    }

    boolean areTheyEqualCheckingFreq(int[] array_a, int[] array_b) {
        // Write your code here
        int[] freq = new int[1001];
        for(int i : array_a) freq[i]++;
        for(int i : array_b) freq[i]--;
        for(int i : freq){
            if(i != 0) return false;
        }
        return true;
    }


}
