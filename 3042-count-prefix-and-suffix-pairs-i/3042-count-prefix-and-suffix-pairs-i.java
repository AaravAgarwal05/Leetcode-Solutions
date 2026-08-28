class Solution {
     private class Node {
        Node[] child;
        int count;

        Node() {
            child = new Node[27];
            count = 0;
        }
    }

    private class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        public void insert(String str) {
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
                    curr.count++;
                }
            }
        }

        public int search(String str) {
            int size = str.length();
            Node curr = root;

            for(int i = 0; i < size; i++) {
                char ch = str.charAt(i);

                if(curr.child[ch - 'a'] == null) {
                    return 0;
                }

                curr = curr.child[ch - 'a'];
            }

            return curr.count;
        }
    }

    public int countPrefixSuffixPairs(String[] words) {
        Trie trie = new Trie();
        int count = 0;

        for(int i = words.length - 1; i >= 0; i--) {
            count += trie.search(words[i] + "{" + words[i]);
            trie.insert(words[i]);
        }

        return count;
    }
}