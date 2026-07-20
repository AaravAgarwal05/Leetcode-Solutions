class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        int total = r * c;
        k = k % total;
        int[] flatGrid = new int[total];
        int counter = 0;
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                flatGrid[counter++] = grid[i][j];
            }
        }

        counter = 0;

        for(int i = 0; i < r; i++) {
            List<Integer> temp = new ArrayList<>();
            
            for(int j = 0; j < c; j++) {
                temp.add(flatGrid[((counter++ - k + total) % total)]);
            }

            result.add(temp);
        }

        return result;
    }
}