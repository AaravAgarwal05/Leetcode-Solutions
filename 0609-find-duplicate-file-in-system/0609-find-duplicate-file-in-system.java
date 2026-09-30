class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for(String path : paths) {
            String[] tokens = path.split(" ");

            for(int i = 1; i < tokens.length; i++) {
                String p1 = tokens[i].split("\\(")[0];
                String data = tokens[i].split("\\(")[1];

                map.putIfAbsent(data, new ArrayList<>());
                map.get(data).add(tokens[0] + "/" + p1);
            }
        }
        
        List<List<String>> result = new ArrayList<>();

        for(String key : map.keySet()) {
            if(map.get(key).size() > 1) {
                result.add(map.get(key));
            }
        }

        return result;
    }
}