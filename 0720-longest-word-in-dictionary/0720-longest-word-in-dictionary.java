class Solution {
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

            for(int i = 0; i < size; i++) {
                char ch = str.charAt(i);

                if(curr.child[ch - 'a'] == null) {
                    curr.child[ch - 'a'] = new Node();
                }

                curr = curr.child[ch - 'a'];
            }

            curr.end = true;
        }
    }

    String ans = "";

    public String longestWord(String[] words) {
        Trie trie = new Trie();

        for(String word : words) {
            trie.insert(word);
        }

        dfs(trie.root, new StringBuilder());
        return ans;
    }

    private void dfs(Node node, StringBuilder sb) {
        if(sb.length() > ans.length() || (sb.length() == ans.length() && sb.toString().compareTo(ans) < 0)) {
            ans = sb.toString();
        }

        for(int i = 0; i < 26; i++) {
            if(node.child[i] != null && node.child[i].end) {
                sb.append((char)('a' + i));
                dfs(node.child[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}