class FindMedianSortedArrays {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int m = A.length + B.length;
        if(m % 2 == 1) {
            return findKth(A, B, 0, 0, m / 2 + 1);
        } else {
            return (findKth(A, B, 0, 0, m / 2) + findKth(A, B, 0, 0, m / 2 + 1)) / 2.0;
        }

    }

    public int findKth(int[] A, int[] B, int i, int j, int k) {

        if (i >= A.length) {
            return B[j+k-1];
        }
        if (j >= B.length) {
            return A[i+k-1];
        }

        if (k == 1) {
            if (A[i] > B[j]) {
                return B[j];
            } else {
                return A[i];
            }
        }

        if (i+k/2 -1 >= A.length) {
            return findKth(A, B, i, j+k/2, k-k/2);
        }
        if (j+k/2 -1 >= B.length) {
            return findKth(A, B, i+k/2, j, k-k/2);
        }

        if (A[i+k/2-1] > B[j+k/2-1]) {
            return findKth(A, B, i, j+k/2, k-k/2);
        } else {
            return findKth(A, B, i+k/2, j, k-k/2);
        }
    }

    public static void main(String argv[]) {
        FindMedianSortedArrays s = new FindMedianSortedArrays();
        int[] a = {1,2,3};
        int[] b = {4,5};
        System.out.println(s.findMedianSortedArrays(a, b));
        int[] c = {1,2,3};
        int[] d = {4,5,6};
        System.out.println(s.findMedianSortedArrays(c, d));
        System.out.println(s.findKth(c, d, 0, 0, 4));
    }
}
