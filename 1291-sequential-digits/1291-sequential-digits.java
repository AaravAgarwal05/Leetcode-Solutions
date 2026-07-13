class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List<Integer> result = new ArrayList<>();

        for(int i = 2; i < 10; i++) {
            for(int j = 0; j + i < 10; j++) {
                int num = Integer.parseInt(s.substring(j, i + j));

                if(num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        return result;
    }
}