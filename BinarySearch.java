class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        int mid;

        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(nums[mid] < target) {
                start = mid;
            }
            else if(nums[mid] > target) {
                end = mid;
            }
            else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] a = {1,2,2,4};
        Solution s = new Solution();
        System.out.println(s.binarySearch(a, 2));
    }
}
