package stringTest;

import java.util.Stack;

public class BallancedString {

	public static void main(String args[]) {
        if(args.length != 0) {
            if(isBalanced(args[0]) == 1)
                System.out.println(args[0] + " is balanced");
            else
                System.out.println(args[0] + " is not balanced");
        }
	}

    static int isBalanced(String in){
        Stack<Character> st = new Stack<Character>();

        for(char chr : in.toCharArray())
        {
            switch(chr) {

                case '{':
                case '(':
                case '[':
                    st.push(chr);
                    break;

                case ']':
                    if(st.isEmpty() || st.pop() != '[') 
                        return -1;
                    break;
                case ')':
                    if(st.isEmpty() || st.pop() != '(')
                        return -1;
                    break;
                case '}':
                    if(st.isEmpty() || st.pop() != '{')
                        return -1;
                    break;
            }
        }
        if(!st.isEmpty()){
        	return -1;
        }else{
        	return 1;
        }
    }
    
}

