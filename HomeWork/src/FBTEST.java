import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class FBTEST {

    private static int[] answerQueries(ArrayList<Query> queries, int N) {
        TreeSet<Integer> bst = new TreeSet<>();
        List<Integer> output = new ArrayList<>();

        for (Query q : queries) {
            if (q.type == 1) {
                bst.add(q.index);
            } else {
                Integer nearSmallest = bst.ceiling(q.index);
                int a = (nearSmallest == null) ? -1 : nearSmallest;
                output.add(a);
            }
        }

        int[] o = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            o[i] = output.get(i);
        }
        return o;
    }
}
class Query{
    int type;
    int index;
    Query(){};
}
