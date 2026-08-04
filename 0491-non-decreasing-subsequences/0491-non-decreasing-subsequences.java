class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(nums, 0, curr, result);
        return result;
    }

    private void dfs(int[] nums, int idx, List<Integer> curr, List<List<Integer>> result) {

        if(curr.size() >= 2) {
            result.add(new ArrayList<>(curr));
        }

        HashSet<Integer> used = new HashSet<>();

        for(int i = idx; i < nums.length; i++) {
            if(used.contains(nums[i])) {
                continue;
            }

            if(!curr.isEmpty() && nums[i] < curr.get(curr.size() - 1)) {
                continue;
            }

            used.add(nums[i]);
            curr.add(nums[i]);
            dfs(nums, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}