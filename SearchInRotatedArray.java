class Solution {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                if (A[mid] < A[start]) {
                    if (target <= A[end]) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                } else {
                    start = mid;
                }
            } else {
                if (A[mid] < A[start]) {
                    end = mid;
                } else {
                    if (target >= A[start]) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                }
            }
        }
        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        }

        return -1;

    }

    public static void main(String args[]) {
        int[] a = {1,2,3,4};
        Solution s = new Solution();
        System.out.println(s.search(a, 2));
        int[] b = {3,4,1,2};
        System.out.println(s.search(b, 2));
    }

}
