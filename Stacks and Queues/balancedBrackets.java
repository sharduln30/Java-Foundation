import java.util.Scanner;
import java.util.Stack;

public class balancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==')'){
                if(st.size()>0 && st.peek()=='('){
                    st.pop();
                }else{
                    System.out.println(false);
                    return;
                }
            }else if(ch=='}'){
                if(st.size()>0 && st.peek()=='{'){
                    st.pop();
                }else{
                    System.out.println(false);
                    return;
                }
            }else if(ch==']'){
                if(st.size()>0 && st.peek()=='['){
                    st.pop();
                }else{
                    System.out.println(false);
                    return;
                }
            }else if(ch=='(' || ch=='[' || ch=='{'){
                st.push(ch);
            }
        }
              if(st.size()==0) System.out.println(true);
              else System.out.println(false);
              sc.close();             

    }
}