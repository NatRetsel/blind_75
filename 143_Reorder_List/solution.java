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
        /*
            Input: head of linked list
            Output: head of reordered linked list

            Sample test case
            1.) head = [1,2,3,4]; Output = [1,4,2,3]
            2.) head = [1,2,3,4,5]; Output = [1,5,2,4,3]

            Strategy TC: O(2n), SC:O(1)
            - Find the middle of the linked list; following 0 indexing, n//2
                - fast and slow pointer
                - both begins at head
                - fast moves 2 nodes, slow moves one
                - repeat as long as fast and fast.next are not null
            - reverse the latter half of the linked list in place.
                - pointer referencing next of current node
                - pointer referencing previous node
                - pointer to current node
                - next = current.next
                - current node.next = prev
                - prev = current
                - current = next
            - join the linked list together
                - Alternate nodes between the two list
        */
        ListNode fast = head;
        ListNode slow = head;
        ListNode dummyHead = head;
        ListNode prev = null;
        ListNode next;
        ListNode prevNext;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        
        next = slow.next;
        slow.next = null;
        slow = next;
        
        // Reverse from slow to end
        
        while (slow !=  null) {
            next = slow.next;
            slow.next = prev;
            prev = slow; // prev will be at the last node
            slow = next;
        }
        
        // join nodes
        while (prev != null) {
            next = dummyHead.next;
            dummyHead.next = prev;
            prevNext = prev.next;
            prev.next = next;
            dummyHead = next;
            prev = prevNext;
        }
        
    }
}
