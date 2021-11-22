package Graph;

public class NumberOfIslandsLeetcode {

    public int numIslands(char[][] grid) {
        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    island++;
                }
            }
        }
        return island;
    }
    void dfs(char[][] grid, int i, int j){
        if(i< 0 || j< 0 || i > grid.length-1 || j> grid[0].length-1 )return;
        if(grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i< grid.length; i++){
            for(int j = 0;j< grid[i].length ;j++){
                if(grid[i][j] == 1){
                    max= Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;

    }

    int dfs(int[][] grid, int i , int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length  || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int count = 1;
        count+=dfs(grid, i+1, j);
        count+=dfs(grid, i-1, j);
        count+=dfs(grid, i, j+1);
        count+=dfs(grid, i, j-1);

        return count;
    }
}
