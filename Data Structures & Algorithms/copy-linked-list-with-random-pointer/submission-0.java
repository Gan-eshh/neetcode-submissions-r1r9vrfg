/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)    return null;
        Node cur = head;

        while(cur != null){
            Node cp = new Node(cur.val);
            cp.next = cur.next;
            cur.next = cp;
            cur = cp.next;
        }

        cur = head;

        while(cur != null  ){
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node newHead = head.next;
        Node cpcur = head.next;

        while(cur != null){
            cur.next = cur.next.next;

            if(cpcur.next != null)
                cpcur.next = cpcur.next.next;

            cur = cur.next;
            cpcur = cpcur.next;
        }
        return newHead;
    }
}
