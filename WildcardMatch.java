public class WildcardMatch {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];

        f[0][0] = true;

        for(int j = 1; j < p.length() + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                f[0][j] = f[0][j - 1];
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for(int j = 1; j < p.length() + 1; j++) {
                if (p.charAt(j - 1) == '?') {
                    f[i][j] = f[i-1][j-1];
                } else if (p.charAt(j - 1) == '*') {
                    f[i][j] = false;
                    for (int k = 0; k <= i; k++) {
                        if (f[i - k][j - 1]) {
                            f[i][j] = true;
                            break;
                        }
                    }
                } else {
                    f[i][j] = s.charAt(i - 1) == p.charAt(j - 1) && f[i - 1][j - 1];
                }
            }
        }

        return f[s.length()][p.length()];
    }

    public static void main(String argv[]) {
        // String s = 'ab';
        // String t = '*';
        WildcardMatch w = new WildcardMatch();
        System.out.println(w.isMatch("ab", "*"));
        System.out.println(w.isMatch("ab", "a"));
        System.out.println(w.isMatch("ab", "?*"));
        System.out.println(w.isMatch("", "*"));
    }
}
