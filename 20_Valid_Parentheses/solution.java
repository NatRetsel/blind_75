class Solution {
    public boolean isValid(String s) {
        /*
            Input: String s
            Output: Boolean true if the input string is valid, false otherwise

            Is valid: 
            1.) open brackets must be closed by the same type of brackets
            2.) open brackets must be closed in the correct order.
            3.) Every close bracket has a corresponding open bracket of the same type

            Strategy
            1.) Stack
            - Iterate string by character from left to right
            - If we encounter open bracket, add into stack
            - If we encounter close bracket, 
                - pop top of stack (close bracket must close this open bracket)
                - if they don't match OR if stack is empty, return false
                - else continue
        */
        HashMap<Character, Character> brackets = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        Stack<Character> stack = new Stack<Character> ();
        char open;
        for (int i=0; i< s.length(); i++) {
            if (!brackets.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            }else{
                if (stack.empty() || stack.peek() != brackets.get(s.charAt(i))) return false;
                stack.pop();
            }
        }
        return stack.empty();
    }
}
