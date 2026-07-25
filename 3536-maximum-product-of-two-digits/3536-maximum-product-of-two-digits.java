class Solution {
    public int maxProduct(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        
        while(n > 0) {
            map.put(n % 10, map.getOrDefault(n % 10, 0) + 1);
            n /= 10;
        }

        int product = 1;

        for(int i = 9; i >= 0; i--) {
            if(map.containsKey(i)) {
                product *= i;
                if(map.get(i) == 1) {
                    map.remove(i);
                }
                break;
            }
        }

        for(int i = 9; i >= 0; i--) {
            if(map.containsKey(i)) {
                product *= i;
                break;
            }
        }

        return product;
    }
}