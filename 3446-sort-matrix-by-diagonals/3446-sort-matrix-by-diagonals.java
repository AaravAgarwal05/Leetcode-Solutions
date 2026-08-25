class Solution {
    public int[][] sortMatrix(int[][] grid) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int r = grid.length;
        int c = grid[0].length;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(!map.containsKey(i - j)) {
                    if(i - j >= 0) {
                        map.put(i - j, new PriorityQueue<>((a, b) -> b - a));
                    } else {
                        map.put(i - j, new PriorityQueue<>((a, b) -> a - b));
                    }
                }

                map.get(i - j).offer(grid[i][j]);
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                grid[i][j] = map.get(i - j).poll();
            }
        }

        return grid;
    }
}