class Solution {
    private class Reserved {
        boolean left;
        boolean middle;
        boolean right;

        Reserved() {
            right = false;
            middle = false;
            left = false;
        }
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int totalGroups = 2 * n;
        Map<Integer, Reserved> map = new HashMap<>();

        for(int[] seats : reservedSeats) {
            int row = seats[0];
            int seat = seats[1];
            
            if(!map.containsKey(row)) {
                map.put(row, new Reserved());
            }
            
            if(seat >= 2 && seat <= 5) {
                map.get(row).left = true;
            }

            if(seat >= 4 && seat <= 7) {
                map.get(row).middle = true;
            }

            if(seat >= 6 && seat <= 9) {
                map.get(row).right = true;
            }
        }

        for(int row : map.keySet()) {
            boolean left = map.get(row).left;
            boolean middle = map.get(row).middle;
            boolean right = map.get(row).right;

            if(left && middle && right) {
                totalGroups -= 2;
            } else if(left || middle || right) {
                totalGroups -= 1;
            }
        }

        return totalGroups;
    }
}