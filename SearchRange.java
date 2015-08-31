
import java.util.*;

class Solution {

    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
        ArrayList<Integer> results = new ArrayList<Integer>();
        results.add(-1);
        results.add(-1);
        if(A == null || A.size() ==0) {
            return results;
        }

        int start = 0, end =  A.size() - 1;
        int mid;

        // find first
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A.get(mid) == target) {
                end = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            } else if (A.get(mid) > target) {
                end = mid;
            }
        }
        if (A.get(start) == target) {
            results.set(0, start);
        } else if (A.get(end) == target) {
            results.set(0, end);
        } else {
            return results;
        }

        // find second
        start = 0;
        end =  A.size() - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A.get(mid) == target) {
                start = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            } else if (A.get(mid) > target) {
                end = mid;
            }
        }
        if (A.get(end) == target) {
            results.set(1, end);
        } else if (A.get(start) == target) {
            results.set(1, start);
        }
        return results;
    }

    public static void main (String args[]) {
        Solution s = new Solution();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(5);
        a.add(7);
        a.add(7);
        a.add(8);
        a.add(8);
        a.add(10);
        System.out.println(s.searchRange(a, 8));
    }
}
