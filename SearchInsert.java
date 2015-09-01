public class SearchInsert {
    /**
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A == null) {
            return -1;
        }
        if(A.length == 0) {
            return 0;
        }
        if(A[A.length-1] < target) {
            return A.length;
        }

        int start = 0, end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] == target) {
                end = mid;
            } else if(A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(A[start] >= target) {
            return start;
        } else {
            return end;
        }
    }

    public static void main(String argv[]) {
        SearchInsert s = new SearchInsert();
        int[] a = {1,3,5,6};
        System.out.println(s.searchInsert(a, 5));
        System.out.println(s.searchInsert(a, 7));
        System.out.println(s.searchInsert(a, 2));
        System.out.println(s.searchInsert(a, 0));
    }
}
