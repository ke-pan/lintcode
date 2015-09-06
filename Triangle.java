import java.util.*;
public class Triangle {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int depth = triangle.size();
        int[][] f = new int[2][depth];

        f[0][0] = triangle.get(0).get(0);
        for ( int i = 1; i < depth; i++) {
            int curruntRow = i % 2;
            int lastRow = (i - 1) % 2;
            for (int j = 0; j <= i; j++) {
                int top = i - 1 < j ? Integer.MAX_VALUE : f[lastRow][j];
                int topL = j - 1 < 0 ? Integer.MAX_VALUE : f[lastRow][j - 1];
                int min = Math.min(top, topL);
                f[curruntRow][j] = min + triangle.get(i).get(j);
            }
        }

        int row = (depth - 1) % 2;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < depth; i++) {
            if (f[row][i] < min) {
                min = f[row][i];
            }
        }
        return min;
    }
}
