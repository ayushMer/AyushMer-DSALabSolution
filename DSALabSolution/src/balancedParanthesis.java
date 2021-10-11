import java.util.*;
 
public class balancedParanthesis {
 
    // function to check if brackets are balanced or not
    static boolean areAllBracketsBalanced(String str)
    {
        Deque<Character> stack
            = new ArrayDeque<Character>();
 
        // Traversing the Expression
        for (int i = 0; i < str.length(); i++)
        {
            char x = str.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
 
            // If current character is not opening bracket, then it should be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 
        // Check Empty Stack
        return (stack.isEmpty());
    }
 
   //main
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
    	System.out.println("Please enter the input for parenthesis balance check");
        String str = sc.next();
 
        // Function call
        if (areAllBracketsBalanced(str))
            System.out.println("The entered String has Balanced Brackets");
        else
            System.out.println("The entered Strings do not contain Balanced Brackets");
    }
}