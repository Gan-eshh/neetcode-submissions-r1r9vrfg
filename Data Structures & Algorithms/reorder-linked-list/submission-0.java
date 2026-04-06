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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return ;
        
        // 1.Find the middle node
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2.reverse from middle
        ListNode prev = null;
        ListNode cur = slow.next;
        slow.next = null;

        while(cur!= null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        //3.merge into 1

        ListNode fir = head;
        ListNode sec = prev;

        while(sec!=null){
            ListNode t1 = fir.next;
            ListNode t2 = sec.next;

            fir.next = sec;
            sec.next = t1;

            fir = t1;
            sec = t2;
        } 
    }
}
