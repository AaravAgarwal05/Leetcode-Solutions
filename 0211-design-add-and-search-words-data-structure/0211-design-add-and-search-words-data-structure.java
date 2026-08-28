class WordDictionary {
    private class Node {
        Node[] child;
        boolean end;

        Node() {
            child = new Node[26];
            end = false;
        }
    }

    private class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        public void insert(String str) {
            int size = str.length();
            Node curr = root;

            for (int i = 0; i < size; i++) {
                char ch = str.charAt(i);

                if (curr.child[ch - 'a'] == null) {
                    curr.child[ch - 'a'] = new Node();
                }

                curr = curr.child[ch - 'a'];
            }

            curr.end = true;
        }

        public boolean search(String str) {
            return dfs(root, str);
        }

        private boolean dfs(Node node, String str) {
            int size = str.length(); 
            Node curr = node;

            for(int i = 0; i < size; i++) {
                char ch = str.charAt(i);

                if(ch == '.') {
                    for(int j = 0; j < 26; j++) {
                        if(curr.child[j] == null) {
                            continue;
                        }

                        if(dfs(curr.child[j], str.substring(i + 1))) {
                            return true;
                        }
                    }

                    return false;
                } else {
                    if(curr.child[ch - 'a'] == null) {
                        return false;
                    }

                    curr = curr.child[ch - 'a'];
                }
            }

            return curr.end;
        }
    }

    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return trie.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */