public class FindMin {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }

        int start = 0;
        int end = num.length - 1;

        if (num[start] <= num[end]) {
            return num[start];
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] < num[0]) {
                end = mid;
            } else if (num[mid] > num[num.length-1]) {
                start = mid;
            }
        }

        if (num[start] < num[end]) {
            return num[start];
        } else {
            return num[end];
        }
    }
}
