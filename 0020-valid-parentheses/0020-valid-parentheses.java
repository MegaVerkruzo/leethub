class Solution {
    private boolean isOpenBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }
    
    private boolean checkEqualityType(char a, char b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (isOpenBracket(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.size() > 0 && checkEqualityType(stack.peek(), s.charAt(i))){
                stack.pop();
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}