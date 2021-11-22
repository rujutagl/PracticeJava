import java.io.*;
import java.util.*;
public class InterviewTanium {
    // package whatever; // don't place package name!
// Write a function that joins two data sets on a key, returning the joined data.  Bonus points to pretty print the result.

        public static void main (String[] args) {
            System.out.println(Arrays.deepToString(joinData(
                    "name",
                    new String[][]{{"name", "ss"}, {"john tree", "555-22-5555"}, {"amanda plum", "444-11-4444"}},
                    new String[][]{{"birthday", "name"}, {"2000-01-01", "john tree"}, {"1999-02-02", "george stone"}}
            )));
        }

        public static String[][] joinData(String key, String[][] data_set_1, String[][] data_set_2) {
            System.out.println("TODO");
            List<Map<String, String>> listOfMaps = new ArrayList<Map<String, String>>();
            HashMap<String, HashMap<String, String>> map = new HashMap();
            String header1 = data_set_1[0][0]; // name
            String header2 = data_set_1[0][1]; // ss
            String header3 = data_set_2[0][0]; // birthday
            String header4 = data_set_2[0][1]; // name
            for(int i = 1 ; i < data_set_1.length ; i++){
                HashMap<String, String> val  = new HashMap();
                val.put(header2, data_set_1[i][1]);
                map.put(data_set_1[i][0], val);
            }
            for(int i = 1 ; i < data_set_2.length ; i++){
                HashMap<String, String> val  = new HashMap();
                if(!map.containsKey(data_set_2[i][1])) {
                    val.put(header3, data_set_2[i][0]);
                    map.put(data_set_2[i][1], val);
                } else {
                    HashMap<String, String> existingValue = map.get(data_set_2[i][1]);
                    existingValue.put(header3,data_set_2[i][0] );
                    map.put(data_set_2[i][1], existingValue);
                }
            }
            return new String[][]{};
        }

// Example inputs:
// key:  "name"
//
// data_set_1:  [["name", "ss"], ["john tree", "555-22-5555"], ["amanda plum", "444-11-4444"]]
//
// data_set_2: [["birthday", "name"], ["2000-01-01", "john tree"], ["1999-02-02", "george stone"]]
//
// Output for example input:
// resulting data set:
//
// [["name", "ss", "birthday"], ["john tree", "555-22-5555", "2000-01-01"], ["amanda plum", "444-11-4444", "-"], ["george stone", "-", "1999-02-02"]]
//
// printed output:
//
// name         | ss          | birthday
// john tree    | 555-22-5555 | 2000-01-01
// amanda plum  | 444-11-4444 | -
// george stone | -           | 1999-02-02
//
// Given an array and a starting index, determine whether it's possible to reach a 0-value position by starting at index and repeatedly jumping left/right the distance
//    found at array[index]. Return true if it is possible to reach a 0 value, false otherwise.
}
