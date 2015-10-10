public class SearchInBigSortedArray {
    /**
     * @param A: An integer array
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int end = 0;
        while (end < A.length && A[end] < target) {
            end = end * 2 + 1;
        }

        int start = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
}
