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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
            Input: head of linked list, integer n
            Output: Head of linked list with nth node from the end removed

            Strategy
            1.) Two pass TC: O(2n), SC:O(1)
                - first pass to note the total number of nodes
                - second pass to remove node

            2.) One pass -> maintain gap of n between two pointers iterating the linked list
                - We want slow pointer to be at one node before target node to be removed.
                - We want fast pointer to be one node after the last node (null)
                - There will be n nodes between slow and fast
                - We will make use of a dummy head that links to head
                - slow pointer starts at dummy head and fast pointer maintains n gap.
                - i.
                    - while (fast and count < n)
                        - fast = fast.next
                - ii.
                    - while (fast) {
                        fast = fast.next;
                        slow = slow.next;
                    }
                - iii.
                    - slow.next = slow.next.next
                - return head
        */
        ListNode dummyHead = new ListNode(0, head);
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        int count = 0;

        while (fast != null && count <= n) {
            fast = fast.next;
            ++count;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;


        
    }
}