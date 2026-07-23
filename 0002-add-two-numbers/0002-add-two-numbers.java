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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result = new ListNode();
        ListNode temp = result;

        while(p1 != null && p2 != null) {
            sum = p1.val + p2.val + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while(p1 != null) {
            sum = p1.val + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            p1 = p1.next;
        }

        while(p2 != null) {
            sum = p2.val + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            p2 = p2.next;
        }

        if(carry > 0) {
            temp.next = new ListNode(carry);
        }

        return result.next;
    }
}