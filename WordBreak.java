import java.util.*;
public class WordBreak {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }

        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        int maxLength = getMaxLength(dict);
        for (int i = 1; i <= s.length(); i++) {
            f[i] = false;
            for (int j = Math.max(0, i - maxLength); j < i; j++) {
                f[i] = f[j] && dict.contains(s.substring(j, i));
                if (f[i]) {
                    break;
                }
            }
        }
        return f[s.length()];
    }

    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}
