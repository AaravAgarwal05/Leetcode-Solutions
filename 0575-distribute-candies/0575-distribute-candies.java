class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> seen = new HashSet<>();

        for(int candy : candyType) {
            seen.add(candy);
        }

        return Math.min(n / 2, seen.size());
    }
}