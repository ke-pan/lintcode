class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public static int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        for (int i = 0; i <= source.length(); i++) {
            for (int j = 0; j <= target.length(); j++) {
                if (j == target.length()) return i;
                if (i + j == source.length()) return -1;
                if (source.charAt(i + j) != target.charAt(j)) break;
            }
        }
        return -1;
    }

    public static void main(String args[]) {

        System.out.println(strStr("abc", "bc"));
        System.out.println(strStr("abc", "bd"));
        System.out.println(strStr("abc", "abcd"));
        System.out.println(strStr("abc", "a"));
    }
}
