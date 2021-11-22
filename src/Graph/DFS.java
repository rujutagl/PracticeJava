package Graph;

import java.util.ArrayList;

public class DFS {
//    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
//        // Code here
//        boolean[] visited = new boolean[V];
//        for(int i = 0; i< adj.size(); i++){
//            if(!visited[i]){
//                dfs(adj[i]);
//            }
//        }
//    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        a1.add(4);
        input.add(0, a1);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(3);
        input.add(4, a2);
        System.out.println(input);
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> res= new ArrayList<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i <adj.size();i++){
            if(!visited[i]){
                dfsUtil(adj, visited, res, i);
            }
        }
        return res;
    }

    void dfsUtil(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> res, int i){
        visited[i] = true;
        ArrayList<Integer> tempList = adj.get(i);
        for(Integer j : tempList){
            if(!visited[j]){
                dfsUtil(adj, visited, res, j);
            } 
        }
    }
}
