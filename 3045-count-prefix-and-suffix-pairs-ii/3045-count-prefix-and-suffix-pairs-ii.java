class Solution {
     private class Node {
        Map<String, Node> map;
        int count;

        Node() {
            map = new HashMap<>();
            count = 0;
        }
    }

    private class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        public int insert(String str) {
            int size = str.length();
            Node curr = root;
            int sum = 0;

            for(int i = 0; i < size; i++) {
                String key = str.charAt(i) + "," + str.charAt(size - i - 1);

                if(!curr.map.containsKey(key)) {
                    curr.map.put(key, new Node());
                }

                curr = curr.map.get(key);
                sum += curr.count;
            }

            curr.count++;
            return sum;
        }
    }

    public long countPrefixSuffixPairs(String[] words) {
        Trie trie = new Trie();
        long count = 0;

        for(String word : words) {
            count += trie.insert(word);
        }

        return count;
    }
}