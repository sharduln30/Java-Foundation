import java.util.Scanner;
import java.util.Stack;

public class smallestNumberFollowingPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Integer> st = new Stack<>();
        int n=1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch=='d'){
                st.push(i+1);
                n++;
            }else{
                st.push(i+1);
                while(st.size()>0){
                    System.out.print(st.pop());
                }
                n++;
            }
        }
        System.out.print(n);
        
        while(st.size()>0){
            System.out.print(st.pop());
        }
        
        sc.close();
    }
}