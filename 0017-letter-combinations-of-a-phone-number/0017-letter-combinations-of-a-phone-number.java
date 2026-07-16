class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        Queue<String> q = new LinkedList<>();
        for(char x : map.get(digits.charAt(0) - '0')) {
            q.add(Character.toString(x));
        }

        int n = q.size();

        for(int i = 1; i < digits.length(); i++) {
            for(int j = 0; j < n; j++) {
                String temp = q.poll();
                for(char k : map.get(digits.charAt(i) - '0')) {
                    q.add(temp + Character.toString(k));
                }
            }
            n = q.size();
        }

        List<String> list = new ArrayList<>();
        while(!q.isEmpty()) {
            list.add(q.poll());
        }

        return list;
    }
}