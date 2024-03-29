public class UniquePathsDP {

    public int uniquePaths(int m, int n) {
        /*
        O(m*n)
         */
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp[0].length; i++) {
            if(obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if(obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
