class WordFilter {
    private class Node {
        Node[] child;
        boolean end;
        List<Integer> indices;

        Node() {
            child = new Node[27];
            end = false;
            indices = new ArrayList<>();
        }
    }

    private class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        public void insert(String str, int idx) {
            int size = str.length();

            for(int i = 0; i < size; i++) {
                String temp = str.substring(i) + "{" + str;
                int cSize = temp.length();
                Node curr = root;

                for(int j = 0; j < cSize; j++) {
                    char ch = temp.charAt(j);

                    if(curr.child[ch - 'a'] == null) {
                        curr.child[ch - 'a'] = new Node();
                    }
                    
                    curr = curr.child[ch - 'a'];
                    curr.indices.add(idx);
                }

                curr.end = true;
            }
        }

        public int search(String str) {
            int size = str.length();
            Node curr = root;

            for(int i = 0; i < size; i++) {
                char ch = str.charAt(i);

                if(curr.child[ch - 'a'] == null) {
                    return -1;
                }

                curr = curr.child[ch - 'a'];
            }

            return curr.indices.get(curr.indices.size() - 1);
        }
    }

    Trie trie;

    public WordFilter(String[] words) {
        trie = new Trie();

        for(int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }
    }
    
    public int f(String pref, String suff) {
        return trie.search(suff + "{" + pref);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */