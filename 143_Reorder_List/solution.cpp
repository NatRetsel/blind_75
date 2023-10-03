/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void reorderList(ListNode* head) {
        /*
            Input: ListNode* head head of linked list
            Output: Reorder the linked list in-place

            Strategy
            1.) Array with nodes as elements TC: O(n), SC: O(n)
                - This way we can easily reorder them with easy access through array index
                - Loop entire linked list once, during which we push each node into a vector
                - Have two pointers, one at the start and one at the end of the vector, rearrange the linkedlist
                    while left_ptr < right_ptr
                    - vector[left_ptr].next = vector[right_ptr]
                    - left_ptr ++;
                    - vector[right_ptr].next = vector[left_ptr]
                    - right_ptr --;

            2.) Reverse the latter half of the linked list and join TC: O(n), SC:O(1)
                - Use fast and slow pointer to identify the midpoint of the linkedlist
                    - begin both at head, fast goes 2 nexts and slow goes one next. terminate when fast->next is nullptr
                    - slow will be pointing at mid point. Have another variable to mark it
                - reverse the list from slow onwards
                    - example 1
                    - 1->2, 5->4->3
                - rearrange
                    - 1->5->2->4->3
                    - Alternate joins
        */
        ListNode* fast = head;
        ListNode* slow = head;
        ListNode* prev = nullptr;
        ListNode* temp = nullptr;
        ListNode* temp2 = nullptr;

        while (fast && fast->next) {
            fast = fast->next->next;
            prev = slow;
            slow = slow->next;
        }

        // now slow pointer is at the midpoint
        // sever the list apart
        // we progress one more to avoid having to deal with the case where the left half is smaller than right half, we missed a node
        prev = slow;
        slow = slow->next;
        prev->next = nullptr;

        // reverse latter half of the linked list
        prev = nullptr;
        while (slow) {
            temp = slow->next;
            slow->next = prev;
            prev = slow;
            slow = temp;
        }

        // Now prev will be the start of the reversed linked list
        // we now reorder the list
        slow = head;
        while (slow && prev) {
            temp = slow->next;
            temp2 = prev->next;
            slow->next = prev;
            prev->next = temp;
            slow = temp;
            prev = temp2;
        }
        return;
    }
};