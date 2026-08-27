class Trie {
    private class Node {
        int freq;
        boolean end;
        Node[] childNodes;

        Node() {
            freq = 0;
            this.end = false;
            childNodes = new Node[26];
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        int size = word.length();
        Node curr = root;
        
        for(int i = 0; i < size; i++) {
            char ch = word.charAt(i);

            if(curr.childNodes[ch - 'a'] == null) {
                curr.childNodes[ch - 'a'] = new Node();
            }

            curr = curr.childNodes[ch - 'a'];
        }

        curr.end = true;
    }
    
    public boolean search(String word) {
        int size = word.length();
        Node curr = root;
            
        for(int i = 0; i < size; i++) {
            char ch = word.charAt(i);

            if(curr.childNodes[ch - 'a'] == null) {
                return false;
            }

            curr = curr.childNodes[ch - 'a'];
        }

        return curr.end;
    }
    
    public boolean startsWith(String prefix) {
        int size = prefix.length();
        Node curr = root;
            
        for(int i = 0; i < size; i++) {
            char ch = prefix.charAt(i);

            if(curr.childNodes[ch - 'a'] == null) {
                return false;
            }

            curr = curr.childNodes[ch - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */