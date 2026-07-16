class Solution {
    public List<String> letterCombinations(String digits) {
        int l = digits.length();
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        for(char ch : map.get(digits.charAt(0) - '0')) {
            queue.add(Character.toString(ch));
        }

        int cSize = queue.size();

        for(int i = 1; i < l; i++) {
            for(int j = 0; j < cSize; j++) {
                String curr = queue.poll();
                for(char ch : map.get(digits.charAt(i) - '0')) {
                    queue.add(curr + Character.toString(ch));
                }
            }

            cSize = queue.size();
        }

        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}