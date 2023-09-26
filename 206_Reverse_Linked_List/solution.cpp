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
    ListNode* reverseList(ListNode* head) {
        /*
            Input: head of a singly linked list
            Output: head of reversed linked list

            Strategy
            1.) Array to store the position and nodes of the linked list then reverse it O(2n) time, O(n) space

                std::vector <ListNode*>  position;
                ListNode* curr = head;
            
                while (curr){
                    position.push_back(curr);
                    curr = curr->next;
                }
                for (int i = position.size()-1; i >0; i--){
                    position[i]->next = position[i-1];
                }
                if (!position.empty()){
                    position[0]->next = nullptr;
                    return position[position.size()-1];
                }
                return nullptr;


            2.) Reverse inplace
                ListNode* curr = head;
                ListNode* prev = nullptr;
                ListNode* temp = nullptr;
                while (curr) {
                    temp = curr->next;
                    curr->next = prev;
                    prev = curr;
                    curr = temp;
                }
                return prev;


        */
        ListNode* curr = head;
        ListNode* prev = nullptr;
        ListNode* temp = nullptr;
        while (curr) {
            temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
        
        
    }
};