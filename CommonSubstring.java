public class CommonSubstring {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        int[][] f = new int[A.length() + 1][B.length() + 1];

        int max = 0;
        for (int i = 1; i < A.length() + 1; i++) {
            for (int j = 1; j < B.length() + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    max = Math.max(max, f[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String argv[]) {
        CommonSubstring c = new CommonSubstring();
        System.out.println(c.longestCommonSubstring("abcd","acbc"));
    }
}
