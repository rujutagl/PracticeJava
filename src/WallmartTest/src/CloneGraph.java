//import java.util.*;
//
//public class CloneGraph {
//    public GraphNode clone(GraphNode input){
//        Queue<GraphNode> q = new LinkedList<>();
//        q.add(input);
//        HashMap<GraphNode, GraphNode> map = new HashMap<>();
//        map.put(input, new GraphNode(input.val));
//        while(!q.isEmpty()){
//            GraphNode gn = q.poll();
//            GraphNode clonedGraph= map.get(gn);
//            if(gn.neighbours != null){
//                Vector<GraphNode> neighbours = gn.neighbours;
//                for(GraphNode neighbourGn : neighbours){
//                    GraphNode clonedGraphNeighbour = map.get(neighbourGn.val);
//                    if(clonedGraphNeighbour == null){
//                        q.add(neighbourGn);
//                        clonedGraphNeighbour = new GraphNode(neighbourGn.val);
//                        map.put(neighbourGn, clonedGraphNeighbour);
//                    }
//                    clonedGraph.neighbours.add(clonedGraphNeighbour);
//                }
//            }
//        }
//        return map.get(input);
//    }
///*
//      Given a list of intervals [1,3],[2,6],[8,10],[15,18],
//return: Merged overlapping intervals [1,6],[8,10],[15,18].
//
// */
//    public int[][] mergeList(int[][] mergeInput){
//        Stack<int[]> stack = new Stack<>();
//        stack.push(mergeInput[0]);//  [1, 6][8,10]
//        for(int i = 1; i<mergeInput.length ; i++){
//            int start2 = mergeInput[i][0];//8
//            int end2 = mergeInput[i][1];// 10
//
//            int[] pop = stack.pop(); // [1,6]
//            int start1 = pop[0];// 1
//            int end1 = pop[1];// 6
//            int newEnd = Math.max(end1, end2);// 10
//            if(end1 >=start2 ){
//                int[] mergedList = new int[]{start1, newEnd}; // [1, 6]
//                stack.push(mergedList);
//            }  else{
//                stack.push(pop);
//                stack.push(mergeInput[i]);
//            }
//
//        }
//
//    }
//}
//class GraphNode{
//    int val;
//    Vector<GraphNode>  neighbours;
//    public GraphNode(){};
//    public GraphNode(int val){
//        val = val;
//        neighbours = new Vector<GraphNode>();
//    }
//}
//
