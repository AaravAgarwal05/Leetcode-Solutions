class Solution {
    private class TrieNode {
        TrieNode[] children;
        boolean end;

        TrieNode() {
            children = new TrieNode[26];
            end = false;
        }
    }

    private class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String str) {
            TrieNode curr = root;

            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if(curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode();
                }

                curr = curr.children[ch - 'a'];
            }

            curr.end = true;
        }

        public boolean search(String str, int maxRep) {
            TrieNode curr = root;
            return dfs(root, str, maxRep, 0);
        }

        private boolean dfs(TrieNode node, String str, int reps, int idx) {
            if(idx == str.length() && reps >= 0 && node.end) {
                return true;
            }

            if(reps < 0) {
                return false;
            }

            for(int i = 0; i < 26; i++) {
                if(node.children[i] == null) {
                    continue;
                }

                if(i == (str.charAt(idx) - 'a') && dfs(node.children[i], str, reps, idx + 1)) {
                    return true;
                } else if(dfs(node.children[i], str, reps - 1, idx + 1)){
                    return true;
                }
            }

            return false;
        }
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        Trie trie = new Trie();

        for(String word : dictionary) {
            trie.insert(word);
        }

        for(String word : queries) {
            if(trie.search(word, 2)) {
                res.add(word);
            }
        }

        return res;
    }
}