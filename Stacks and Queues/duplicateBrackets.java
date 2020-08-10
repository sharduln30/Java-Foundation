import java.util.Scanner;
import java.util.Stack;

public class duplicateBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            // System.out.println(st);
            char ch = str.charAt(i);
            if(ch==')'){
                if(st.peek()=='('){
                    System.out.println(true);
                    return;
                }
                else {
                    while(st.peek()!='('){
                        // System.out.println(st);
                        st.pop();
                    }
                    st.pop();
                }

            }else{
                st.push(ch);
            }
        }
        System.out.println(false);
        sc.close();             

    }
}