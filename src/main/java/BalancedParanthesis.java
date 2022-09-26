import java.util.Stack;

public class BalancedParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // try switch statment also
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if ((stack.size() > 0) && ((c == '}' && stack.peek() != '{') || ((c == ')') && stack.peek() != '(')
                    || (c == ']' && stack.peek() != '['))) {
                return false;
            } else if (stack.size() > 0) {
                stack.pop();
            } else {
                return false;
            }

        }
        if (stack.size() > 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        BalancedParanthesis balancedParanthesis = new BalancedParanthesis();
        String string = new String();
        System.out.println(balancedParanthesis.isValid(string));
    }
}
