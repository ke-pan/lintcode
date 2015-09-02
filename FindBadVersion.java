class VersionControl {
    public static boolean isBadVersion(int n) {
        if (n > 5) {
            return false;
        } else {
            return true;
        }
    }
}
/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
*/
class FindBadVersion {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n < 1) {
            return 0;
        }
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (VersionControl.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (VersionControl.isBadVersion(start)) {
            return start;
        } else if (VersionControl.isBadVersion(end)) {
            return end;
        } else {
            return 0;
        }
    }

    public static void main(String argv[]) {

    }

}
