class Solution {
    public boolean predictTheWinner(int[] nums) {
        return bfs(nums, 0, nums.length - 1, 0, 0, true);
    }

    public boolean bfs(int[] nums, int s, int e, int p1, int p2, boolean turn) {
        if(s > e) {
            return p1 >= p2;
        }

        if(turn) {
            return bfs(nums, s + 1, e, p1 + nums[s], p2, false) || bfs(nums, s, e - 1, p1 + nums[e], p2, false);
        } else {
            return bfs(nums, s + 1, e, p1, p2 + nums[s], true) && bfs(nums, s, e - 1, p1, p2 + nums[e], true);
        }
    }
}