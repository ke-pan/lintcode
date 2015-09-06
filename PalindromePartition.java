public class PalindromePartition {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        int[] f = new int[s.length() + 1];
        f[0] = -1;
        f[1] = 0;

        boolean[][] isPalindrome = getPalindrome(s);

        // for (int i = 0; i < isPalindrome.length; i++) {
        //     for (int j = 0; j < isPalindrome[0].length; j++) {
        //         System.out.print(isPalindrome[i][j]);
        //         System.out.print(" ");
        //     }
        //     System.out.println();
        // }

        for (int i = 2; i <= s.length(); i++) {
            f[i] = i - 1;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i-1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }

            }
        }
        return f[s.length()];
    }

    private boolean[][] getPalindrome(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                isPalindrome[i-1][i] = true;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int l = 1;  n > i + l && i - l >= 0; l++ ) {
                if (s.charAt(i + l) == s.charAt(i - l)) {
                    isPalindrome[i - l][i + l] =
                        isPalindrome[i - l + 1][i + l - 1];
                }
            }
            for (int l = 1;  n > i + l  && i - 1 - l >= 0; l++ ) {
                if (s.charAt(i + l) == s.charAt(i - 1 - l)) {
                    isPalindrome[i - 1 - l][i + l] =
                        isPalindrome[i - l][i + l - 1];
                }
            }
        }
        return isPalindrome;
    }

    public static void main(String argv[]) {
        String s = "abcccb";
        PalindromePartition p = new PalindromePartition();
        p.minCut(s);
    }
};
