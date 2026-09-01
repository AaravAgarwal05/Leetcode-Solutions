class MagicDictionary {
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

        public boolean search(String str, int rep) {
            TrieNode curr = root;
            return dfs(root, str, rep, 0);
        }

        private boolean dfs(TrieNode node, String str, int rep, int idx) {
            if(idx == str.length() && rep == 0 && node.end) {
                return true;
            }

            if(idx == str.length()) {
                return false;
            }

            if(rep < 0) {
                return false;
            }

            for(int i = 0; i < 26; i++) {
                if(node.children[i] == null) {
                    continue;
                }

                if(i == str.charAt(idx) - 'a') {
                    if(dfs(node.children[i], str, rep, idx + 1)) {
                        return true;
                    }
                } else {
                    if(dfs(node.children[i], str, rep - 1, idx + 1)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    Trie trie;

    public MagicDictionary() {
        trie = new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        for(String word : dictionary) {
            trie.insert(word);
        }
    }
    
    public boolean search(String searchWord) {
        return trie.search(searchWord, 1);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */