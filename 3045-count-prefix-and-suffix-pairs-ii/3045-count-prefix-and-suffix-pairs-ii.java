class Solution {
     private class TrieNode {
        Map<Integer, TrieNode> children;
        int count;

        TrieNode() {
            children = new HashMap<>();
            count = 0;
        }
    }

    private class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public int insert(String str) {
            int size = str.length();
            TrieNode curr = root;
            int sum = 0;

            for(int i = 0; i < size; i++) {
                int key = str.charAt(i) * 26 + str.charAt(size - i - 1);
                curr.children.putIfAbsent(key, new TrieNode());
                curr = curr.children.get(key);
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