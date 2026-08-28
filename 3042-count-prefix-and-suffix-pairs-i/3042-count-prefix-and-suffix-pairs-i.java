class Solution {
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

        public List<Integer> search(String str) {
            int size = str.length();
            Node curr = root;

            for(int i = 0; i < size; i++) {
                char ch = str.charAt(i);

                if(curr.child[ch - 'a'] == null) {
                    return new ArrayList<>();
                }

                curr = curr.child[ch - 'a'];
            }

            return curr.indices;
        }
    }

    public int countPrefixSuffixPairs(String[] words) {
        Trie trie = new Trie();

        for(int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }

        int count = 0;

        for(int i = 0; i < words.length; i++) {
            List<Integer> res = trie.search(words[i] + "{" + words[i]);

            for(int idx : res) {
                if(idx > i) {
                    count++;
                }
            }
        }

        return count;
    }
}