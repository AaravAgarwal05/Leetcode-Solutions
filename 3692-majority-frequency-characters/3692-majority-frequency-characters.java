class Solution {
    public String majorityFrequencyGroup(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, List<Character>> group = new HashMap<>();
        List<Character> maxGroup = new ArrayList<>();
        int size = 0;
        int freq = 0;
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch : map.keySet()) {
            if(!group.containsKey(map.get(ch))) {
                group.put(map.get(ch), new ArrayList<>());
            }

            group.get(map.get(ch)).add(ch);
        }

        for(int f : group.keySet()) {
            if(group.get(f).size() > size || (group.get(f).size() == size && f > freq)) {
                maxGroup = group.get(f);
                size = maxGroup.size();
                freq = f;
            }
        }

        for(char ch : maxGroup) {
            sb.append(ch);
        }

        return sb.toString();
    }
}