class Solution {
    public String sortString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        String f = "abcdefghijklmnopqrstuvwxyz";
        int dir = 1;
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        while(map.keySet().size() > 0) {
            if(map.containsKey(f.charAt(counter))) {
                sb.append(f.charAt(counter));
                map.put(f.charAt(counter), map.get(f.charAt(counter)) - 1);
                if(map.get(f.charAt(counter)) == 0) {
                    map.remove(f.charAt(counter));
                }
            }
            counter += dir;
            if(counter == 26) {
                dir = -1;
                counter = 25;
            }
            if(counter == -1) {
                dir = 1;
                counter = 0;
            }
        }
        return sb.toString();
    }
}