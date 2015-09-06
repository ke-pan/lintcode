public class EditDistance {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int[][] min = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length() + 1; i++) {
            min[i][0] = i;
        }

        for (int i = 1; i < word2.length() + 1; i++) {
            min[0][i] = i;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    min[i][j] = min[i - 1][j - 1];
                } else {
                    min[i][j] = Math.min(min[i - 1][j - 1],
                                Math.min(min[i - 1][j], min[i][j - 1])) + 1;
                }
            }
        }
        return min[word1.length()][word2.length()];
    }
}
