import java.util.*;

class Permutation {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.size() == 0) {
            return res;
        }

        helper(res, result, nums);
        return res;

    }

    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> result, ArrayList<Integer> nums) {

        if (result.size() == nums.size()) {
            res.add(new ArrayList<Integer>(result));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (!result.contains(nums.get(i))) {
                result.add(nums.get(i));
                helper(res, result, nums);
                result.remove(result.size() - 1);
            }
        }
    }
}
