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
    public ListNode mergeKLists(ListNode[] lists) {
        /*
            Input: array of linked list, each linked list sorted in ascending order
            Output: Head of the merged linked list. Merge them in non decreasing order.

            Question: Are the heads of the linked list arranged in non-decreasing order?
            Doesnt matter, looking at example 1, the subsequent nodes do not preserve the
            order.

            - The list can be empty. The list can also contain an empty list node.

            Strategy TC: O(kn), SC: O(1)
            - scan through every head down the list
            - shortlist the head with the smallest value and the corresponding index in lists
            - join to output list and advance both output list and the shortlisted list.
        */
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode dummyIter = dummyHead;
        
        // Loop will end when dummyIter equals null
        while (dummyIter != null) {
            int smallestVal = Integer.MAX_VALUE;
            int index = Integer.MAX_VALUE;
            for (int i=0; i< lists.length; i++) {
                if (lists[i] != null && lists[i].val <= smallestVal) {
                    smallestVal = lists[i].val;
                    index = i;
                }
            }
            if (index != Integer.MAX_VALUE) {
                dummyIter.next = lists[index];
                lists[index] = lists[index].next;
                
            }
            dummyIter = dummyIter.next;
        }
        return dummyHead.next;

    }
}