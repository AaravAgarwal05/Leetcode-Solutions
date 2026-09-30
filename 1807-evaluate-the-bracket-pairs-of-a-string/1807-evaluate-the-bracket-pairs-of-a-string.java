class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        for(List<String> know : knowledge) {
            map.put(know.get(0), know.get(1));
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while(idx < s.length()) {
            if(s.charAt(idx) == '(') {
                StringBuilder temp = new StringBuilder();
                idx++;

                while(s.charAt(idx) != ')') {
                    temp.append(s.charAt(idx++));
                }

                sb.append(map.getOrDefault(temp.toString(), "?"));
            } else {
                sb.append(s.charAt(idx));
            }

            idx++;
        }

        return sb.toString();
    }
}