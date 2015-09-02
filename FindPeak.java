class FindPeak {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here

        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid-1] && A[mid] > A[mid+1]) {
                return mid;
            } else if (A[mid] > A[mid+1] || A[mid] < A[mid-1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    }

    public static void main(String argv[]) {
        FindPeak s = new FindPeak();
        int[] a = {1, 2, 1, 3, 4, 5, 7, 6};
        System.out.println(s.findPeak(a));
    }
}
