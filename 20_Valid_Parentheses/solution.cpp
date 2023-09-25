class Solution {
public:
    bool isValid(string s) {
        /*
            Input: string s
            Output: boolean true if the input string is valid

            is valid
                - open brackets must be closed buy the same type
                - open brackets must be closed in the correct order - in to out
                - every close bracket has a corresponding open bracket of the same type

            Sample test case
            1.) s = ()
                - ( is closed by )
                - closed in the correct order
                - ) has a corresponding open bracket (
            
            2.) s = ()[]{}
                - (is closed by), [is closed by], {is closed by}
                - brackets are closed in correct order
                - every closed has a correpsonding open bracket of the same type
            
            3.) [(())()], true

            Strategy
            - innermost bracket are closed first, let's use a stack
            - if we encounter open brackets, add to stack
            - if we encounter closed brackets
                - if top of stack is the corresponding open bracket, pop from stack
                - if top of stack is not the corresponding open bracket, return false
            - If we loop till the end and stack is not empty, return false
            - return true otherwise
            - let's have a hashmap to map the close bracket to the corresponding open bracket

        */
        std::unordered_map<char, char>brackets = {{')','('},{'}','{'},{']','['}};
        std::vector<char>stack;
        for (char b:s){
            if (brackets.find(b) == brackets.end()){
                stack.push_back(b);
            }else if (!stack.empty() && brackets[b] == stack.back()){
                stack.pop_back();
            }else{
                return false;
            }
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
};