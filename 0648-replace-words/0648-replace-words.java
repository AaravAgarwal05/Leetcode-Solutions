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

        public int search(String str) {
            TrieNode curr = root;

            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if(curr.children[ch - 'a'] == null) {
                    return -1;
                }

                curr = curr.children[ch - 'a'];
                
                if(curr.end) {
                    return i;
                }
            }

            return -1;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        for(String word : dictionary) {
            trie.insert(word);
        }

        StringBuilder sb = new StringBuilder();

        for(String word : sentence.split(" ")) {
            int res = trie.search(word);
            if(res == -1) {
                sb.append(word);
            } else {
                sb.append(word.substring(0, res + 1));
            }

            sb.append(" ");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}