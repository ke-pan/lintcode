class Solution {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int p = m - 1, q = n - 1, i = m + n - 1;
        while(p >=0 && q >= 0) {
            if (A[p] > B[q]) {
                A[i--] = A[p--];
            } else {
                A[i--] = B[q--];
            }
        }
        while (p >= 0) {
            A[index--] = A[p--];
        }
        while (q >= 0) {
            A[index--] = B[q--];
        }
    }

    public static void main(String argv[]) {
        Solution s = new Solution();
        int[] a = new int[5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        int[] b = {4, 5};
        s.mergeSortedArray(a, 3, b, 2);
        for(int i=0; i<5; i++) {
            System.out.println(a[i]);
        }

    }
}
