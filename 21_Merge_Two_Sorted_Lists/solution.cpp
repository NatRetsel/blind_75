**
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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        /*
            Inputs: head of linked list list1 and list2
            Output: head of the merged linked list

            Have a dummy head for ease of returning the start of the linked list
            - compare the values of the two nodes from each list
            while node 1 and node 2:
            - if node 1 <= node 2:
                - add node 1 to the dummy head
                - progress node 1
            - else
                - add node 2 to the dummy head
                - progress node 2
            after exiting the loop, check for remaining nodes either in list 1 or list 2 and append it to dummy head

            ListNode *dummy = new ListNode(0);
            ListNode *curr = dummy;
            while (list1 && list2) {
                if (list1->val <= list2->val) {
                    curr->next = list1;
                    curr = curr->next;
                    list1 = list1->next;
                }else{
                    curr->next = list2;
                    curr = curr->next;
                    list2 = list2->next;
                }
            }
            if(list1){
                curr->next = list1;
            }else if(list2){
                curr->next = list2;
            }
            return dummy->next;

                

        */
        ListNode temp = ListNode(0);
        ListNode *dummy = &temp;
        ListNode *curr = dummy;
        while (list1 && list2) {
            if (list1->val <= list2->val) {
                curr->next = list1;
                curr = curr->next;
                list1 = list1->next;
            }else{
                curr->next = list2;
                curr = curr->next;
                list2 = list2->next;
            }
        }
        if(list1){
            curr->next = list1;
        }else if(list2){
            curr->next = list2;
        }
        return dummy->next;
    }
};