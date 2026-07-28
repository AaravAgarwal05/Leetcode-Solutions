/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        for(int i = 0; i < list.size(); i += k) {
            if(i + k - 1 < list.size()) {
                reverse(list, i, i + k - 1);
            }
        }
        ListNode curr = new ListNode();
        head = curr;
        for(int x : list) {
            curr.next = new ListNode(x);
            curr = curr.next;
        }
        return head.next;
    }

    public void reverse(List<Integer> list, int s, int e) {
        while(s < e) {
            int temp = list.get(s);
            list.set(s, list.get(e));
            list.set(e, temp);
            s++;
            e--;
        }
    }
}