package StringNArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinimumWaitingTime {

    public int minimumWaitingTime(int[] queries) {
        // Write your code here.
        // TC: O(nlogn) SC: O(1)
   /*
		1,2,2,3,6
			0 - duration 1 - queriesleft 4 wait time = 0 + 1*4 = 4
			1 - duration 2 - queriesleft 3 wait time = 4 + 2*3 = 6
			2 - duration 2 - queriesleft 2 wait time = 10 + 2*2 = 14
			3 - duration 3 - queriesleft 1 wait time = 14 + 1*3 = 17
			4 - duration 6 - queriesleft 0 wait time = 17*/
        Arrays.sort(queries);
        int totalWaitTime = 0;
        for(int i = 0; i< queries.length; i++){
            int duration = queries[i];
            int queriesLeft= queries.length - (i+1);
            totalWaitTime+=duration*queriesLeft;
        }
        return totalWaitTime;

    }

    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // Write your code here.
		/*
		1 3 4 5 8
		2 4 5 6 9
		*/
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        String shirtColorInFirstRow = (redShirtHeights.get(0) < blueShirtHeights.get(0))?"RED":"BLUE";
        for(int i = 0 ;i < redShirtHeights.size(); i++){
            int redHeight = redShirtHeights.get(i);
            int blueHeight = blueShirtHeights.get(i);
            if(shirtColorInFirstRow.equals("RED")) {
                if (redShirtHeights.get(i) >= blueShirtHeights.get(i)) {
                    return false;
                }
            } else {
                if (blueShirtHeights.get(i) >= redShirtHeights.get(i)) {
                    return false;
                }
            }
        }
        return true;

    }
}
