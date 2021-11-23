
import java.util.*;
public class TaskAssignment {

        class Item{
            int originalIndex;
            int effort;

            Item(int originalIndex,int effort ){
                this.originalIndex=originalIndex;
                this.effort=effort;
            }

        }

        public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
            // Write your code here.
            List<Item> items = new ArrayList<>();
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            if(tasks.size() == 0) return res;
            for(int i = 0; i<tasks.size(); i++) {
                items.add(new Item(i, tasks.get(i)));
            }

            Collections.sort(items, Comparator.comparing(e->e.effort)); // [1,1,3,3,4,5]
            int start = 0;
            int end = tasks.size() -1;

            while(start < end){
                ArrayList<Integer> tempArr = new ArrayList<>();
                tempArr.add( items.get(start).originalIndex);
                tempArr.add( items.get(end).originalIndex);
                res.add(tempArr);
                start++;
                end--;
            }
            return res;
        }
    }
