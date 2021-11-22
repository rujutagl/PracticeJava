import java.util.Arrays;
import java.util.Stack;

public class MergeIntervalsLeetCode {
    /*/
    TC: O(n log n)
    SC: O(n)
     */
    public static void main(String[] args) {
      int[][] test = {{1,3},{2,6},{8,10},{15,18}};
        merge(test);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack();

        stack.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int startPoint2 = intervals[i][0];
            int endPoint2 = intervals[i][1];

            int[] popArr = stack.pop();
            int startPoint1 = popArr[0];
            int endPoint1 = popArr[1];

            int maxEnd  = Math.max(endPoint1, endPoint2);
            if(endPoint1 >= startPoint2){
                int[] merge = new int[]{startPoint1,maxEnd};
                stack.add(merge);
            } else {
                stack.add(popArr);
                stack.add(intervals[i]);
            }
        }

        int[][] result = new int[stack.size()][2];
        for(int i = result.length - 1; i >=0 ; i--){
            int[] popArr = stack.pop();
            result[i][0]= popArr[0];
            result[i][1]= popArr[1];
        }

        return result;
    }
}
