public class InterleavingString {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        boolean[][] f = new boolean[s1.length() + 1][s2.length() + 1];

        f[0][0] = true;

        for (int i = 1; i < s1.length() + 1; i++) {
            f[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && f[i-1][0];
        }
        for (int j = 1; j < s2.length() + 1; j++) {
            f[0][j] = s2.charAt(j-1) == s3.charAt(j-1) && f[0][j-1];
        }

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                f[i][j] = (s2.charAt(j-1) == s3.charAt(i+j-1) && f[i][j-1]) || (s1.charAt(i-1) == s3.charAt(i+j-1) && f[i-1][j]);
            }
        }

        return f[s1.length()][s2.length()];
    }

    public static void main(String argv[]) {
        String s1 = "aab";
        String s2 = "a";
        String s3 = "aaab";
        InterleavingString i = new InterleavingString();
        System.out.println(i.isInterleave(s1, s2, s3));
    }
}
