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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
            Input: heads of two sorted linked lists
            Output: head of joined sorted linked list

            Strategy
            - initialize a dummy head, have another reference pointing to it
            - while current node of both linked list are not null
                - if value of node from list 1 <= value of node from list 2
                    - join node from list 1 to the dummy head
                    - advance dummy head and node from list 1
                - else
                    - join node from list 2 to the dummy head
                    - advance dummy head and node from list 2
            - When the while loop end
                - if node from list 1 is not null
                    - join it to dummy head 
                - else if node from list 2 is not null
                    - join it to dummy head
                return copy reference.next
        */
        ListNode dummy = new ListNode();
        ListNode res = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            }else{
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        if(list1 != null) {
            dummy.next = list1;
        }
        if(list2 != null) {
            dummy.next = list2;
        }
        return res.next;
    }
}
