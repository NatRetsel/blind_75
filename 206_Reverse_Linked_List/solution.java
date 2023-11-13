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
    public ListNode reverseList(ListNode head) {
        /*
            Input: head of linkedlist
            output: head of reversed linked list

            Strategy
            1.) Array and reverse: TC: O(2n), SC: O(n)
                - Loop original linked list once, storing each node sequentially in an array
                - Second pass using the array from the end, link them up
            
            2.) Reverse in place: TC: O(n), SC:O(1)
                - One pointer pointer at the next node
                - one pointer pointing at previous
                - one pointer pointing at current node
                - Upon advancing a new node
                    - next points to next node of the current node
                    - current.next points to previous
                    - previous assign to current
                    - current assign to next node
        */
        ListNode curr = head;
        ListNode next;
        ListNode prev = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
