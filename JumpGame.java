public class JumpGame {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return true;
        }

        boolean[] f = new boolean[A.length];
        f[0] = true;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && j + A[j] >= i) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[A.length - 1];
    }

    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int[] f = new int[A.length];

        for (int i = 1; i < A.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + A[j] >= i) {
                    min = Math.min(min, f[j] + 1);
                }
                f[i] = min;
            }
        }
        return f[A.length - 1];
    }
}
