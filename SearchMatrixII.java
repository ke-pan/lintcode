public class SearchMatrixII {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int row = rows - 1, col = 0;
        int number = 0;
        while(row >= 0 && col <= cols - 1) {
            // System.out.println(row);
            // System.out.println(col);
            if(matrix[row][col] == target) {
                number++;
                col++;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                row--;
            }
        }
        return number;
    }

    public static void main(String argv[]) {
        SearchMatrixII s = new SearchMatrixII();
        int[][] a = {{1, 3, 5, 7},{2, 4, 7, 8},{3, 5, 9, 10}};
        System.out.println(s.searchMatrix(a, 3));
        System.out.println(s.searchMatrix(a, 9));
        System.out.println(s.searchMatrix(a, 0));
        System.out.println(s.searchMatrix(a, 1));
        System.out.println(s.searchMatrix(a, 10));
        System.out.println(s.searchMatrix(a, 11));
    }
}
