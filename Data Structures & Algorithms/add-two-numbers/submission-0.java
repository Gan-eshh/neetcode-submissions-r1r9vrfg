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
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode head = new ListNode(0);
        ListNode root = head;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int dig1 = l1 != null ? l1.val : 0;
            int dig2 = l2 != null ? l2.val : 0;

            int sum = dig1 + dig2 + carry;
            int digit = sum%10;
            carry = sum/10;

            ListNode next = new ListNode(digit);
            root.next = next;
            root = root.next;

            l1 = (l1!=null) ? l1.next : null;
            l2 = (l2!=null) ? l2.next : null;
        }
        return head.next;
    }
}
