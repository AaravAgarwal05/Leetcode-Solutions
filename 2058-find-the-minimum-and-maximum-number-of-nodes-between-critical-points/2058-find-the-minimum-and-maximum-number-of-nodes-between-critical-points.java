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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        int idx = 1;

        while(next != null) {
            if((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
                list.add(idx);
            }

            idx++;
            prev = curr;
            curr = next;
            next = next.next;
        }

        if(list.size() < 2) {
            return new int[]{-1, -1};
        }

        if(list.size() == 2) {
            int val = list.get(1) - list.get(0);
            return new int[]{val, val};
        }

        int max = list.get(list.size() - 1) - list.get(0);
        int min = Integer.MAX_VALUE;

        for(int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }

        return new int[]{min, max};
    }
}