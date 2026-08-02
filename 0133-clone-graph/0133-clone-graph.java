/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }

        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        map.put(node.val, new Node(node.val));
        q.add(node);

        while(!q.isEmpty()) {
            Node curr = q.poll();

            for(Node neigh : curr.neighbors) {
                if(!map.containsKey(neigh.val)) {
                    map.put(neigh.val, new Node(neigh.val));
                    q.offer(neigh);
                }

                map.get(curr.val).neighbors.add(map.get(neigh.val));
            }
        }
        
        return map.get(node.val);
    }
}