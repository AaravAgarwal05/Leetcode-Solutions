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
        int fIdx = -1;
        int lIdx = -1;
        int min = Integer.MAX_VALUE;

        while(next != null) {
            if((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
                if(fIdx == -1) {
                    fIdx = idx;
                } 
                if(lIdx != -1) {
                    min = Math.min(min, idx - lIdx);
                }
                lIdx = idx;
            }

            idx++;
            prev = curr;
            curr = next;
            next = next.next;
        }

        if(fIdx == -1 || lIdx == -1 || min == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{min, lIdx - fIdx};
    }
}