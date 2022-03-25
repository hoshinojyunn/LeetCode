package primaryAlgorithm;

import java.util.EmptyStackException;
import java.util.Stack;

public class BracketMatching {
    public boolean isValid(String s) {
        if(s.length()%2!=0)
            return false;
//        if(s.startsWith(")")||s.startsWith("}")||s.startsWith("]"))
//            return false;
        Stack<String>stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{'||c == '['||c=='('){
                stack.push(String.valueOf(c));
            }else{
                try {
                    String pop = stack.pop();

                    if (pop.equals("{") && c != '}')
                        return false;
                    if (pop.equals("[") && c != ']')
                        return false;
                    if (pop.equals("(") && c != ')')
                        return false;
                }catch (EmptyStackException ignored){
                        return false;
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}
