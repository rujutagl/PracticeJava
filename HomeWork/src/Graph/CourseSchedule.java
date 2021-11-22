package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule {
    static List<Integer>[] adj;
    static boolean[] visited;
    static boolean[] marked;

    static Stack<Integer> stack;
    // Time: O(V+E) SC: O(V)
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];//{{1,0},{2,0},{3,1},{3,2}}
        for(int i = 0; i< numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[numCourses];
        marked = new boolean[numCourses];
        for(int i = 0; i< prerequisites.length ;i++){
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i = 0; i< numCourses; i++){
            if(!visited[i]){
                if(isCyclic(i)){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isCyclic(int i){
        visited[i] = true;
        for(Integer j : adj[i]){
            if(!visited[j]){
                if(isCyclic(j)){
                    return true;
                }
            } else if(!marked[j]){
                return true;
            }
        }
        marked[i] = true;
        return false;
    }

    // detecting cycle in directed graph
    // 802. Find Eventual Safe States
//    public List<Integer> eventualSafeNodes(int[][] graph) {
//
//    }
//
    public static void main(String[] args){
       // int[][] preRequisits={{1,0},{2,0},{3,1},{3,2}};
        int[][] preRequisits={{1,0}};
        //canFinish(4, preRequisits);
        findOrder(2, preRequisits);
    }
    // course schedule II - print topological order
    /*
    Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
    Output: [0,2,1,3]
    Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
    So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        for(int i = 0; i< numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i< prerequisites.length ;i++){
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }


        visited = new boolean[numCourses];
        marked = new boolean[numCourses];
        for(int i = 0; i< numCourses; i++){
            if(!visited[i]){
                if(isCyclic(i)){
                    return new int[]{};
                }
            }
        }
        visited = new boolean[numCourses];
        stack = new Stack<>();
        for(int i = 0; i< numCourses; i++){
            if(!visited[i]){
                topologicalSort(i);
            }
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i< res.length ; i++){
            res[i] = stack.pop();
        }
        return res;
    }

    static void topologicalSort(int i){
        visited[i] = true;
        for(Integer j : adj[i]){
            if(!visited[j]){
                topologicalSort(j);
            }
        }
        stack.push(i);
    }

}
