public class UniqPath {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] f = new int[rows][cols];

        f[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < rows; i++) {
            f[i][0] = obstacleGrid[i][0] == 1 ? 0 : f[i-1][0];
        }
        for (int j = 1; j < cols; j++) {
            f[0][j] = obstacleGrid[0][j] == 1 ? 0 : f[0][j-1];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                f[i][j] = obstacleGrid[i][j] == 1 ? 0 : f[i][j-1] + f[i-1][j];
            }
        }
        return f[rows-1][cols-1];
    }

    public int uniquePaths(int m, int n) {
        // write your code here
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }

        for (int j = 1; j < n; j++) {
            f[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m - 1][n - 1];

    }
}
