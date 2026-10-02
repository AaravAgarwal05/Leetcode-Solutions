class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", res, 0, 0, n);
        return res;
    }

    private void dfs(String temp, List<String> res, int open, int close, int n) {
        if(open == n && close == n) {
            res.add(temp);
            return;
        }

        if(open < n) {
            dfs(temp + "(", res, open + 1, close, n);
        }

        if(close < open) {
            dfs(temp + ")", res, open, close + 1, n);
        }
    }
}