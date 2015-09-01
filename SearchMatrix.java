public class SearchMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int end = rows * cols - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[start / cols][start % cols] == target || matrix[end / cols][end % cols] == target) {
            return true;
        }
        return false;
    }

    public static void main(String argv[]) {
        SearchMatrix s = new SearchMatrix();
        int[][] a = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(s.searchMatrix(a, 3));
        System.out.println(s.searchMatrix(a, 9));
        System.out.println(s.searchMatrix(a, 0));
        System.out.println(s.searchMatrix(a, 51));
        System.out.println(s.searchMatrix(a, 1));
        System.out.println(s.searchMatrix(a, 50));
    }
}
