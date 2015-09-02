import java.util.*;
public class RecoverRotatedSortedArray {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        int start = 0, end = nums.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) < nums.get(start)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        int find;
        if(nums.get(start) < nums.get(end)) {
            find = end;
        } else {
            find = start;
        }

        System.out.println(find);
        reverse(nums, 0, find);
        reverse(nums, find + 1, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }

    private void reverse(ArrayList<Integer> nums, int start, int end) {
        int i = start, j = end;
        while (i<j) {
            int t = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, t);
            i++;
            j--;
        }
    }

    public static void main(String argv[]) {
        RecoverRotatedSortedArray s = new RecoverRotatedSortedArray();
        ArrayList<Integer> a = new ArrayList<Integer>();;
        a.add(6);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        s.recoverRotatedSortedArray(a);
        for(int i=0; i<a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
}
